package ru.codebreakergame.chipers.replacementshift.machine;

import java.util.Map;

/**
 * Коммутационная панель
 * Связывает и меняет местами две буквы алфавита собственно сразу после нажатия и перед тем как вывести шифрбукву
 * <p>
 * Две подряд связи не используются, то есть без связей а-б, ж-з, ю-я и т.д.
 */

public class PlugBoard {

    Map<Character, Character> pairLetters;

    public PlugBoard(Map<Character, Character> pairLetters) {
        this.pairLetters = pairLetters;
    }

    public char plugs(char letter) {

        String oneLetter = String.valueOf(letter);


        for (Map.Entry<Character, Character> plug : pairLetters.entrySet()) {

            String letterEqualsValue = String.valueOf(plug.getValue());
            String letterEqualsKey = String.valueOf(plug.getKey());

            if (oneLetter.equals(letterEqualsKey))
                letter = plug.getValue();
            else if (oneLetter.equals(letterEqualsValue))
                letter = plug.getKey();

        }
        return letter;
    }
}
