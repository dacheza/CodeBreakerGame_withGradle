package ru.codebreakergame.chipers.languagebarrier;

public class NavajoBarrier implements LanguageBarrier {

    String originalText;
    String translateText;

    public NavajoBarrier(String originalText, String translateText) {
        this.originalText = originalText;
        this.translateText = translateText;
    }

    @Override
    public String getOriginalText(String originalText) {
        return originalText;
    }

    @Override
    public String getTranslateText(String translateText) {
        return translateText;
    }
}
