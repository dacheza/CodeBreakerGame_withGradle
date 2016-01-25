package ru.codebreakergame.chipers;

import java.util.Map;

/**
 * Этот код еще не тестировался, так как на его тест нужно гораздо больше времени, чем на предыдущие шифры.
 */

public class EnigmaCode {
    int firstSymbol = 'а';
    int lastSymbol = 'я';

    public String enigmaChiperMaker(String text, String positionRotor, Map<Character, Character> plugBoardWords){

        int countFirstRotor = 1;
        int countSecondRotor = 1;


        /** Обработка входящего текста */
        String textWithoutOtherSymbol = text.toLowerCase().replaceAll("(?U)\\W", "");
        char[] originalText = textWithoutOtherSymbol.toCharArray();

        String chiperText = "";
        char[] positionRotors = positionRotor.toCharArray();

        int rotor1 = positionRotors[0];
        int rotor2 = positionRotors[1];
        int rotor3 = positionRotors[2];


        /** Процесс шифрования */
        for (char c : originalText) {

            /** Коммутационная панель */
            for(Map.Entry<Character, Character> changeWord : plugBoardWords.entrySet()){
                if(changeWord.getKey().equals(c))
                    c = changeWord.getValue();
                else
                    if(changeWord.getValue().equals(c))
                        c = changeWord.getKey();
            }

            /** Первый ротор */
            int step = rotor1 - firstSymbol + 1;
            char afterFirstRotorChar = chiperMaker(c, step);

            /** Второй ротор */
            step = rotor1 - rotor2 + 1;
            char afteSecondRotor = chiperMaker(afterFirstRotorChar, step);

            /** Третий ротор */
            step = rotor2 - rotor3 + 1;
            char afterThirdRotor = chiperMaker(afteSecondRotor, step);

            /** Отражатель */
            char afterReflector;
            int stepReflector = afterThirdRotor + 16;
            if (stepReflector <= lastSymbol)
                afterReflector = (char)stepReflector;
            else
                afterReflector = (char) (firstSymbol + (stepReflector - lastSymbol - 1));

            /** Снова третий ротор */
            afterThirdRotor = afterReflector;

            /** Снова второй ротор */
            step = rotor2 - rotor3 + 1;
            afteSecondRotor = chiperMaker(afterThirdRotor, step);

            /** Снова первый ротор */
            step = rotor1 - rotor2 + 1;
            afterFirstRotorChar = chiperMaker(afteSecondRotor, step);

            chiperText = chiperText + afterFirstRotorChar;

            /** Поворот роторов */
            countFirstRotor++;
            rotor1++;
            if(countFirstRotor > 32) {
                rotor2++;
                countSecondRotor++;
            }
            if(countSecondRotor > 32){
                rotor3++;
                rotor2++;
            }

            /** Проверка на последний символ */
            if(rotor1 > lastSymbol)
                rotor1=firstSymbol;
            if(rotor2 > lastSymbol)
                rotor2 = firstSymbol;
            if(rotor3 > lastSymbol)
                rotor3 = firstSymbol;
        }
        return chiperText;
    }

    public char chiperMaker(char c, int step){
        int charCode = c;
        char chiperWord;

        if (charCode <= lastSymbol - step)                          //Проверка на границу - для перехода с конца в начало алфавита
            chiperWord = (char) (charCode + step);
        else
            chiperWord = (char) (firstSymbol + (charCode - lastSymbol + step - 1));
        return chiperWord;
    }
}
