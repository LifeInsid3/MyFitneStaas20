package com.example.myfitnestaas20;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class LoadActivity extends AppCompatActivity {

    ImageView imv1;
    ImageView imv2;
    ImageView imv3;

    private Animation animations, animationsi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        imv1 = findViewById(R.id.LoadImv3);
        imv2 = findViewById(R.id.LoadImv4);
        imv3 = findViewById(R.id.LoadImv1);

        Animation animation = AnimationUtils.loadAnimation(LoadActivity.this, R.anim.anime);
        Animation animation2 = AnimationUtils.loadAnimation(LoadActivity.this, R.anim.anime2);


        animations = AnimationUtils.loadAnimation(LoadActivity.this, R.anim.animes);
        animationsi = AnimationUtils.loadAnimation(LoadActivity.this, R.anim.animesi);

        animations.setAnimationListener(animationsAnimetionsListener);
        animationsi.setAnimationListener(animationsAnimetionsiListener);

        imv1.startAnimation(animation2);
        imv2.startAnimation(animation);
        imv3.startAnimation(animations);

        Thread thread = new Thread(){

            public void run() {
                try {

                    TimeUnit.SECONDS.sleep(5);
                    Intent intent = new Intent(LoadActivity.this, AuthorizationActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        imv3.clearAnimation();
    }

    Animation.AnimationListener animationsAnimetionsListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

            imv3.startAnimation(animationsi);
        }

        @Override
        public void onAnimationEnd(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    Animation.AnimationListener animationsAnimetionsiListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
            // когда анимация уменьшения заканчивается,
            // то начинаем анимацию увеличения
            imv3.startAnimation(animations);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }
    };
}
