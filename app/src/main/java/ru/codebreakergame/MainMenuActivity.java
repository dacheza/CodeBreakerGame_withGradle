package ru.codebreakergame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainMenuActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        /** Скрытие статус бара */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageButton ibContinue = (ImageButton) findViewById(R.id.imageButtonContinue);
        ImageButton ibNewGame = (ImageButton) findViewById(R.id.imageButtonNewGame);

        ibContinue.setOnClickListener(this);
        ibNewGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.imageButtonContinue:
                break;
            case R.id.imageButtonNewGame:
                intent = new Intent("ru.codebreakergame.action.newgame");
                startActivity(intent);
                break;
        }
    }
}
