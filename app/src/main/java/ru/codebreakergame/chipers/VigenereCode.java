package ru.codebreakergame.chipers;

public class VigenereCode {
    public String vigenereChiperMaker(String chiperWord, String text) {

        int firstSymbol = 'а';
        int lastSymbol = 'я';

        /** Обработка входящего текста */
        String textWithoutOtherSymbol = text.replaceAll("(?U)\\W", "").toLowerCase();
        char[] originalText = textWithoutOtherSymbol.toCharArray();

        String chiperText = "";
        char[] chiperWordArray = chiperWord.toCharArray();
        int countAlphabet = 0;

        /** Процесс шифрования */
        for (char c : originalText) {
            int step = chiperWordArray[countAlphabet] - firstSymbol + 1;
            int charCode = c;
            if (charCode <= lastSymbol - step)                          //Проверка на границу - для перехода с конца в начало алфавита
                chiperText = chiperText + (char) (charCode + step);
            else
                chiperText = chiperText + (char) (firstSymbol + (charCode - lastSymbol + step - 1));

            if (countAlphabet != chiperWordArray.length - 1)
                countAlphabet++;
            else
                countAlphabet = 0;
        }

        return chiperText;
    }
}
