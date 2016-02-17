package ru.codebreakergame.chipers.interfaces;

public interface AlphabeticCipherReplacement {
    int firstSymbol = 'а';
    int lastSymbol = 'я';

    String textWithoutOtherSymbol(String text);
    char alphabeticShift(char letter, int step);
}
