package ru.codebreakergame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;


public class MainMenuActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        /** Скрытие статус бара */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView ivContinue = (ImageView) findViewById(R.id.imageViewContinue);
        ImageView ivNewGame = (ImageView) findViewById(R.id.imageViewNewGame);

        ivContinue.setOnClickListener(this);
        ivNewGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.imageViewContinue:
                break;
            case R.id.imageViewNewGame:
                intent = new Intent("ru.codebreakergame.action.newgame");
                startActivity(intent);
                break;
        }
    }
}
