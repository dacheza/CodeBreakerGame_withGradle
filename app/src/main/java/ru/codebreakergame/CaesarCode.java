package ru.codebreakergame;

/**
 * Created by citlalatonac on 1/18/16.
 */
public class CaesarCode {

    public String codeCaesar(String text, int step, String slide){
        int firstSymbol = 'а';
        int lastSymbol = 'я';

        /** Обработка входящего текста */
        String textWithoutOtherSymbol = text.toLowerCase().replaceAll("(?U)\\W","");
        char[] originalText = textWithoutOtherSymbol.toCharArray();

        String chiperText = "";

        /** Если двигаем вправо */
        if (slide.equals("right")) {
            for (char c : originalText) {
                int charCode = c;
                if (charCode < lastSymbol - step)
                    chiperText = chiperText + (char)(charCode + step);
                else
                    chiperText = chiperText + (char)(firstSymbol + (charCode - lastSymbol + step));
            }
            return chiperText;
        }

        /** Если двигаем влево */
        if (slide.equals("left")){
            for (char c : originalText) {
                int charCode = c;
                if (charCode > firstSymbol + step)
                    chiperText = chiperText + (char)(charCode - step);
                else
                    chiperText = chiperText + (char)(lastSymbol + (charCode - firstSymbol - step));
            }
            return chiperText;
        }
        return chiperText;
    }
}
