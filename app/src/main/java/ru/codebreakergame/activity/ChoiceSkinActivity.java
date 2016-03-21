package ru.codebreakergame.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.codebreakergame.R;

public class ChoiceSkinActivity extends Activity implements View.OnClickListener {
    Button buttonCitlalatonacSkin;
    Button buttonDachezaSkin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_skin_activity_layout);

        buttonCitlalatonacSkin = (Button) findViewById(R.id.buttonCitlalatonacSkin);
        buttonCitlalatonacSkin.setOnClickListener(this);
        buttonDachezaSkin = (Button) findViewById(R.id.buttonDachezaSkin);
        buttonDachezaSkin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.buttonCitlalatonacSkin:
                break;
            case R.id.buttonDachezaSkin:
                intent = new Intent(ChoiceSkinActivity.this, FirstActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
