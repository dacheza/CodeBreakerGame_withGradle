package ru.codebreakergame.chipers.replacementshift;

public interface AlphabeticCipherReplacement {
    int firstSymbol = 'а';
    int lastSymbol = 'я';

    String textWithoutOtherSymbol(String text);
    char alphabeticShift(char letter, int step);
}
