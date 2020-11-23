package com.tianzhen.viewpager2.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;

import com.youth.banner.Banner;

/**
 * @author Tian
 * @date 2020/6/12.
 * email：piner1029@gmail.com
 * description：
 */
public class MyBanner extends Banner {
    private float xDistance, yDistance, xLast, yLast;

    public MyBanner(@NonNull Context context) {
        super(context);
    }

    public MyBanner(@NonNull Context context, @NonNull AttributeSet attrs) {
        super(context, attrs);
    }

    public MyBanner(@NonNull Context context, @NonNull AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        final int action = ev.getAction();
        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_MOVE: {
                final float curX = ev.getX();
                final float curY = ev.getY();
                float xDistance = Math.abs(curX - xLast);
                float yDistance = Math.abs(curY - yLast);
                if (xDistance > yDistance) {
                    requestDisallowInterceptTouchEvent(true);
                }else {
                    requestDisallowInterceptTouchEvent(false);
                }
                xLast = curX;
                yLast = curY;

                break;
            }
            case MotionEvent.ACTION_DOWN: {
                requestDisallowInterceptTouchEvent(true);
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                break;
            }
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

}