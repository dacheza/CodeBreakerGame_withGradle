package ru.codebreakergame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogNewGameActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_new_game);

        Button btnNewGameYes = (Button) findViewById(R.id.buttonNewGameYes);
        Button btnNewGameNo = (Button) findViewById(R.id.buttonNewGameNo);

        btnNewGameYes.setOnClickListener(this);
        btnNewGameNo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.buttonNewGameYes:
                intent = new Intent("ru.codebreakergame.action.newgame");
                startActivity(intent);
                this.finish();
                break;
            case R.id.buttonNewGameNo:
                this.finish();
                break;
        }
    }
}
