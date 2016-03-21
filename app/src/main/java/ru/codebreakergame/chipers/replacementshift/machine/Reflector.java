package ru.codebreakergame.chipers.replacementshift.machine;

import static ru.codebreakergame.chipers.replacementshift.CaesarCode.whatIf;

/**
 * Отражатель делает возможным обратную связь, то есть шифр текст можно расшифровать
 *
 * Делает сдвиг на пол алфавита
 */
public class Reflector {

    public char reflection(char letter){
        letter = (char) (letter + 16);
        letter = whatIf(letter);
        return letter;
    }
}
