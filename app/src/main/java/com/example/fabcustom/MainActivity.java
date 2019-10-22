package com.example.fabcustom;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    FloatingActionButton fab1;
    FloatingActionButton fab2;
    Animation fabOpen;
    Animation fabClose;
    Animation rotateForward;
    Animation rotateBackward;
    boolean isOpen;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isOpen=false;
        fab= findViewById(R.id.fab);
        fab1= findViewById(R.id.fab1);
        fab2= findViewById(R.id.fab2);

        setAnimation();fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
            }
        });
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void setAnimation(){
        fabOpen= AnimationUtils.loadAnimation(this,R.anim.fab_open_android);
        fabClose= AnimationUtils.loadAnimation(this,R.anim.fab_close_android);
        rotateBackward= AnimationUtils.loadAnimation(this, R.anim.rotate_backward);
        rotateForward= AnimationUtils.loadAnimation(this, R.anim.rotate_forward);


    }
    public void animateFab(){
        if(isOpen){
            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isOpen=false;
        }
        else{
            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isOpen=true;
        }
    }
}
