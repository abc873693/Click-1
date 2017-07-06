package com.example.esicc.a20170704click;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Intent task2;
    String count;
    TextView ans;
    TextView x1;
    TextView x2;
    Button back;
    Button updata;
    Intent beck_link = new Intent();

    String input_name;
    Intent name = new Intent();

    int cnt=10;

    View.OnClickListener onClickListenerback;
    View.OnClickListener onClickListenerupdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        x1 = (TextView) findViewById(R.id.textView2);
        x2 = (TextView) findViewById(R.id.textView4);
        back = (Button) findViewById(R.id.button5);
        updata = (Button) findViewById(R.id.button6);
        ans = (TextView) findViewById(R.id.textView3);
        task2 = getIntent();
        count = task2.getStringExtra("count");
        ans.setText(count);

        onClickListenerback = new View.OnClickListener() { //返回首頁
            @Override
            public void onClick(View v) {
                beck_link.setClass(Main2Activity.this, Main3Activity.class);
                startActivity(beck_link);
            }
        };
        back.setOnClickListener(onClickListenerback);

        onClickListenerupdata = new View.OnClickListener() {// 上傳並輸入玩家資料
            @Override
            public void onClick(View v) {
                customDialog();
            }

            private void customDialog() {
                final View item = LayoutInflater.from(Main2Activity.this).inflate(R.layout.layout, null);
                new AlertDialog.Builder(Main2Activity.this)
                        .setTitle(R.string.input_ur_name)
                        .setView(item)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                cnt++;
                                EditText editText = (EditText) item.findViewById(R.id.editText);
                                input_name = editText.getText().toString();

                                name.putExtra("name",input_name);
                                name.putExtra("score",count);
                                name.putExtra("cnt",cnt);
                                name.setClass(Main2Activity.this, Main4Activity.class);
                                startActivity(name);

                                Toast.makeText(getApplicationContext(), getString(R.string.hi) , Toast.LENGTH_SHORT).show();

                            }
                        })
                        .show();
            }
        };
        updata.setOnClickListener(onClickListenerupdata);

    }
}