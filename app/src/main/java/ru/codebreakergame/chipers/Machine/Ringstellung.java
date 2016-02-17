package ru.codebreakergame.chipers.Machine;

import static ru.codebreakergame.chipers.CaesarCode.whatIf;

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
