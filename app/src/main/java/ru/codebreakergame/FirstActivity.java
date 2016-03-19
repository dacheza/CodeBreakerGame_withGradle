package ru.codebreakergame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    // шифр цезаря
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private EditText editText0;
    private EditText editText1;
    private EditText editText2;
    private ImageButton buttonUp0;
    private ImageButton buttonUp1;
    private ImageButton buttonUp2;
    private ImageButton buttonDown0;
    private ImageButton buttonDown1;
    private ImageButton buttonDown2;
    private TextView[] lettersArr0 = new TextView[5];
    private TextView[] lettersArr1 = new TextView[5];
    private TextView[] lettersArr2 = new TextView[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        final View coordinator = findViewById(R.id.coordinator);

        final View.OnClickListener yes = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Yes", Toast.LENGTH_SHORT).show();
            }
        };

        findViewById(R.id.floating_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar
                        .make(coordinator, "ответ правильный", Snackbar.LENGTH_SHORT)
                        .setAction(/*R.string.snackbar_action*/"ок", yes)
                        .show();
            }
        });

        initToolbar();
        initNavigationView();

//        код который был по умолчанию чтобы создать в RelativeLayout FloatingActionButton и toolbar
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        initCaesarCipherTable();
    }


    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbaric);
        /*setSupportActionBar(toolbar);*/
        /*toolbar.setTitle("test");*/

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        //toolbar.inflateMenu(R.menu.menu);
    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView
                .OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.newGameItemNavigationMenu:
                        Toast.makeText(getApplicationContext(), "Новая игра", Toast.LENGTH_SHORT).show();
                        //showNotificationTab();
                        break;
                    case R.id.loadAnotherSkinItemNavigationMenu:
                        Toast.makeText(getApplicationContext(), "Переключиться на другой скин"
                                , Toast.LENGTH_SHORT).show();
                        //showNotificationTab();
                        break;
                    case R.id.loadGameItemNavigationMenu:
                        Toast.makeText(getApplicationContext(), "Загрузить", Toast.LENGTH_SHORT).show();
                        //showNotificationTab();
                        break;
                    case R.id.saveGameItemNavigationMenu:
                        Toast.makeText(getApplicationContext(), "Сохранить", Toast.LENGTH_SHORT).show();
                        //showNotificationTab();
                        break;
                    case R.id.optionsItemNavigationMenu:
                        Toast.makeText(getApplicationContext(), "Настройки", Toast.LENGTH_SHORT).show();
                        //showNotificationTab();
                        break;
                    case R.id.exitItemNavigationMenu:
                        Toast.makeText(getApplicationContext(), "Выход", Toast.LENGTH_SHORT).show();
                        closeApplication();
                        //showNotificationTab();
                        break;
                }
                return true;
            }
        });
    }

    private void closeApplication() {
        /* неизвестно правильный ли это вариант, но вроде бы все активити закрывает, а не только одно
           http://www.cyberforum.ru/android-dev/thread1246169.html */
        /* todo проверить лучший ли это вариант закрытия приложения */
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    private void initCaesarCipherTable() {
        // инициация шифра цезаря
        initEditText();
        initLetters();
        initUpAndDownButtons();
        experimentWithTable();
    }

    private void initEditText() {
        editText0 = (EditText) findViewById(R.id.editText10);
        editText1 = (EditText) findViewById(R.id.editText11);
        editText2 = (EditText) findViewById(R.id.editText12);
    }

    private void initLetters() {
        lettersArr0[0] = (TextView) findViewById(R.id.textView30);
        lettersArr0[1] = (TextView) findViewById(R.id.textView40);
        lettersArr0[2] = (TextView) findViewById(R.id.textView50);
        lettersArr0[3] = (TextView) findViewById(R.id.textView60);
        lettersArr0[4] = (TextView) findViewById(R.id.textView70);

        for (TextView textView : lettersArr0) {
        }
    }

    private void experimentWithTable() {

    }

    private void initUpAndDownButtons() {
        buttonUp0 = (ImageButton) findViewById(R.id.buttonUp00);
        buttonUp1 = (ImageButton) findViewById(R.id.buttonUp01);
        buttonUp2 = (ImageButton) findViewById(R.id.buttonUp02);
        buttonDown0 = (ImageButton) findViewById(R.id.buttonDown10);
        buttonDown1 = (ImageButton) findViewById(R.id.buttonDown11);
        buttonDown2 = (ImageButton) findViewById(R.id.buttonDown12);

        buttonUp0.setOnClickListener(this);
        buttonUp1.setOnClickListener(this);
        buttonUp2.setOnClickListener(this);
        buttonDown0.setOnClickListener(this);
        buttonDown1.setOnClickListener(this);
        buttonDown2.setOnClickListener(this);
    }



    private void animateLettersDown() {

        Animation аnimationDown_1 = AnimationUtils.loadAnimation(this, R.anim.caesar_cipher_letter_down_1);
        Animation аnimationDown_2 = AnimationUtils.loadAnimation(this, R.anim.caesar_cipher_letter_down_2);
        Animation аnimationDown_3 = AnimationUtils.loadAnimation(this, R.anim.caesar_cipher_letter_down_3);
        Animation аnimationDown_4 = AnimationUtils.loadAnimation(this, R.anim.caesar_cipher_letter_down_4);
        Animation аnimationDown_100 = AnimationUtils.loadAnimation(this, R.anim.caesar_cipher_letter_down);


        textView1.startAnimation(аnimationDown_100);
        textView2.startAnimation(аnimationDown_100);
        textView3.startAnimation(аnimationDown_100);
        textView4.startAnimation(аnimationDown_100);
 /*       textView1.startAnimation(аnimationDown_1);
        textView2.startAnimation(аnimationDown_2);
        textView3.startAnimation(аnimationDown_3);
        textView4.startAnimation(аnimationDown_4);*/
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonUp00:
                editTextPlus1(editText0);
                setLettersUp(lettersArr0);
                break;
            case R.id.buttonUp01:
//                editTextPlus1(editText1);
//                setLettersUp(lettersArr1);
                break;
            case R.id.buttonUp02:
//                editTextPlus1(editText2);
//                setLettersUp(lettersArr2);
                break;

            case R.id.buttonDown10:
                editTextMinus1(editText0);
                setLettersDown(lettersArr0);
                break;
            case R.id.buttonDown11:
//                editTextMinus1(editText1);
//                setLettersDown(lettersArr1);
                break;
            case R.id.buttonDown12:
//                editTextMinus1(editText2);
//                setLettersDown(lettersArr2);
                break;
        }
    }

    private void editTextPlus1(EditText editText) {
        String oldStr = editText.getText().toString().trim();
        int oldInt = Integer.parseInt(oldStr);
        if (oldInt == 31 || oldInt == -31) {
            editText.setText("0");
        } else {
            editText.setText(Integer.toString(++oldInt));
        }

    }

    private void editTextMinus1(EditText editText) {
        String oldStr = editText.getText().toString().trim();
        int oldInt = Integer.parseInt(oldStr);
        if (oldInt == 31 || oldInt == -31) {
            editText.setText("0");
        } else {
            editText.setText(Integer.toString(--oldInt));
        }
    }

    private void setLettersUp(TextView[] lettersArr) {
        for (TextView textView : lettersArr) {
            char oldChar = textView.getText().toString().charAt(0);
            if (oldChar == 'я') {
                textView.setText("а");
            } else {
                textView.setText(Character.toString(++oldChar));
            }
        }
    }

    private void setLettersDown(TextView[] lettersArr) {
        for (TextView textView : lettersArr) {
            char oldChar = textView.getText().toString().charAt(0);
            if (oldChar == 'а') {
                textView.setText("я");
            } else {
                textView.setText(Character.toString(--oldChar));
            }
        }
    }
}
