package com.thomascbeerten.libstest.app;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.navdrawer.SimpleSideDrawer;


public class MainActivity extends ActionBarActivity {
    private SimpleSideDrawer mSlidingMenu;
    LinearLayout menu1;
    LinearLayout menu2;
    LinearLayout menu3;
    LinearLayout menu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlidingMenu = new SimpleSideDrawer(this);
        mSlidingMenu.setLeftBehindContentView(R.layout.behind_menu_left);


        ImageButton btnOpen = (ImageButton) findViewById(R.id.btnToggle);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlidingMenu.openLeftSide();
            }
        });

        menu1 = (LinearLayout) findViewById(R.id.menu1);
        menu2 = (LinearLayout) findViewById(R.id.menu2);
        menu3 = (LinearLayout) findViewById(R.id.menu3);
        menu4 = (LinearLayout) findViewById(R.id.menu4);

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchFragment(0);
            }
        });

        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchFragment(1);
            }
        });

        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchFragment(2);
            }
        });

        menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchFragment(3);
            }
        });

        ReplaceFragment(new FragmentWelcome());

    }

    private void ReplaceFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    private void SwitchFragment(int i) {
        switch (i) {
            case 0:
                ReplaceFragment(new Fragment1());
                break;
            case 1:
                ReplaceFragment(new Fragment2());
                break;
            case 2:
                ReplaceFragment(new Fragment3());
                break;
            case 3:
                ReplaceFragment(new Fragment4());
                break;
        }
        mSlidingMenu.closeLeftSide();
    }

}
