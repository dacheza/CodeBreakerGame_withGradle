package ru.codebreakergame;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

/*
 * здесь внизу ссылка на мерцающий
 * текст http://developer.alexanderklimov.ru/android/views/textview.php
 * а это собственно мерцающий текст на гитхабе:
 * https://github.com/RomainPiel/Shimmer-android
 * Shimmer also includes a ShimmerButton. It works exactly the same way as a ShimmerTextView.
 * Have a look at how it's implemented and you can apply the same effect on your custom view
 * if you need it.
 */
public class SplashScreenActivity extends /*AppCompat*/Activity {
    Shimmer shimmer;
    ShimmerTextView shimmerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startSplashScreen();
        starFirstActivity();
    }

    private void starFirstActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, FirstActivity.class);
                startActivity(intent);
                finish();
            }
        }, 6 * 1000);
    }

    private void startSplashScreen() {
        setContentView(R.layout./*activity_main*/dacheza_splashscreen);

        shimmerTextView = (ShimmerTextView) findViewById(R.id.shimmer_tv);
        shimmer = new Shimmer();

        final Animation startAlphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_start);
        final Animation finishAlphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_finish);
        shimmerTextView.startAnimation(startAlphaAnimation);

        shimmer.setRepeatCount(0)     /* количество повторов мерцания */
                .setDuration(2000)    /* длительность анимации */
                .setStartDelay(2000)  /* задержка перед началом анимации */
                .setDirection(Shimmer.ANIMATION_DIRECTION_RTL)
                .setAnimatorListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        shimmerTextView.startAnimation(finishAlphaAnimation);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
        shimmer.start(shimmerTextView);
        // shimmer.cancel(); // для остановки анимации мерцания
    }
}
