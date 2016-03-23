package ru.codebreakergame.chipers.replacementshift.machine;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import ru.codebreakergame.chipers.replacementshift.CaesarCode;

import static ru.codebreakergame.chipers.replacementshift.machine.Rotor.rotateRotor;

/**
 * Энигма!!!
 * <p/>
 * Вот такая схема: КП 1Р 2Р 3Р О 3Р^(-1) 2Р^(-1) 1Р^(-1) КП
 * <p/>
 * Сначала текст проходит через коммутационную панель, потом через наши карты(роторы) - меняем по ключу
 * потом идет переворот с помощью рефлектора
 * после рефлектора опять проходят роторы, только ищем буквы по значению (роторы идут в обратном направлении)
 * и снова коммутационная панель
 * <p/>
 * кольца просто сдвигают алфавит для каждого ротора
 * <p/>
 * Больше информации https://ru.wikipedia.org/wiki/%D0%AD%D0%BD%D0%B8%D0%B3%D0%BC%D0%B0
 */

public class EnigmaMachine extends CaesarCode {

    char[] rotorsPosition;
    int[] rotorsLocation;

    // Карта коммутационной панели
    Map<Character, Character> pairLetters;

    char[] rings;

    // Счетчик поворота роторов
    static int[] rotorCount = new int[]{0, 0, 0};

    int stepOfShift;
    boolean reflection = false;
    int countForPrint = 0;

    public EnigmaMachine(char[] rotorsPosition, int[] rotorsLocation, Map<Character, Character> pairLetters, char[] rings) {
        this.rotorsPosition = rotorsPosition;
        this.rotorsLocation = rotorsLocation;
        this.pairLetters = pairLetters;
        this.rings = rings;
    }

    // Карты роторов (связи)
    static Map<Character, Character> firstRotor = new TreeMap<>();
    static Map<Character, Character> secondRotor = new TreeMap<>();
    static Map<Character, Character> thirdRotor = new TreeMap<>();

    // Роторы
    Rotor rotorOne = new Rotor(firstRotor);
    Rotor rotorTwo = new Rotor(secondRotor);
    Rotor rotorThree = new Rotor(thirdRotor);

    // Лист с роторами
    static ArrayList<Rotor> rotors = new ArrayList<>();

    // Отражатель
    Reflector reflector = new Reflector();

    // Кольца
    Ringstellung ringstellung = new Ringstellung(firstSymbol);


    static {
        initFirstRotor();
        initSecondRotor();
        initThirdRotor();
    }

    private static void initFirstRotor() {
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

    private static void initSecondRotor() {
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

    private static void initThirdRotor() {
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

    private void rotorsLocations() {
        for (int location : rotorsLocation) {
            if (location == 1)
                rotors.add(rotorOne);
            if (location == 2)
                rotors.add(rotorTwo);
            if (location == 3)
                rotors.add(rotorThree);
        }
    }

    public String codeMaker(String text) {

        String cipherText = "";

        PlugBoard plugBoard = new PlugBoard(pairLetters);  //Коммутационная панель
        rotorsLocations();

        // Убираем другие символы
        text = textWithoutOtherSymbol(text);
        char[] originalText = text.toCharArray();

        // Превращаем побуквенно
        for (char letter : originalText) {
            // Проходит коммутационную панель
            letter = plugBoard.plugs(letter);

            // Роторы
            for (int i = 0; i < rotors.size(); i++) {
                letter = alphabeticShift(letter, i);
                letter = rotors.get(i).shift(letter, reflection);
            }

            // Отражатель
            letter = reflector.reflection(letter);
            reflection = true;

            // Роторы
            for (int i = rotors.size() - 1; i >= 0; i--) {
                letter = rotors.get(i).shift(letter, reflection);
                letter = alphabeticShift(letter, i);
            }

            // Коммутационная панель
            letter = plugBoard.plugs(letter);
            reflection = false;

            // Поворот роторов
            rotorCount = rotateRotor(rotorCount);

            // Стиль
            cipherText = print(cipherText, letter);
        }
        return cipherText.toUpperCase();
    }

    @Override
    public char alphabeticShift(char letter, int step) {

        char tempLetter;

        // Смещение позиции ротора, если он поворачивался
        tempLetter = (char) (rotorsPosition[step] + rotorCount[step]);
        tempLetter = whatIf(tempLetter);

        // Сдвиг осуществляемый кольцами
        tempLetter = ringstellung.ringShift(tempLetter, rings[step]);

        // Разница между первым ротором и первой буквой алфавита или ротором и ротором + кольца
        if (step == 0)
            stepOfShift = tempLetter - firstSymbol;
        else
            stepOfShift = tempLetter - rotorsPosition[step - 1];

        // Учитывание разницы между положениями роторов и сдвигом колец
        if (!reflection)
            letter = (char) (letter + stepOfShift);
        else
            letter = (char) (letter - stepOfShift);

        letter = whatIf(letter);

        return letter;
    }


}
