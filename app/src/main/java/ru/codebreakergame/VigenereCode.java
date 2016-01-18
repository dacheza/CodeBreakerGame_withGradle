package ru.codebreakergame;

/**
 * Created by citlalatonac on 1/18/16.
 */
public class VigenereCode {
    public String alphabet(String chiperWord, String text){
        String textWithoutOtherSymbol = text.toLowerCase().replaceAll("(?U)\\W","");
        char[] originalText = textWithoutOtherSymbol.toCharArray();
        String chiperText = "";
        int firstSymbol = 'а';
        int lastSymbol = 'я';
        int codeChiperWord = 0;
        int charCode = 0;

        char[] chiperWordArray = chiperWord.toCharArray();
        int countAlphabet = 0;

        for(char c : originalText){
            codeChiperWord = chiperWordArray[countAlphabet];
            charCode = c;
            int step = codeChiperWord - firstSymbol;

            if (charCode < lastSymbol - step)
                chiperText = chiperText + (char)(charCode + step);
            else
                chiperText = chiperText + (char)(firstSymbol + (charCode - lastSymbol + step));

            if (countAlphabet < chiperWordArray.length)
                countAlphabet++;
            else
                countAlphabet=0;
        }

        return null;
    }
}
