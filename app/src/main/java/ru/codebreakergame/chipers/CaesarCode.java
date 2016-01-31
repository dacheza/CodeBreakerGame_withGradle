package ru.codebreakergame.chipers;

public class CaesarCode {

    int firstSymbol = 'а';
    int lastSymbol = 'я';
    char cipherLetter;
    int step;

    Integer[] shifts = new Integer[]{1, 2, 3, 4, 5};
    String[] otherSymbol = new String[]{" ", ".", ",", "!", "?", "'", ";", ":", "-", "_", "№", "#"};

    /**
     * К сожалению с регулярным выражением приложение валится text.replaceAll("(?U)\\W", "")
     */
    public String textWithoutOtherSymbol(String text) {

        text = text.toLowerCase();
        for (String symbol : otherSymbol) {
            text = text.replace(symbol, "");
        }
        return text;
    }

    public char alphabeticShift(char letter, int step) {


        int charCode = letter;
        if (charCode <= lastSymbol - step)
            letter = (char) (charCode + step);
        else
            letter = (char) (firstSymbol + (charCode - lastSymbol + step - 1));
        return letter;

    }

    public String codeMaker(String text) {

        step = shifts[1];
        text = textWithoutOtherSymbol(text);
        char[] originalText = text.toCharArray();

        String cipherText = "";

        for (char c : originalText) {
            cipherLetter = alphabeticShift(c, step);
            cipherText = cipherText + cipherLetter;
        }
        return cipherText;
    }
}
