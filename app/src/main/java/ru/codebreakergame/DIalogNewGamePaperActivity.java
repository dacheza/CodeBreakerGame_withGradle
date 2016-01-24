package ru.codebreakergame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DIalogNewGamePaperActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_new_game_paper);

        ImageView ivButtonDialogYes = (ImageView) findViewById(R.id.imageButtonYes);
        ImageView ivButtonDialogNo = (ImageView) findViewById(R.id.imageButtonNo);

        ivButtonDialogYes.setOnClickListener(this);
        ivButtonDialogNo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imageButtonYes:
                startActivity(new Intent(this, GameActivity.class));
                this.finish();
                break;
            case R.id.imageButtonNo:
                this.finish();
                break;
        }
    }
}

