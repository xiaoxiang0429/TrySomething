package com.tianzhen.viewpager2.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.util.LogTime;

/**
 * Description:
 * Created by Tian
 * on 2020/11/23
 */
public class FirstFramlayout extends FrameLayout {
    public FirstFramlayout(@NonNull Context context) {
        super(context);
    }

    public FirstFramlayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FirstFramlayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FirstFramlayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
        }
        Log.d("touchLog","first====" +ev.toString());
        return super.dispatchTouchEvent(ev);
    }
}
