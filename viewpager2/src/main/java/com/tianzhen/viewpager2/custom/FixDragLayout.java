package com.tianzhen.viewpager2.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * @author: TianZhen
 * @date: 2020/7/3
 * @description:
 */
public class FixDragLayout extends FrameLayout {
    private boolean isNeedScroll = false;
    private float xDistance, yDistance, xLast, yLast;

    public FixDragLayout(@NonNull Context context) {
        super(context);
    }

    public FixDragLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FixDragLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

                if (yDistance > xDistance) {
                    requestDisallowInterceptTouchEvent(true);
                }

                xLast = curX;
                yLast = curY;

                break;
            }
            case MotionEvent.ACTION_DOWN: {
//                requestDisallowInterceptTouchEvent(true);
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                isNeedScroll = false;
                break;
            }
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                isNeedScroll = false;
//                requestDisallowInterceptTouchEvent(false);
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
