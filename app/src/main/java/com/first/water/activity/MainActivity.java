package com.first.water.activity;


import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.first.water.R;



public class MainActivity extends AppCompatActivity {

    private MainFragment main;
    private MyFragment my;
    private PayFragment pay;
    private RadioGroup group;

    public FragmentManager fragmentManager;
    public FragmentTransaction beginTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        group = (RadioGroup)findViewById(R.id.radio1);
        fragmentManager=getSupportFragmentManager();
        beginTransaction=fragmentManager.beginTransaction();
        beginTransaction.add(R.id.all,new MainFragment()).commit();

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                beginTransaction =
                        fragmentManager.beginTransaction();
                switch(checkedId) {
                    case R.id.mainPage:
                        if (main == null) {
                            main = new MainFragment();
                        }
                        beginTransaction.replace(R.id.all, main);
                        break;
                    case R.id.payPage:
                        if (pay == null) {
                            pay = new PayFragment();
                        }
                        beginTransaction.replace(R.id.all,pay);
                        break;
                    case R.id.myPage:
                        if (my == null) {
                            my = new MyFragment();
                        }
                        beginTransaction.replace(R.id.all, my);
                        break;
                }
                beginTransaction.commit();
            }
        });

    }


}

