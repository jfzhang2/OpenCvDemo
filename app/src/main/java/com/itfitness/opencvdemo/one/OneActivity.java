package com.itfitness.opencvdemo.one;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.itfitness.opencvdemo.R;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class OneActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bt;
    private ImageView img;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        initOpenCv();
        bt = (Button) findViewById(R.id.bt);
        img = (ImageView) findViewById(R.id.img);
        bt.setOnClickListener(this);
        initImg();
    }

    /**
     * 加载OpenCv库
     */
    private void initOpenCv() {
        boolean b = OpenCVLoader.initDebug();
        if(b){
            Toast.makeText(this, "加载成功", Toast.LENGTH_SHORT).show();
        }
    }

    private void initImg() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        img.setImageBitmap(bitmap);
    }

    @Override
    public void onClick(View v) {
        Mat src = new Mat();
        Mat dst = new Mat();
        Utils.bitmapToMat(bitmap,src);
        Imgproc.cvtColor(src,dst,Imgproc.COLOR_BGRA2GRAY);
        Utils.matToBitmap(dst,bitmap);
        img.setImageBitmap(bitmap);
        src.release();
        dst.release();
    }
}
