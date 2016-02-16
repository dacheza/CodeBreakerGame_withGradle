package ru.codebreakergame.chipers.Machine;

import java.util.Map;

/**
 * Ротор это подвижный диск со связями
 * <p/>
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

        int first = rotorCount[0];
        int second = rotorCount[1];
        int third = rotorCount[2];

        // Движение первого ротора
        first = first + 1;

        // Движение второго ротора
        if (first == 32){
            second =  second + 1;
            first = 0;
        }

        // Движение третьего ротора
        if (second == 32){
            second = 0;
            third = third + 1;
            second = second + 1;
        }

        if (third == 32)
            third = 0;

        int[] rotated = new int[]{first, second, third};


        return rotated;
    }
}
