package com.celt.estation.template;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 00013811 on 2016/7/18.
 */
public class BeisaiActivity extends Activity {
    private BezierPiKaQiuView bezierFlowerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beisaier);
        intitView();


    }
    private void intitView(){
        bezierFlowerView = (BezierPiKaQiuView) findViewById(R.id.bfv);
    }
    public void test(View view) {

            bezierFlowerView.addFlower(BeisaiActivity.this);

    }
}
