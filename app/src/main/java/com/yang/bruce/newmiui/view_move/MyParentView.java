package com.yang.bruce.newmiui.view_move;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Author: yjn
 * Date: 2016/12/6 9:35
 * Email: yang.jianan@zte.com.cn
 */

public class MyParentView extends LinearLayout {
    private int mMove;
    private int yDown, yMove;
    private int i = 0;

    private boolean isIntercept;

    public MyParentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 回弹 效果实现
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: //获取刚开始触碰的y坐标
                yDown = y;
                break;

            case MotionEvent.ACTION_MOVE: //如果是向下滑动，计算出每次滑动的距离与滑动的总距离，将每次滑动的距离作为layout(int l, int t, int r, int b)方法的参数，重新进行布局，达到布局滑动的效果。
                yMove = y;
                if ((yMove - yDown) > 0) { //向下滑动
                    mMove = yMove - yDown; // 向下滑动距离
                    i += mMove;
                    layout(getLeft(), getTop() + mMove, getRight(), getBottom() + mMove); //相对于父布局的位置
                }
                break;

            case MotionEvent.ACTION_UP: //将滑动的总距离作为layout(int l, int t, int r, int b)方法的参数，重新进行布局，达到布局自动回弹的效果。
                layout(getLeft(), getTop() - i, getRight(), getBottom() - i);
                i = 0;
                break;
        }

        return true;
    }

    /**
     * 外部拦截法：
     * 外部拦截法是指点击事件先经过父容器的拦截处理，如果父容器需要处理此事件就进行拦截，如果不需要此事件就不拦截，
     * 这样就可以解决滑动冲突的问题。外部拦截法需要重写父容器的onInterceptTouchEvent()方法，在内部做相应的拦截即可。
     *
     * 实现分析：
     * 在自定义的父布局中重写onInterceptTouchEvent()方法，MotionEvent.ACTION_MOVE的时候，进行判断。
     * 如果手指是向上滑动，onInterceptTouchEvent()返回false，表示父布局不拦截当前事件，当前事件交给子View处理，那么我们的子View就能滚动；
     * 如果手指是向下滑动，onInterceptTouchEvent()返回true，表示父布局拦截当前事件，当前事件交给父布局处理，那么我们父布局就能实现下拉回弹。
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                yDown = y;
                break;

            case MotionEvent.ACTION_MOVE:
                yMove = y;
                if ((yMove - yDown) < 0) { //向上滑动, 交由 子view(ScrollView) 消费事件
                    isIntercept = false;
                } else { //向下滑动, 父view 消费事件
                    isIntercept = true;
                }
                break;

            case MotionEvent.ACTION_UP:
                layout(getLeft(), getTop() - i, getRight(), getBottom() - i);
                i = 0;
                break;
        }

        return isIntercept;
    }
}
