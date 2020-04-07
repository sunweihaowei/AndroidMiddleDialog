package com.example.androidmiddledialog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {
    private TextView cancel;
    private TextView ok;
    private ImageView icon;
    private static String TAG = "DialogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //隐藏标题栏
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        cancel = findViewById(R.id.btn_cancel);
        ok = findViewById(R.id.btn_ok);
        icon = findViewById(R.id.close_icon);

        Intent intent = getIntent();
        String data = intent.getStringExtra("param");
        Log.d(TAG, "【onCreate】: 接受到的数据="+data);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "【onClick】: 点击关闭");
                //点击cancel的逻辑
                Intent intent = new Intent();
                intent.putExtra("data_return", "i am cancel");
                setResult(Constants.DIALOG_CANCEL_CODE, intent);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "【onClick】: 点击cancle");
                //点击cancel的逻辑
                Intent intent = new Intent();
                intent.putExtra("data_return", "i am cancel");
                setResult(Constants.DIALOG_CANCEL_CODE, intent);
                finish();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "【onClick】: 点击ok");
                //点击ok的逻辑
                Intent intent = new Intent();
                intent.putExtra("data_return", "i am ok!");
                setResult(Constants.DIALOG_OK_CODE, intent);
                finish();
            }
        });
    }
}
