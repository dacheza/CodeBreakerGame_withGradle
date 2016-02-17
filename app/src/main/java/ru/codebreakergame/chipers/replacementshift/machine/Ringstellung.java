package ru.codebreakergame.chipers.replacementshift.machine;

import static ru.codebreakergame.chipers.replacementshift.CaesarCode.whatIf;

/**
 * Кольца это еще один способ запудрить мозги дешифровщикам
 *
 * Сдвигают букву в лево на разницу шагов между первой буквой и буквой кольца
 */
public class Ringstellung {

    int firstSymbol;

    public Ringstellung(int firstSymbol) {
        this.firstSymbol = firstSymbol;
    }

    public char ringShift(char letter, char ring) {
        int shift = ring - firstSymbol;
        letter = (char) (letter + shift);
        letter = whatIf(letter);
        return letter;
    }
}
