package ru.codebreakergame.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import ru.codebreakergame.R;
import ru.codebreakergame.chipers.replacementshift.CaesarCode;

public class CaesarActivity extends Activity implements View.OnClickListener, View.OnKeyListener {

    EditText beforeReplace;
    EditText afterReplace;
    String originalText;
    String cipherText;
    TextView cipherTextView;
    ArrayList<String> memoryList = new ArrayList<>();

    Button undoTextButton, fixTextButton, replaceTextButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar);

        CaesarCode gameOfCaesar = new CaesarCode();

        beforeReplace = (EditText) findViewById(R.id.editCipherWord);
        afterReplace = (EditText) findViewById(R.id.editAfterReplace);

        beforeReplace.setOnKeyListener(this);
        afterReplace.setOnKeyListener(this);

        cipherTextView = (TextView) findViewById(R.id.cipherTextView);

        originalText = getString(R.string.originalTextLevelOne);
        cipherText = gameOfCaesar.codeMaker(originalText, 2);

        cipherTextView.setText(cipherText);
        cipherTextView.setTextColor(Color.BLACK);

        replaceTextButton = (Button) findViewById(R.id.replaceButton);
        fixTextButton = (Button) findViewById(R.id.okButton);
        undoTextButton = (Button) findViewById(R.id.cancelButton);

        replaceTextButton.setOnClickListener(this);
        fixTextButton.setOnClickListener(this);
        undoTextButton.setOnClickListener(this);


        memoryList.add(cipherText);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.replaceButton:
                replaceText();
                break;
            case R.id.okButton:
                fixText();
                break;
            case R.id.cancelButton:
                undoText();
                break;
        }
    }

    public void replaceText() {
        if (beforeReplace.getText().length() > 0) {
            if (afterReplace.getText().length() > 0) {

                String bR = String.valueOf(beforeReplace.getText());
                String aR = String.valueOf(afterReplace.getText());
                String text = String.valueOf(cipherTextView.getText());

                text = text.replace(bR.toLowerCase(), aR.toUpperCase());
                cipherTextView.setText(text);
                memory(text);

                beforeReplace.setText("");
                afterReplace.setText("");
            }
        }
    }

    public void fixText() {
        if (beforeReplace.getText().length() > 0) {
            if (afterReplace.getText().length() > 0) {
                String bR = String.valueOf(beforeReplace.getText());
                String aR = String.valueOf(afterReplace.getText());
                String text = String.valueOf(cipherTextView.getText());

                text = text.replace(bR.toUpperCase(), aR.toUpperCase());
                cipherTextView.setText(text);
                memory(text);

                beforeReplace.setText("");
                afterReplace.setText("");
            }
        }
    }

    public void undoText() {
        if (memoryList.size() > 1) {
            memoryList.remove(memoryList.size() - 1);
            cipherTextView.setText(memoryList.get(memoryList.size() - 1));
        }
    }

    public void memory(String text) {
        if (memoryList.size() == 20) {
            memoryList.remove(0);
            memoryList.add(text);
            memoryList.trimToSize();
        } else {
            memoryList.add(text);
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN &&
                (keyCode == KeyEvent.KEYCODE_ENTER)) {
            replaceText();
            return true;
        }

        return false;
    }
}
