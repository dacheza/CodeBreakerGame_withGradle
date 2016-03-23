package ru.codebreakergame.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.codebreakergame.R;
import ru.codebreakergame.chipers.replacementshift.VigenereCode;

public class VigenereActivity extends Activity implements View.OnClickListener, View.OnKeyListener {

    EditText editCipherWord;
    Button okButton;
    Button cancelButton;
    TextView cipherTextView;

    String cipherText;
    String cipherWord = "Ключ";

    VigenereCode vigenereCode = new VigenereCode();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigenere);

        String originalText = getString(R.string.originalTextLevelOne);

        vigenereCode.setKey(cipherWord);
        cipherText = vigenereCode.codeMaker(originalText, false);

        cipherTextView = (TextView) findViewById(R.id.cipherTextView);
        editCipherWord = (EditText) findViewById(R.id.editCipherWord);
        okButton = (Button) findViewById(R.id.okButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        cipherTextView.setText(cipherText);
        cipherTextView.setTextColor(Color.BLACK);

        okButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.okButton:
                replaceText();
                break;
            case R.id.cancelButton:
                editCipherWord.setText("");
                cipherTextView.setText(cipherText);
                break;
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

    public void replaceText() {
        String key = String.valueOf(editCipherWord.getText());
        if (key.length() > 0) {
            vigenereCode.setKey(key);
            String decipherText = vigenereCode.codeMaker(cipherText, true);
            cipherTextView.setText(decipherText);
        }
    }
}
