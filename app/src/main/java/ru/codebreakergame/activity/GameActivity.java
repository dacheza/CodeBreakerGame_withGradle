package ru.codebreakergame.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import ru.codebreakergame.R;

/**
 * Ссылка на бесконечную прокрутку https://github.com/satansly/InfiniteScrollView
 */

public class GameActivity extends Activity {

        LinearLayout linearLayout;
        int[] c = new int[] { Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT,
                Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT,
                Color.TRANSPARENT };

        String[] cs = new String[] { "YELLOW", "BLUE", "RED", "GRAY", "GREEN",
                "CYAN", "LTGRAY", "WHITE", "DKGRAY", "BLACK" };

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game);
            RelativeLayout container = (RelativeLayout) findViewById(R.id.relative);

            PSInfiniteScrollView scrollView = new PSInfiniteScrollView(this,new PSSize(90,90));
            for (int i = 0; i < 10; i++) {
                MyCloneableView img = new MyCloneableView(GameActivity.this);
                img.setId(i + 20);
                img.setImageResource(R.drawable.ic_button_for_alphabet);
                img.setScaleType(ImageView.ScaleType.FIT_XY);
                img.setBackgroundColor(c[i]);
                img.setTag(c[i]);
                scrollView.addItem(img);
            }

            container.addView(scrollView);
    }
}
