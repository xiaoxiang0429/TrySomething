package com.tianzhen.viewpager2.model;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;

import androidx.viewpager2.widget.ViewPager2;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.Intrinsics;

public final class NestedScrollableHost extends FrameLayout {
    private int touchSlop;
    private float initialX;
    private float initialY;
    private ViewPager2 viewpager2;

    private final ViewPager2 getParentViewPager() {
        ViewParent parentView = this.getParent();
        if (!(parentView instanceof View)) {
            parentView = null;
        }

        View v;
        for (v = (View) parentView; v != null && !(v instanceof ViewPager2); v = (View) parentView) {
            parentView = v.getParent();
            if (!(parentView instanceof View)) {
                parentView = null;
            }
        }

        View var2 = v;
        if (!(v instanceof ViewPager2)) {
            var2 = null;
        }

        return (ViewPager2) var2;
    }

    private final View getChild() {
        return this.getChildCount() > 0 ? this.getChildAt(0) : null;
    }

    private final boolean canChildScroll(int orientation, float delta) {
        boolean var5 = false;
        int direction = -((int) Math.signum(delta));
        View view;
        boolean var6;
        switch (orientation) {
            case 0:
                view = this.getChild();
                var6 = view != null ? view.canScrollHorizontally(direction) : false;
                break;
            case 1:
                view = this.getChild();
                var6 = view != null ? view.canScrollVertically(direction) : false;
                break;
            default:
                throw new IllegalArgumentException();
        }

        return var6;
    }

    @Override
    public boolean onInterceptTouchEvent(@NotNull MotionEvent e) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        this.handleInterceptTouchEvent(e);
        return super.onInterceptTouchEvent(e);
    }

    private final void handleInterceptTouchEvent(MotionEvent e) {
        ViewPager2 parentViewpager = this.getParentViewPager();
        if (parentViewpager != null) {
            int orientation = parentViewpager.getOrientation();
            if (this.canChildScroll(orientation, -1.0F) || this.canChildScroll(orientation, 1.0F)) {
                if (e.getAction() == MotionEvent.ACTION_DOWN) {
                    this.initialX = e.getX();
                    this.initialY = e.getY();
                    this.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (e.getAction() == MotionEvent.ACTION_MOVE) {
                    float dx = e.getX() - this.initialX;
                    float dy = e.getY() - this.initialY;
                    boolean isVpHorizontal = orientation == ViewPager2.ORIENTATION_HORIZONTAL;
                    boolean var8 = false;
                    float scaledDx = Math.abs(dx) * (isVpHorizontal ? 0.5F : 1.0F);
                    boolean var9 = false;
                    float scaledDy = Math.abs(dy) * (isVpHorizontal ? 1.0F : 0.5F);
                    if (scaledDx > (float) this.touchSlop || scaledDy > (float) this.touchSlop) {
                        if (isVpHorizontal == scaledDy > scaledDx) {
                            this.getParent().requestDisallowInterceptTouchEvent(false);
                        } else if (this.canChildScroll(orientation, isVpHorizontal ? dx : dy)) {
                            this.getParent().requestDisallowInterceptTouchEvent(true);
                        } else {
                            this.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }

            }
        }
    }

    public NestedScrollableHost(@NotNull Context context) {
        super(context);
    }

    public NestedScrollableHost(@NotNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

}
