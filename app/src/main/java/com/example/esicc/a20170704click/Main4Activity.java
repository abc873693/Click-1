package com.example.esicc.a20170704click;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class Main4Activity extends AppCompatActivity {

    TextView no1;
    TextView no1_name;
    TextView no1_score;

    TextView no2;
    TextView no2_name;
    TextView no2_score;

    TextView no3;
    TextView no3_name;
    TextView no3_score;

    TextView no4;
    TextView no4_name;
    TextView no4_score;

    TextView no5;
    TextView no5_name;
    TextView no5_score;

    Button back;
    Intent beck_link = new Intent();
    View.OnClickListener onClickListenerback;

    Intent name ;
    String name_str,score_str;
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        back = (Button)findViewById(R.id.button7);

        no1 = (TextView)findViewById(R.id.textView6) ;
        no1_name = (TextView)findViewById(R.id.textView7) ;
        no1_score = (TextView)findViewById(R.id.textView8) ;
        no2 = (TextView)findViewById(R.id.textView9) ;
        no2_name = (TextView)findViewById(R.id.textView10) ;
        no2_score = (TextView)findViewById(R.id.textView11) ;
        no3 = (TextView)findViewById(R.id.textView12) ;
        no3_name = (TextView)findViewById(R.id.textView13) ;
        no3_score = (TextView)findViewById(R.id.textView14) ;
        no4 = (TextView)findViewById(R.id.textView15) ;
        no4_name = (TextView)findViewById(R.id.textView16) ;
        no4_score = (TextView)findViewById(R.id.textView17) ;
        no5 = (TextView)findViewById(R.id.textView18) ;
        no5_name = (TextView)findViewById(R.id.textView19) ;
        no5_score = (TextView)findViewById(R.id.textView20) ;

        name = getIntent();
        name_str = name.getStringExtra("name");
        score_str = name.getStringExtra("score");
        cnt =  parseInt(name.getStringExtra("cnt"));

        SharedPreferences name_data = getSharedPreferences("id_name",MODE_PRIVATE);  //初始化
        SharedPreferences score_data = getSharedPreferences("id_score",MODE_PRIVATE);
        SharedPreferences name_data2 = getSharedPreferences("id_name2",MODE_PRIVATE);
        SharedPreferences score_data2 = getSharedPreferences("id_score2",MODE_PRIVATE);
        SharedPreferences name_data3 = getSharedPreferences("id_name3",MODE_PRIVATE);
        SharedPreferences score_data3 = getSharedPreferences("id_score3",MODE_PRIVATE);
        SharedPreferences name_data4 = getSharedPreferences("id_name4",MODE_PRIVATE);
        SharedPreferences score_data4 = getSharedPreferences("id_score4",MODE_PRIVATE);
        SharedPreferences name_data5 = getSharedPreferences("id_name5",MODE_PRIVATE);
        SharedPreferences score_data5 = getSharedPreferences("id_score5",MODE_PRIVATE);

        switch(cnt){
            case(0):
                break;
            case(1):
                 name_data.edit().putString("save_name",name_str).apply();
                score_data.edit().putString("save_score",score_str).apply();
                //存入資料，丟入的參數為(key , value)
                break;
            case(2):
                name_data2.edit().putString("save_name2",name_str).apply();
                score_data2.edit().putString("save_score2",score_str).apply();
                //存入資料，丟入的參數為(key , value)
                break;
            case(3):
                name_data3.edit().putString("save_name3",name_str).apply();
                score_data3.edit().putString("save_score3",score_str).apply();
                //存入資料，丟入的參數為(key , value)
                break;
            case(4):
                name_data4.edit().putString("save_name4",name_str).apply();
                score_data4.edit().putString("save_score4",score_str).apply();
                //存入資料，丟入的參數為(key , value)
                break;
            case(5):
                name_data5.edit().putString("save_name5",name_str).apply();
                score_data5.edit().putString("save_score5",score_str).apply();
                //存入資料，丟入的參數為(key , value)
                break;
            default:
                break;
        }

        no1_name.setText(name_data.getString("save_name",""));
        no1_score.setText(score_data.getString("save_score",""));
        no2_name.setText(name_data2.getString("save_name2",""));
        no2_score.setText(score_data2.getString("save_score2",""));
        no3_name.setText(name_data3.getString("save_name3",""));
        no3_score.setText(score_data3.getString("save_score3",""));
        no4_name.setText(name_data4.getString("save_name4",""));
        no4_score.setText(score_data4.getString("save_score4",""));
        no5_name.setText(name_data5.getString("save_name5",""));
        no5_score.setText(score_data5.getString("save_score5",""));

//        parseInt 字串轉整數
//        name_data.getString("no1_name","");
//        score_data.getString("no1_score","");
//        取出資料， 丟入的參數為(key , 若是沒值，預設為多少)
//        name_data.edit().putString("name",name_str).apply();
//        score_data.edit().putString("score",score_str).apply();
//        //存入資料，丟入的參數為(key , value)


        onClickListenerback = new View.OnClickListener() { //返回首頁
            @Override
            public void onClick(View v) {
                beck_link.setClass(Main4Activity.this,Main3Activity.class);
                startActivity(beck_link);
            }
        };
        back.setOnClickListener(onClickListenerback);
    }
}
