package com.celt.estation.template;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.celt.estation.template.adapter.FreeListAdapter;
import com.celt.estation.template.base.BaseActivity;
import com.celt.estation.template.base.GetCaptchaRequest;
import com.celt.estation.template.base.GetFreeListRequest;
import com.celt.estation.template.bean.FreeApply;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sch.rfview.AnimRFRecyclerView;
import com.sch.rfview.decoration.DividerItemDecoration;
import com.sch.rfview.manager.AnimRFLinearLayoutManager;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button btn_anim_with_beisai;
    private Button btn_anim_without_beisai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }
    private void initView(){
        btn_anim_with_beisai = (Button) findViewById(R.id.bt_beisaier);
        btn_anim_without_beisai = (Button) findViewById(R.id.bt_nobeisaier);
        btn_anim_with_beisai.setOnClickListener(this);
        btn_anim_without_beisai.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_beisaier:
                startActivity(new Intent(MainActivity.this,BeisaiActivity.class));
                break;
            case R.id.bt_nobeisaier:
                startActivity(new Intent(MainActivity.this,PiKaQiuActivity.class));
                break;
            default:
                break;
        }
    }
}
