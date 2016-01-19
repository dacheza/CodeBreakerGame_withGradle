package ru.codebreakergame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    private TabLayout tabLayout;
    private ViewPager viewPager;

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
}
