package com.zx.customtoast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 自定义Toast(建造者模式)
 * <p>
 * 作者： 周旭 on 2017/7/10/0010.
 * 邮箱：374952705@qq.com
 * 博客：http://www.jianshu.com/u/56db5d78044d
 */

public class CustomToast {

    private static Toast mToast;
    private static Context mContext;
    

    public CustomToast(Builder builder) {
        if (mToast == null) {
            mToast = new Toast(mContext);
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_custom_toast, null);
        TextView textView = (TextView) view.findViewById(R.id.title_tv);
        LinearLayout rootLayout = (LinearLayout) view.findViewById(R.id.root_layout);
        textView.setText(builder.text);
        mToast.setView(view);
        mToast.setDuration(Toast.LENGTH_SHORT);
        if (builder.textColor != 0) {
            textView.setTextColor(builder.textColor);
        } else {
            //默认白色
            textView.setTextColor(Color.WHITE);
        }
        // 获取背景颜色，并且改变颜色  
        GradientDrawable drawable = (GradientDrawable) rootLayout.getBackground();
        if (builder.backgroundColor != 0) {
            drawable.setColor(builder.backgroundColor);
        } else {
            //默认的背景颜色
            drawable.setColor(mContext.getResources().getColor(R.color.color_3));
        }
        if (builder.gravity != 0) {
            mToast.setGravity(builder.gravity, 0, 0);
        } else {
            //默认，居中，显示
            mToast.setGravity(Gravity.CENTER, 0, 0);
        }
    }
    

    /**
     * 显示Toast
     */
    public void show() {
        mToast.show();
    }

    /**
     * builder
     */
    public static class Builder {
        private String text; //提示文言
        private int textColor; //文字颜色
        private int gravity; //相对窗体的位置
        private int backgroundColor; //toast背景颜色


        public Builder(Context context) {
            mContext = context;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public Builder setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public CustomToast build() {
            return new CustomToast(this);
        }
    }
}
