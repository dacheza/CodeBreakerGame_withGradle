package ru.codebreakergame.chipers;

import java.util.Map;
import java.util.TreeMap;

/**
 *  Это класс прототип, который имитирует работу Энигмы, для создания будущего класса Энигмы этот класс будет использоваться в качастве примера и опоры.
 *  ПыСы в дальнейшем будет заменен на EnigmaMachine.
 */

public class EnigmaCode extends CaesarCode {

    static Map<Character, Character> firstRotor = new TreeMap<>();
    static Map<Character, Character> secondRotor = new TreeMap<>();
    static Map<Character, Character> thirdRotor = new TreeMap<>();

    char setFirstSymbol;
    char setSecondSymbol;
    char setThirdSymbol;

    char[] rings;

    Map<Character, Character> plugs;

    public EnigmaCode(char setFirstSymbol, char setSecondSymbol, char setThirdSymbol, char[] rings, Map<Character, Character> plugs) {
        this.setFirstSymbol = setFirstSymbol;
        this.setSecondSymbol = setSecondSymbol;
        this.setThirdSymbol = setThirdSymbol;
        this.rings = rings;
        this.plugs = plugs;
    }

    static {
        initFirstRotor();
        initSecondRotor();
        initThirdRotor();
    }

    public String codeMaker(String text) {
        text = textWithoutOtherSymbol(text);
        char[] originalText = text.toCharArray();
        int firstStep;
        int secondStep;
        int thirdStep;
        String cipherText = "";
        int ring;

        int countFirstRotor = 0;
        int countSecondRotor = 0;
        int countThirdRotor = 0;

        for (char letter : originalText) {

            // Коммутационная панель
            letter = plugBoard(letter);

            // Первый ротор
            ring = ringShift(rings[0]);
            setFirstSymbol = (char) (setFirstSymbol + countFirstRotor + ring);
            setFirstSymbol = whatIf(setFirstSymbol);
            setFirstSymbol = whatIf(setFirstSymbol);
            firstStep = setFirstSymbol - firstSymbol;
            letter = (char) (letter + firstStep);
            letter = whatIf(letter);
            letter = shiftBeforeReflector(letter, firstRotor);

            // Второй ротор
            ring = ringShift(rings[1]);
            setSecondSymbol = (char) (setSecondSymbol + countSecondRotor + ring);
            setSecondSymbol = whatIf(setSecondSymbol);
            setSecondSymbol = whatIf(setSecondSymbol);
            secondStep = setSecondSymbol - setFirstSymbol;
            letter = (char) (letter + secondStep);
            letter = whatIf(letter);
            letter = shiftBeforeReflector(letter, secondRotor);

            // Третий ротор
            ring = ringShift(rings[2]);
            setThirdSymbol = (char) (setThirdSymbol + countThirdRotor + ring);
            setThirdSymbol = whatIf(setThirdSymbol);
            setThirdSymbol = whatIf(setThirdSymbol);
            thirdStep = setThirdSymbol - setSecondSymbol;
            letter = (char) (letter + thirdStep);
            letter = whatIf(letter);
            letter = shiftBeforeReflector(letter, thirdRotor);


            // Отражатель
            letter = reflector(letter);


            // Третий ротор
            letter = shiftAfterReflector(letter, thirdRotor);

            firstStep = -firstStep;
            secondStep = -secondStep;
            thirdStep = -thirdStep;

            // Второй ротор
            letter = (char) (letter + thirdStep);
            letter = whatIf(letter);
            letter = whatIf(letter);
            letter = shiftAfterReflector(letter, secondRotor);

            // Первый ротор
            letter = (char) (letter + secondStep);
            letter = whatIf(letter);
            letter = whatIf(letter);
            letter = shiftAfterReflector(letter, firstRotor);

            letter = (char) (letter + firstStep);
            letter = whatIf(letter);
            letter = whatIf(letter);

            // Коммутационная панель
            letter = plugBoard(letter);

            countFirstRotor++;
            if (countFirstRotor == 32){
                countFirstRotor = 0;
                countSecondRotor++;
            }
            if (countSecondRotor == 32){
                countSecondRotor = 0;
                countThirdRotor++;
                countSecondRotor++;
            }
            if(countThirdRotor == 32)
                countThirdRotor = 0;

           System.out.println(countFirstRotor + " " + countSecondRotor + " " + countThirdRotor);

            cipherText = cipherText + letter;
        }
        return cipherText;
    }

    public int ringShift(char ring){
        int shift = ring - firstSymbol;
        return shift;
    }
    public static void initFirstRotor() {
        firstRotor.put('а', 'ш');
        firstRotor.put('б', 'п');
        firstRotor.put('в', 'з');
        firstRotor.put('г', 'ь');
        firstRotor.put('д', 'ж');
        firstRotor.put('е', 'д');
        firstRotor.put('ж', 'х');
        firstRotor.put('з', 'к');
        firstRotor.put('и', 'а');
        firstRotor.put('й', 'л');
        firstRotor.put('к', 'и');
        firstRotor.put('л', 'о');
        firstRotor.put('м', 'э');
        firstRotor.put('н', 'ц');
        firstRotor.put('о', 'н');
        firstRotor.put('п', 'ъ');
        firstRotor.put('р', 'ф');
        firstRotor.put('с', 'ы');
        firstRotor.put('т', 'г');
        firstRotor.put('у', 'с');
        firstRotor.put('ф', 'й');
        firstRotor.put('х', 'у');
        firstRotor.put('ц', 'е');
        firstRotor.put('ч', 'в');
        firstRotor.put('ш', 'я');
        firstRotor.put('щ', 'м');
        firstRotor.put('ъ', 'ч');
        firstRotor.put('ы', 'т');
        firstRotor.put('ь', 'р');
        firstRotor.put('э', 'б');
        firstRotor.put('ю', 'щ');
        firstRotor.put('я', 'ю');
    }

