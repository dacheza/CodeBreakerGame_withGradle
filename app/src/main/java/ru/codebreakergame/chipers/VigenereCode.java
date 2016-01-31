package ru.codebreakergame.chipers;

import java.util.ArrayList;

public class VigenereCode extends CaesarCode{

    ArrayList<String> keys = new ArrayList<>();

    public VigenereCode(){
        keys.add("МКР");
    }

    public String codeMaker(String text){

        text = textWithoutOtherSymbol(text);

        char[] originalText = text.toCharArray();

        String cipherText = "";
        char[] cipherLetters = keys.get(0).toLowerCase().toCharArray();

        int countAlphabet = 0;

        for(char c : originalText){
            int step = cipherLetters[countAlphabet] - firstSymbol;

            cipherLetter = alphabeticShift(c, step);
            cipherText = cipherText + cipherLetter;

            if (countAlphabet != cipherLetters.length - 1)              // Переход на следующую букву шифрслова
                countAlphabet++;
            else
                countAlphabet = 0;
        }

        return cipherText;
    }
}
