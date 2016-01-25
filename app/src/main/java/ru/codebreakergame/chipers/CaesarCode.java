package ru.codebreakergame.chipers;

public class CaesarCode {

    public String codeCaesar(String text, int step) {
        int firstSymbol = 'а';
        int lastSymbol = 'я';

        /** Обработка входящего текста */
        String textWithoutOtherSymbol = text.toLowerCase().replaceAll("(?U)\\W", "");
        char[] originalText = textWithoutOtherSymbol.toCharArray();

        String chiperText = "";

        /** Процесс шифрования */
        for (char c : originalText) {
            int charCode = c;
            if (charCode <= lastSymbol - step)                          //Проверка на границу - для перехода с конца в начало алфавита
                chiperText = chiperText + (char) (charCode + step);
            else
                chiperText = chiperText + (char) (firstSymbol + (charCode - lastSymbol + step - 1));
        }
        return chiperText;
    }
}
