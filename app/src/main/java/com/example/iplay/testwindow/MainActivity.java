package com.example.iplay.testwindow;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity implements View.OnTouchListener {

    private WindowManager windowManager;
    private LayoutParams layout;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);

        // 获取Service
        windowManager = (WindowManager) getSystemService("window");

        imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        imageView.setOnTouchListener(this);

        // 设置窗口类型，一共有三种Application windows, Sub-windows, System windows
        layout = new WindowManager.LayoutParams();

        // API中以TYPE_开头的常量有23个
        layout.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        // 设置期望的bitmap格式
        layout.format = PixelFormat.RGBA_8888;

        // 以下属性在Layout Params中常见重力、坐标，宽高
        layout.gravity = Gravity.LEFT | Gravity.TOP;
        layout.x = 100;
        layout.y = 100;
        layout.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layout.height = WindowManager.LayoutParams.WRAP_CONTENT;

        // 添加指定视图
        windowManager.addView(imageView, layout);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int rawX = (int)event.getRawX();
        int rawY = (int)event.getRawY();


        switch (event.getAction())
        {
            case MotionEvent.ACTION_MOVE:
                layout.x = rawX;
                layout.y = rawY;

                windowManager.updateViewLayout(imageView, layout);
                break;
        }

        return false;
    }
}
