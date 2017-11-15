package com.muhammed.kennyiyakala;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView skor ;
    TextView zaman ;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    int skorDeger;
    ImageView [] imageArray;
    Handler handler ;
    Runnable runnable ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skorDeger = 0;

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView10 = (ImageView) findViewById(R.id.imageView10);
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        imageView12 = (ImageView) findViewById(R.id.imageView12);

        imageArray = new ImageView[]{imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12};

        gorselSakla();



        new CountDownTimer(5000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                zaman = (TextView) findViewById(R.id.zaman);
                zaman.setText("Süre : " + millisUntilFinished / 1000 );
            }

            @Override
            public void onFinish() {
                zaman = (TextView) findViewById(R.id.zaman);
                zaman.setText("Süre Doldu");
            }
        }.start();
    }

    public void skoruArttir (View view) {
        skor = (TextView) findViewById(R.id.skor);
        skor.setText("Skor : " + skorDeger);
        skorDeger++;
        skor.setText("Skor : " + skorDeger);

    }

    public void gorselSakla () {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
            }
                Random r = new Random(11-0);
                int i = r.nextInt();
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 500);
            }

        };
        handler.post(runnable);
    }
}
