package ru.codebreakergame.chipers.replacementshift;

/**
 * Шифр Виженера состоит из последовательности нескольких шифров Цезаря с различными значениями сдвига
 * Для зашифровывания может использоваться таблица алфавитов
 * Таблица Виженера составляется из строк по 32 символа, причём каждая следующая строка сдвигается на несколько позиций
 * Таким образом, в таблице получается 32 различных шифра Цезаря
 * Используются именно те шифры из таблицы, которые указаны в шифрслове
 * Например НЯША - будем использовать алфавиты начинающиеся на Н, Я, Ш и А.
 * Шифровка циклична, на каждый символ шифрслова идет символ оригинального текста
 * <p/>
 * ЭТО ПРИМЕРНЫЙ ТЕКСТ
 * НЯШ АНЯШАНЯША НЯШАН
 * <p/>
 * Как видно Э будет идти по сдвигу Н, то есть на 13 позиций, Т по Я это сдвиг на 31 позицию и т.д.
 * <p/>
 * В нашем случае все немного проще, мы просто считаем сдвиг каждого символа шифрслова относительно оригинального алфавита
 * Оригинальный алфавит начинается на А, вот это мы и отнимаем
 * Н - А = 13
 */

public class VigenereCode extends CaesarCode {

    String key;

    public void setKey(String key) {
        this.key = key;
    }

    public String codeMaker(String text, boolean isDecipher) {

        // Убираем лишнее и разделяем на символы
        text = textWithoutOtherSymbol(text);
        char[] originalText = text.toCharArray();

        String cipherText = "";
        char[] cipherLetters = key.toLowerCase().toCharArray();

        // Счет для каждого символа шифрслова
        int countAlphabet = 0;

        for (char c : originalText) {

            // Сдвиг по символу шифрслова
            int step = cipherLetters[countAlphabet] - firstSymbol;
            if (isDecipher)
                step = -step;

            cipherLetter = alphabeticShift(c, step);
            cipherText = cipherText + cipherLetter;

            // Переход на следующий символ шифрслова
            if (countAlphabet != cipherLetters.length - 1)
                countAlphabet++;
            else
                countAlphabet = 0;
        }

        return cipherText.toUpperCase();
    }
}
