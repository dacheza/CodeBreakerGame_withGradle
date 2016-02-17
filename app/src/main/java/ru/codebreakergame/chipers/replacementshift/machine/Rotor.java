package ru.codebreakergame.chipers.replacementshift.machine;

import java.util.Map;

/**
 * Ротор это подвижный диск со связями
 *
 * По сути выполняет замену букв
 */
public class Rotor {
    Map<Character, Character> rotor;

    public Rotor(Map<Character, Character> rotor) {
        this.rotor = rotor;
    }

    public char shift(char letter, boolean reflection) {

        // До отражателя
        if (!reflection) {
            String oneLetter = String.valueOf(letter);

            for (Map.Entry<Character, Character> shift : rotor.entrySet()) {
                String connectLetter = String.valueOf(shift.getKey());
                if (oneLetter.equals(connectLetter))
                    letter = shift.getValue();
            }
        } else {
            // После отражателя
            String oneLetter = String.valueOf(letter);

            for (Map.Entry<Character, Character> shift : rotor.entrySet()) {
                String connectLetter = String.valueOf(shift.getValue());
                if (oneLetter.equals(connectLetter))
                    letter = shift.getKey();
            }
        }
        return letter;
    }

    public static int[] rotateRotor (int[] rotorCount) {

        // Движение первого ротора
        rotorCount[0] = rotorCount[0] + 1;

        // Движение второго ротора
        if (rotorCount[0] == 32){
            rotorCount[1] =  rotorCount[1] + 1;
            rotorCount[0] = 0;
        }

        // Движение третьего ротора
        if (rotorCount[1] == 32){
            rotorCount[1] = 0;
            rotorCount[2] = rotorCount[2] + 1;
            rotorCount[1] = rotorCount[1] + 1;
        }

        // Проверка на полный оборот третьего ротора
        if (rotorCount[2] == 32)
            rotorCount[2] = 0;

        return rotorCount;
    }
}
