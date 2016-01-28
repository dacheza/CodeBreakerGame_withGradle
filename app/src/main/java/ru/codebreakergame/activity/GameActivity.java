package ru.codebreakergame.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

import ru.codebreakergame.R;

/**
 * Еще одна версия игрового класса, все так же кривокода
 */
public class GameActivity extends Activity implements View.OnClickListener {

    TextView textPrev;
    TextView textNext;
    TextView chiperTextView;
    String originalText;
    String chiperText;
    LinkedList<String> memoryList = new LinkedList<>();

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10,
            btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20,
            btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32,
            undoText, clearText, replaceText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        /*CaesarCode gameOfCaesar = new CaesarCode();*/
        findId();
        setClick();

        originalText = getString(R.string.originalTextLevelOne);
        chiperText = /*gameOfCaesar.codeCaesar(originalText, 2)*/  originalText.toLowerCase();
        chiperTextView.setText(chiperText);
        chiperTextView.setTextColor(Color.BLACK);

        memoryList.add(chiperText);

        replaceText.setClickable(false);
        clearText.setClickable(false);
        undoText.setClickable(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAlphabetWord_1:
                setTextOnWordReplaceWindow(btn1);
                break;
            case R.id.buttonAlphabetWord_2:
                setTextOnWordReplaceWindow(btn2);
                break;
            case R.id.buttonAlphabetWord_3:
                setTextOnWordReplaceWindow(btn3);
                break;
            case R.id.buttonAlphabetWord_4:
                setTextOnWordReplaceWindow(btn4);
                break;
            case R.id.buttonAlphabetWord_5:
                setTextOnWordReplaceWindow(btn5);
                break;
            case R.id.buttonAlphabetWord_6:
                setTextOnWordReplaceWindow(btn6);
                break;
            case R.id.buttonAlphabetWord_7:
                setTextOnWordReplaceWindow(btn7);
                break;
            case R.id.buttonAlphabetWord_8:
                setTextOnWordReplaceWindow(btn8);
                break;
            case R.id.buttonAlphabetWord_9:
                setTextOnWordReplaceWindow(btn9);
                break;
            case R.id.buttonAlphabetWord_10:
                setTextOnWordReplaceWindow(btn10);
                break;
            case R.id.buttonAlphabetWord_11:
                setTextOnWordReplaceWindow(btn11);
                break;
            case R.id.buttonAlphabetWord_12:
                setTextOnWordReplaceWindow(btn12);
                break;
            case R.id.buttonAlphabetWord_13:
                setTextOnWordReplaceWindow(btn13);
                break;
            case R.id.buttonAlphabetWord_14:
                setTextOnWordReplaceWindow(btn14);
                break;
            case R.id.buttonAlphabetWord_15:
                setTextOnWordReplaceWindow(btn15);
                break;
            case R.id.buttonAlphabetWord_16:
                setTextOnWordReplaceWindow(btn16);
                break;
            case R.id.buttonAlphabetWord_17:
                setTextOnWordReplaceWindow(btn17);
                break;
            case R.id.buttonAlphabetWord_18:
                setTextOnWordReplaceWindow(btn18);
                break;
            case R.id.buttonAlphabetWord_19:
                setTextOnWordReplaceWindow(btn19);
                break;
            case R.id.buttonAlphabetWord_20:
                setTextOnWordReplaceWindow(btn20);
                break;
            case R.id.buttonAlphabetWord_21:
                setTextOnWordReplaceWindow(btn21);
                break;
            case R.id.buttonAlphabetWord_22:
                setTextOnWordReplaceWindow(btn22);
                break;
            case R.id.buttonAlphabetWord_23:
                setTextOnWordReplaceWindow(btn23);
                break;
            case R.id.buttonAlphabetWord_24:
                setTextOnWordReplaceWindow(btn24);
                break;
            case R.id.buttonAlphabetWord_25:
                setTextOnWordReplaceWindow(btn25);
                break;
            case R.id.buttonAlphabetWord_26:
                setTextOnWordReplaceWindow(btn26);
                break;
            case R.id.buttonAlphabetWord_27:
                setTextOnWordReplaceWindow(btn27);
                break;
            case R.id.buttonAlphabetWord_28:
                setTextOnWordReplaceWindow(btn28);
                break;
            case R.id.buttonAlphabetWord_29:
                setTextOnWordReplaceWindow(btn29);
                break;
            case R.id.buttonAlphabetWord_30:
                setTextOnWordReplaceWindow(btn30);
                break;
            case R.id.buttonAlphabetWord_31:
                setTextOnWordReplaceWindow(btn30);
                break;
            case R.id.buttonAlphabetWord_32:
                setTextOnWordReplaceWindow(btn30);
                break;
            case R.id.buttonCleanText:
                cleanTextInWordReplaceWindow();
                break;
            case R.id.buttonOkReplace:
                replacerText();
                undoText.setClickable(true);
                break;
            case R.id.buttonUndo:
                undo();
                break;
        }
    }

    /**
     * Вставка текста в окошко с буквами
     */
    public void setTextOnWordReplaceWindow(Button button) {

        if (textPrev.getText().length() < 1) {

            textPrev.setText(button.getText());
            textPrev.setTextColor(Color.BLACK);

            clearText.setClickable(true);

        } else {

            textNext.setText(button.getText());
            textNext.setTextColor(Color.BLACK);

            replaceText.setClickable(true);
        }
    }

    /**
     * Очистка текста из окошка с буквами
     */
    public void cleanTextInWordReplaceWindow() {
        textNext.setText("");
        textPrev.setText("");

        replaceText.setClickable(false);
        clearText.setClickable(false);
    }

    /**
     * Память для возврата к предыдущему варианту
     */
    public void memory(String text) {
        if (memoryList.size() == 19) {
            memoryList.remove(0);
            memoryList.add(text);
        } else {
            memoryList.add(text);
        }
    }

    /**
     * Возврат к предыдущему варианту
     */
    public void undo() {
        if (memoryList.size() > 1) {
            memoryList.remove(memoryList.size() - 1);
            chiperText = memoryList.get(memoryList.size() - 1);
            if (memoryList.size() == 1)
                undoText.setClickable(false);
            else
                undoText.setClickable(true);
            chiperTextView.setText(chiperText);
        }
    }

    /**
     * Замена букв в шифр тексте для наблюдения изменений и дальнейшего прогресса
     */
    public void replacerText() {
        chiperText = chiperTextView.getText().toString();
        String before = textPrev.getText().toString().toLowerCase();
        String after = textNext.getText().toString().toLowerCase();
        before = before.substring(2, 3);
        after = after.substring(2, 3);
        chiperText = chiperText.replace(before, after);
        memory(chiperText);
        chiperTextView.setText(chiperText);

        cleanTextInWordReplaceWindow();
    }

    public void findId() {
        textPrev = (TextView) findViewById(R.id.textViewPrevious);
        textNext = (TextView) findViewById(R.id.textViewNext);
        chiperTextView = (TextView) findViewById(R.id.textViewChiper);

        btn1 = (Button) findViewById(R.id.buttonAlphabetWord_1);
        btn2 = (Button) findViewById(R.id.buttonAlphabetWord_2);
        btn3 = (Button) findViewById(R.id.buttonAlphabetWord_3);
        btn4 = (Button) findViewById(R.id.buttonAlphabetWord_4);
        btn5 = (Button) findViewById(R.id.buttonAlphabetWord_5);
        btn6 = (Button) findViewById(R.id.buttonAlphabetWord_6);
        btn7 = (Button) findViewById(R.id.buttonAlphabetWord_7);
        btn8 = (Button) findViewById(R.id.buttonAlphabetWord_8);
        btn9 = (Button) findViewById(R.id.buttonAlphabetWord_9);
        btn10 = (Button) findViewById(R.id.buttonAlphabetWord_10);
        btn11 = (Button) findViewById(R.id.buttonAlphabetWord_11);
        btn12 = (Button) findViewById(R.id.buttonAlphabetWord_12);
        btn13 = (Button) findViewById(R.id.buttonAlphabetWord_13);
        btn14 = (Button) findViewById(R.id.buttonAlphabetWord_14);
        btn15 = (Button) findViewById(R.id.buttonAlphabetWord_15);
        btn16 = (Button) findViewById(R.id.buttonAlphabetWord_16);
        btn17 = (Button) findViewById(R.id.buttonAlphabetWord_17);
        btn18 = (Button) findViewById(R.id.buttonAlphabetWord_18);
        btn19 = (Button) findViewById(R.id.buttonAlphabetWord_19);
        btn20 = (Button) findViewById(R.id.buttonAlphabetWord_20);
        btn21 = (Button) findViewById(R.id.buttonAlphabetWord_21);
        btn22 = (Button) findViewById(R.id.buttonAlphabetWord_22);
        btn23 = (Button) findViewById(R.id.buttonAlphabetWord_23);
        btn24 = (Button) findViewById(R.id.buttonAlphabetWord_24);
        btn25 = (Button) findViewById(R.id.buttonAlphabetWord_25);
        btn26 = (Button) findViewById(R.id.buttonAlphabetWord_26);
        btn27 = (Button) findViewById(R.id.buttonAlphabetWord_27);
        btn28 = (Button) findViewById(R.id.buttonAlphabetWord_28);
        btn29 = (Button) findViewById(R.id.buttonAlphabetWord_29);
        btn30 = (Button) findViewById(R.id.buttonAlphabetWord_30);
        btn31 = (Button) findViewById(R.id.buttonAlphabetWord_31);
        btn32 = (Button) findViewById(R.id.buttonAlphabetWord_32);

        undoText = (Button) findViewById(R.id.buttonUndo);
        clearText = (Button) findViewById(R.id.buttonCleanText);
        replaceText = (Button) findViewById(R.id.buttonOkReplace);
    }

    public void setClick() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
        btn23.setOnClickListener(this);
        btn24.setOnClickListener(this);
        btn25.setOnClickListener(this);
        btn26.setOnClickListener(this);
        btn27.setOnClickListener(this);
        btn28.setOnClickListener(this);
        btn29.setOnClickListener(this);
        btn30.setOnClickListener(this);
        btn31.setOnClickListener(this);
        btn32.setOnClickListener(this);

        undoText.setOnClickListener(this);
        clearText.setOnClickListener(this);
        replaceText.setOnClickListener(this);
    }
}