    public static void initSecondRotor() {
        secondRotor.put('а', 'ь');
        secondRotor.put('б', 'о');
        secondRotor.put('в', 'м');
        secondRotor.put('г', 'ъ');
        secondRotor.put('д', 'э');
        secondRotor.put('е', 'б');
        secondRotor.put('ж', 'з');
        secondRotor.put('з', 'щ');
        secondRotor.put('и', 'ы');
        secondRotor.put('й', 'т');
        secondRotor.put('к', 'е');
        secondRotor.put('л', 'у');
        secondRotor.put('м', 'ш');
        secondRotor.put('н', 'ю');
        secondRotor.put('о', 'к');
        secondRotor.put('п', 'ф');
        secondRotor.put('р', 'н');
        secondRotor.put('с', 'п');
        secondRotor.put('т', 'и');
        secondRotor.put('у', 'д');
        secondRotor.put('ф', 'ж');
        secondRotor.put('х', 'л');
        secondRotor.put('ц', 'в');
        secondRotor.put('ч', 'ц');
        secondRotor.put('ш', 'й');
        secondRotor.put('щ', 'с');
        secondRotor.put('ъ', 'р');
        secondRotor.put('ы', 'х');
        secondRotor.put('ь', 'г');
        secondRotor.put('э', 'я');
        secondRotor.put('ю', 'а');
        secondRotor.put('я', 'ч');
    }

    public static void initThirdRotor() {
        thirdRotor.put('а', 'е');
        thirdRotor.put('б', 'й');
        thirdRotor.put('в', 'п');
        thirdRotor.put('г', 'и');
        thirdRotor.put('д', 'э');
        thirdRotor.put('е', 'ф');
        thirdRotor.put('ж', 'ч');
        thirdRotor.put('з', 'ю');
        thirdRotor.put('и', 'а');
        thirdRotor.put('й', 'г');
        thirdRotor.put('к', 'м');
        thirdRotor.put('л', 'ц');
        thirdRotor.put('м', 'р');
        thirdRotor.put('н', 'д');
        thirdRotor.put('о', 'б');
        thirdRotor.put('п', 'ъ');
        thirdRotor.put('р', 'т');
        thirdRotor.put('с', 'з');
        thirdRotor.put('т', 'ж');
        thirdRotor.put('у', 'к');
        thirdRotor.put('ф', 'я');
        thirdRotor.put('х', 'ы');
        thirdRotor.put('ц', 'н');
        thirdRotor.put('ч', 'х');
        thirdRotor.put('ш', 'л');
        thirdRotor.put('щ', 'у');
        thirdRotor.put('ъ', 'с');
        thirdRotor.put('ы', 'ш');
        thirdRotor.put('ь', 'о');
        thirdRotor.put('э', 'щ');
        thirdRotor.put('ю', 'в');
        thirdRotor.put('я', 'ь');
    }

    public char shiftBeforeReflector(char letter, Map<Character, Character> rotor) {
        String oneLetter = String.valueOf(letter);
        for (Map.Entry<Character, Character> shift : rotor.entrySet()) {
            String twoLetter = String.valueOf(shift.getKey());
            if (oneLetter.equals(twoLetter))
                letter = shift.getValue();
        }
        return letter;
    }

    public char shiftAfterReflector(char letter, Map<Character, Character> rotor) {
        String oneLetter = String.valueOf(letter);
        for (Map.Entry<Character, Character> shift : rotor.entrySet()) {
            String twoLetter = String.valueOf(shift.getValue());
            if (oneLetter.equals(twoLetter))
                letter = shift.getKey();
        }
        return letter;
    }

    public char reflector(char letter) {
        letter = (char) (letter + 16);
        letter = whatIf(letter);
        return letter;
    }

    public char plugBoard(char letter) {
        String oneLetter = String.valueOf(letter);
        for (Map.Entry<Character, Character> plug : plugs.entrySet()) {
            String twoLetter = String.valueOf(plug.getKey());
            String threeLetter = String.valueOf(plug.getValue());
            if (oneLetter.equals(twoLetter))
                letter = plug.getValue();
            if (oneLetter.equals(threeLetter))
                letter = plug.getKey();
        }
        return letter;
    }

    public char whatIf(char letter) {
        if (letter > lastSymbol) {
            int step = letter - lastSymbol;
            letter = (char) (firstSymbol + step - 1);
        }
        if (letter < firstSymbol) {
            int step = firstSymbol - letter;
            letter = (char) (lastSymbol - step + 1);
        }
        return letter;
    }
}
