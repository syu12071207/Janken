package com.example.tk.janken;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView result;
    TextView en;
    int self = 0;
    int enemy = 0;
    int judge = 0;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.result);
        en = (TextView)findViewById(R.id.enemy);
    }

    public void judge(View v){
        enemy = random.nextInt(3) + 1;

        switch(enemy){
            case 1:
                en.setBackgroundColor(Color.rgb(0,0,255));
                en.setText("グー");
                break;

            case 2:
                en.setBackgroundColor(Color.rgb(0,255,0));
                en.setText("チョキ");
                break;
            case 3:
                en.setBackgroundColor(Color.rgb(255,0,0));
                en.setText("パー");
                break;
        }

        switch(v.getId()){

            case R.id.rock:
                self = 1;
                if(enemy == 1){
                    draw();
                }else if(enemy == 2){
                    win();
                }else{
                    lose();
                }
                break;

            case R.id.scissors:
                self = 2;
                if(enemy == 2){
                    draw();
                }else if(enemy == 3){
                    win();
                }else{
                    lose();
                }
                break;

            case R.id.paper:
                self = 3;
                if(enemy == 3){
                    draw();
                }else if(enemy == 1){
                    win();
                }else{
                    lose();
                }
                break;
        }
    }

    public void draw(){
        result.setText("あいこ");
    }

    public void win(){
        result.setText("勝ち");
    }

    public void lose(){
        result.setText("負け");
    }
}
