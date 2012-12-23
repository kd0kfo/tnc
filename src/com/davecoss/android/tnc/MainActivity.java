package com.davecoss.android.tnc;

import com.davecoss.android.tnc.MorseCoder;
import com.davecoss.android.lib.Notifier;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
//import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    // originally from http://marblemice.blogspot.com/2010/04/generate-and-play-tone-in-android.html
    // and modified by Steve Pomeroy <steve@staticfree.info>
	// and modified by David Coss, PhD <david@davecoss.com>
	private final double TWO_PI = 2 * Math.PI;
    private final double duration = 0.05; // seconds
    private final int sampleRate = 12000;
    private final int numSamples = (int)Math.ceil(duration * sampleRate);
    private final double default_freq = 440.0;// in Hz
    private byte tone_array[];
    private byte long_tone_array[];
    private byte silence_array[];
    private AudioTrack tone;
    private Notifier notifier;
    private AudioManager am;
	
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        notifier = new Notifier(getApplicationContext());
        EditText txt_frequency = (EditText) findViewById(R.id.txt_frequency);
        txt_frequency.setText(Double.toString(default_freq));
        Context context = this.getApplicationContext();
    	am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }
    
    @Override
    protected void onResume() 
    {
        super.onResume();
        setup_tone();
    }
    
    @Override
    protected void onPause()
    {
    	super.onPause();
    	tone.release();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    private void dit()
    {
    	if(tone == null || tone_array == null || silence_array == null)
    		return;
    	tone.play();
		tone.write(tone_array, 0, tone_array.length);
		tone.stop();
    }
    
    private void dah()
    {
    	if(tone == null || long_tone_array == null || silence_array == null)
    		return;
    	tone.play();
    	tone.write(long_tone_array, 0, long_tone_array.length);
		tone.stop();
    }
    
    private void gap()
    {
    	if(tone == null || long_tone_array == null || silence_array == null)
    		return;
    	tone.play();
    	tone.write(silence_array, 0, silence_array.length);
		tone.stop();
    }
    
    private void eol()
    {
    	if(tone == null || silence_array == null)
    		return;
    	tone.play();
    	tone.write(silence_array, 0, silence_array.length);
    	tone.write(silence_array, 0, silence_array.length);
    	tone.write(silence_array, 0, silence_array.length);
    	tone.stop();
    }
    
    private void eow()
    {
    	eol();eol();
    }

    private void play_pattern(MorseBit pattern[])
    {
    	if(pattern == null)
    		return;
    	
    	for(int i = 0;i<pattern.length;i++)
    	{
    		switch(pattern[i])
    		{
    		case DIT:
    			dit();
    			break;
    		case DAH:
    			dah();
    			break;
    		case GAP:
    			gap();
    			break;
    		case LETTER_GAP:
    			eol();
    			break;
    		case WORD_GAP:
    			eow();
    			break;
			default:
				break;
    		}
    	}
    }
    
    private int counter = 0;
    public void soundTone(View view)
    {
    	ToggleButton btn = (ToggleButton) findViewById(R.id.btn_tone);
    	MorseBit pattern[];
    	if(btn.isChecked())
    	{
    		if(counter % 2 == 0)
    		{
    			pattern = MorseCoder.pattern("SOS");
    		}
    		else
    		{
    			pattern = MorseCoder.pattern("Hi");
    		}
    		if(pattern != null)
    			play_pattern(pattern);
    		counter++;
    	}
    }
    
    byte[] genTone(int numSamples, double freq_hz)
    {
    	double sample[] = new double[numSamples];
        byte pcm_array[] = new byte[2*numSamples];
    	if(pcm_array.length == 0)
    		return null;
    	
        // fill out the array
        for (int i = 0; i < numSamples; ++i) {
            sample[i] = Math.sin( TWO_PI * i / (sampleRate/freq_hz));
        }

        // convert to 16 bit pcm sound array
        // assumes the sample buffer is normalised.
        int idx = 0;
        for (final double dVal : sample) {
            // scale to maximum amplitude
            final short val = (short) ((dVal * 32767));
            // in 16 bit wav PCM, first byte is the low order byte
            pcm_array[idx++] = (byte) (val & 0x00ff);
            pcm_array[idx++] = (byte) ((val & 0xff00) >>> 8);
            
        }
        
        return pcm_array;
    }
    
    AudioTrack genTrack(double freq_hz)
    {
    	tone_array = genTone(numSamples,freq_hz);
    	silence_array = new byte[tone_array.length];
    	for(int i = 0;i<silence_array.length;i++)
    		silence_array[i] = 0;
        long_tone_array = new byte[3*tone_array.length];
    	for (int i = 0; i < (long_tone_array.length); i++) 
    	{
            long_tone_array[i] = tone_array[i % tone_array.length];
    	}
        AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                sampleRate, AudioFormat.CHANNEL_CONFIGURATION_MONO,
                AudioFormat.ENCODING_PCM_16BIT, tone_array.length,
                AudioTrack.MODE_STREAM);
        
        audioTrack.setStereoVolume(1, 1);
        audioTrack.play();
        audioTrack.write(tone_array, 0, tone_array.length);
        
        return audioTrack;
    }
    
    void setup_tone()
    {
	    EditText txt_frequency = (EditText) findViewById(R.id.txt_frequency);
	    double freq = Double.valueOf(txt_frequency.getText().toString());
	    tone = genTrack(freq);
	    
    }
}