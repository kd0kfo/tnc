package com.davecoss.android.tnc;

/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.HashMap;


/** Class that implements the text to morse code conversion */
class MorseCoder {
	
	
	private static final HashMap<Character, MorseBit[]> morse_map = new HashMap<Character, MorseBit[]>(){
        /**
		 * 
		 */
		private static final long serialVersionUID = -2358097224202863843L;

		{
        	put('A', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('B', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('C', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('D', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT });
        	put('E', new MorseBit[] { MorseBit.DIT });
        	put('F', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('G', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT });
        	put('H', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('I', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('J', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('K', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH });
        	put('L', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('M', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('N', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('O', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH });
        	put('P', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT});
        	put('Q', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('R', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT});
        	put('S', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT });
        	put('T', new MorseBit[] { MorseBit.DAH });
        	put('U', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH });
        	put('V', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('W', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH });
        	put('X', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('Y', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('Z', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('0', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('1',new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('2', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('3', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('4', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('5', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('6', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('7', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('8',new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('9',new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP,
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('/', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT});
        	put('.', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DAH});
        	put(',', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT,MorseBit.GAP, MorseBit.DAH, 
        			MorseBit.GAP, MorseBit.DAH});
        	put('?', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT});
        	//BT
        	put('=', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH});
        	put('-', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH});
        	//AR
        	put('+', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT});
        	//KN
        	put('~', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT});
        	//SK
        	put('*', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DAH });	
        	
        	//Latin Non-English Extensions

        	put('Ä', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('Æ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('Ą', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('À', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH});
        	put('Å', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH});
        	put('Ç', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('Ĉ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('Ć', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('Š', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('Ð', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('Ś', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT});
        	put('È', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('Ł', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('É', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('Đ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('Ę', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('Ĝ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('Ĥ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('Ĵ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('Ź', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, 
        			MorseBit.GAP, MorseBit.DIT });
        	put('Ń', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('Ñ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('Ö', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });  
        	put('Ø', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });  
        	put('Ó', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });  
        	put('Ŝ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('Þ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('Ü', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('Ŭ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('Ż', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });


        	//Русский Код Морзе -- Russian Morse Encoding

        	put('А', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('Б', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('В', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH });
        	put('Г', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT });
        	put('Д', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT });
        	put('Е', new MorseBit[] { MorseBit.DIT });
        	put('Ж', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('З', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('И', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('Й', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('К', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH });
        	put('Л', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('М', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('Н', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('О', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH });
        	put('П', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT});
        	put('Р', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT});
        	put('С', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT });
        	put('Т', new MorseBit[] { MorseBit.DAH });
        	put('У', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH });
        	put('Ф', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('Х', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('Ц', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('Ч', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('Ш', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('Щ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('Ъ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('Ы', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('Ь', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('Э', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('Ю', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('Я', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });

        	// 和文モールス符号  Japanese Wabun Code

        	put('ア', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('イ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('ウ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH });
        	put('エ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('オ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('カ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('キ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('ク', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('ケ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('コ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('サ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('シ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('ス', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('セ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT});
        	put('ソ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT});
        	put('タ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('チ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('ツ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT});
        	put('テ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('ト', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('ナ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT});
        	put('ニ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('ヌ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('ネ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('ノ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('ハ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('ヒ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('フ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('ヘ', new MorseBit[] { MorseBit.DIT });
        	put('ホ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT });
        	put('マ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('ミ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('ム', new MorseBit[] { MorseBit.DAH });
        	put('メ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH});
        	put('モ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('ヤ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH });
        	put('ユ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('ヨ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('ラ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT });
        	put('リ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT });
        	put('ル', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP,MorseBit.DAH, MorseBit.GAP, MorseBit.DIT});
        	put('レ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH });
        	put('ロ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('ワ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH });
        	put('ヰ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('ヱ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('ヲ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH });
        	put('ン', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT});


        	// Gojuon combinations with dakuten and handakuten are treated as single code points
        	// in unicode, so they are represented here as single characters, but could also be
        	// composed sequentially, as there is a letter gap between the gojuon and the diacritical

        	put('ガ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT });
        	put('ギ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, 
        			MorseBit.LETTER_GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('グ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT });
        	put('ゲ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT });
        	put('ゴ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH,MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT });
        	put('ザ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT });
        	put('ジ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, 
        			MorseBit.LETTER_GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('ズ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, 
        			MorseBit.LETTER_GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('ゼ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, 
        			MorseBit.LETTER_GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('ゾ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT });
        	put('ダ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.LETTER_GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('ヂ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT });
        	put('ヅ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT });
        	put('デ', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, 
        			MorseBit.LETTER_GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('ド',  new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, 
        			MorseBit.LETTER_GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('バ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT });
        	put('ビ',  new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, 
        			MorseBit.LETTER_GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('ブ',  new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT });
        	put('ベ', new MorseBit[] { MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, MorseBit.GAP,
        			MorseBit.DIT });
        	put('ボ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	put('パ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('ピ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });
        	put('プ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	put('ペ',  new MorseBit[] { MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, 
        			MorseBit.GAP, MorseBit.DIT });
        	put('ポ', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.LETTER_GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP,
        			MorseBit.DIT });

        	// comma 
        	put('、', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DAH});
        	// full stop
        	put('。', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP,
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, 
        			MorseBit.GAP, MorseBit.DIT });

        	// dakuten
        	put('゙', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT });
        	// handakuten  
        	put('゚', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP,
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });

        	// Choonpu
        	put('ー', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, 
        			MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, MorseBit.DAH });

        	//DO
        	put(')', new MorseBit[] { MorseBit.DAH, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DAH, 
        			MorseBit.GAP, MorseBit.DAH });
        	//SN
        	put('(', new MorseBit[] { MorseBit.DIT, MorseBit.GAP, MorseBit.DIT, MorseBit.GAP, 
        			MorseBit.DIT, MorseBit.GAP, MorseBit.DAH, MorseBit.GAP, MorseBit.DIT });
        	}
        };

    private static final MorseBit[] ERROR_GAP = new MorseBit[] { MorseBit.GAP };

    /** Return the pattern data for a given character */
    static MorseBit[] pattern(char c) {
    	if (Character.isLetter(c))
            c = Character.toUpperCase(c);
    	if (morse_map.containsKey(c))
        	return morse_map.get(c);
    	else
        	return ERROR_GAP;
    }

    static MorseBit[] pattern(String str) {
        boolean lastWasWhitespace;
        int strlen = str.length();

        // Calculate how MorseBit our array needs to be.
        int len = 1;
        lastWasWhitespace = true;
        for (int i=0; i<strlen; i++) {
            char c = str.charAt(i);
            if (Character.isWhitespace(c)) {
                if (!lastWasWhitespace) {
                    len++;
                    lastWasWhitespace = true;
                }
            } else {
                if (!lastWasWhitespace) {
                    len++;
                }
                lastWasWhitespace = false;
                len += pattern(c).length;
            }
        }

        // Generate the pattern array.  Note that we put an extra element of 0
        // in at the beginning, because the pattern always starts with the pause,
        // not with the vibration.
        MorseBit[] result = new MorseBit[len];
        result[0] = MorseBit.GAP;
        int pos = 1;
        lastWasWhitespace = true;
        for (int i=0; i<strlen; i++) {
            char c = str.charAt(i);
            if (Character.isWhitespace(c)) {
                if (!lastWasWhitespace) {
                    result[pos] = MorseBit.WORD_GAP;
                    pos++;
                    lastWasWhitespace = true;
                }
            } else {
                if (!lastWasWhitespace) {
                    result[pos] = MorseBit.LETTER_GAP;
                    pos++;
                }
                lastWasWhitespace = false;
                MorseBit[] letter = pattern(c);
                System.arraycopy(letter, 0, result, pos, letter.length);
                pos += letter.length;
            }
        }
        return result;
    }
}
