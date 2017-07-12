package com.zx.customtoast;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 自定义Toast
 */
public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        findViewById(R.id.show_toast_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //默认设置
                new CustomToast.Builder(mContext).setText("加入购物车成功").build().show();
            }
        });
        findViewById(R.id.show_toast2_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomToast.Builder(mContext)
                        .setText("加入购物车成功")
                        .setBackgroundColor(Color.RED)
                        .build()
                        .show();
            }
        });
    }
}
