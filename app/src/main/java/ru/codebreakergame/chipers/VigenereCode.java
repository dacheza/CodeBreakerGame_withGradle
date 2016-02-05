package ru.codebreakergame.chipers;

public class VigenereCode extends CaesarCode{

    String key;

    public VigenereCode(String key) {
        this.key = key;
    }

    public String codeMaker(String text){

        text = textWithoutOtherSymbol(text);
        char[] originalText = text.toCharArray();

        String cipherText = "";
        char[] cipherLetters = key.toLowerCase().toCharArray();

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
