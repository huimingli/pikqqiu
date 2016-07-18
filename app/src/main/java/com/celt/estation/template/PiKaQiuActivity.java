package com.celt.estation.template;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by 00013811 on 2016/7/18.
 */
public class PiKaQiuActivity extends Activity implements View.OnClickListener{
    private ImageView iv_PiKaQiu;
    private Button btn_startAn;
    private int[] images = {R.mipmap.pikaqiu_1,R.mipmap.pikaqiu_2,R.mipmap.pikaqiu_3,
            R.mipmap.pikaqiu_4,R.mipmap.pikaqiu_5,R.mipmap.pikaqiu_6,
            R.mipmap.pikaqiu_7,R.mipmap.pikaqiu_8,R.mipmap.pikaqiu_9,
            R.mipmap.pikaqiu_10,R.mipmap.pikaqiu_11,R.mipmap.pikaqiu_12,
            R.mipmap.pikaqiu_13,R.mipmap.pikaqiu_14,R.mipmap.pikaqiu_15,
            R.mipmap.pikaqiu_16,R.mipmap.pikaqiu_17};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pikaqiu);
        intitView();


    }

    @Override
    public void onClick(View view) {
        startAnima();
    }


    private void startAnima() {
        ValueAnimator anim = ValueAnimator.ofInt(0, 16);
        anim.setDuration(1000);
        anim.setRepeatMode(ValueAnimator.RESTART);
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                iv_PiKaQiu.setImageResource(images[currentValue]);
                Log.d("TAG", "cuurent value is " + currentValue);
            }
        });
        anim.start();

        ObjectAnimator moveIn = ObjectAnimator.ofFloat(iv_PiKaQiu, "translationX", -100f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(iv_PiKaQiu, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(iv_PiKaQiu, "alpha", 1f, 0f, 1f);
        fadeInOut.setRepeatCount(ValueAnimator.INFINITE);
        rotate.setRepeatCount(ValueAnimator.INFINITE);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();
    }

    private void intitView(){
        iv_PiKaQiu = (ImageView) findViewById(R.id.pikaqiu);
        btn_startAn = (Button) findViewById(R.id.bt_startan);
        btn_startAn.setOnClickListener(this);
    }
}
