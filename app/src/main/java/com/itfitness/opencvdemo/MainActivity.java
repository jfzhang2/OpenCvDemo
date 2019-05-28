package com.itfitness.opencvdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itfitness.opencvdemo.one.OneActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intView();
        initListener();
    }

    private void initListener() {
        btOne.setOnClickListener(this);
    }

    private void intView() {
        btOne = (Button) findViewById(R.id.bt_one);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_one:
                gotoActivity(OneActivity.class);
                break;

         }
    }
    private void gotoActivity(Class clazz){
        startActivity(new Intent(this,clazz));
    }
}
