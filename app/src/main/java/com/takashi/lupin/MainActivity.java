package com.takashi.lupin;

import androidx.appcompat.app.AppCompatActivity;

import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private SoundPool sp;
    private int spId01;
    private int spId02;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spId01 = sp.load(this, R.raw.sound01,1);
        //spId01 = sp.load(this, R.raw.sound02,1);

        // コントロール参照設定
        final TextView tvStr = findViewById(R.id.textView);

        final String str = "全集中！！おっさんの呼吸！";
        final int count = 0;

        // 日時の書式設定
        //final SimpleDateFormat df = new SimpleDateFormat(
                //"yyyy/MM/dd\nHH:mm:ss");

        // タイマーの作成・生成
        Timer tmr = new Timer();

        TimerTask tsk = new TimerTask() {

            // メインスレッドに投げる処理
            Handler hnd = new Handler();

            // サブスレッドの処理
            @Override
            public void run() {

                // 現在日時の取得
                //Date dt = new Date();
                //final String str = df.format(dt);

                // メインスレッドに投げる処理
                // メインスレッド実行
                hnd.post(new Runnable() {
                    @Override
                    public void run() {

                        /*
                        char[] work = new char[str.length()];

                        for (int i = 0; i < str.length() ; i++) {

                            work[i] = str.charAt(i);

                            tvStr.append(str);



                        };*/

                        String[] strArray = new String[str.length()];

                        for (int i = 0; i < str.length() ; i++) {

                            String str2 = String.valueOf(str.charAt(i));
                            strArray[i] = str2;

                            //tvStr.append(str2);

                            //Log.v(strArray[i]);
                        }

                        /*

                        for (int i = 0; i < strArray.length; i++) {

                            tvStr.append(strArray[i]);
                        }*/


                        /*
                        if (count < str.length()) {

                            //Array arL = new Array(str)[count];

                           //String str2 = String(ArrayList(str)[count]);


                            //tvStr.append(str);

                        }*/



                        //tvStr.setText(str);

                        //tvStr.append("あたっ");

                    }
                });


            }
        };

        // javaでは秒はミリ秒　1000ミリ秒 は1秒
        tmr.schedule(tsk, 0, 1000);




    }
}