package ru.codebreakergame.chipers;

import ru.codebreakergame.chipers.interfaces.AlphabeticCipherReplacement;

/**
 * Шифр Цезаря это банальный сдвиг символов текста на несколько позиций вдоль алфавита
 */

public class CaesarCode implements AlphabeticCipherReplacement {

    char cipherLetter;
    String[] otherSymbol = new String[]{" ", ".", ",", "!", "?", "'", ";", ":", "-", "_", "№", "#", ")", "("};

    /**
     * К сожалению с регулярным выражением приложение валится text.replaceAll("(?U)\\W", "")
     */
    @Override
    public String textWithoutOtherSymbol(String text) {

        text = text.toLowerCase();
        for (String symbol : otherSymbol) {
            text = text.replace(symbol, "");
        }
        return text;
    }

    @Override
    public char alphabeticShift(char letter, int step) {
        letter = (char) (letter + step);
        letter = whatIf(letter);
        return letter;
    }

    public String codeMaker(String text, int step) {
        text = textWithoutOtherSymbol(text);
        char[] originalText = text.toCharArray();

        String cipherText = "";

        for (char c : originalText) {
            cipherLetter = alphabeticShift(c, step);
            cipherText = cipherText + cipherLetter;
        }
        return cipherText;
    }

    public static char whatIf(char letter) {

        // Проверка на превыщение значения последнего символа алфавита
        if (letter > lastSymbol) {
            int step = letter - lastSymbol;
            letter = (char) (firstSymbol + step - 1);
        }

        // Проверка на значение меньше первого символа алфавита
        if (letter < firstSymbol) {
            int step = firstSymbol - letter;
            letter = (char) (lastSymbol - step + 1);
        }
        return letter;
    }
}
