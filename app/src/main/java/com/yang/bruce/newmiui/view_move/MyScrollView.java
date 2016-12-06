package com.yang.bruce.newmiui.view_move;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Author: yjn
 * Date: 2016/12/6 10:29
 * Email: yang.jianan@zte.com.cn
 */

public class MyScrollView extends ScrollView {


    public MyScrollView(Context context) {
        this(context, null);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 内部拦截法：内部拦截法是指点击事件先经过子View处理，如果子View需要此事件就直接消耗掉，否则就交给父容器进行处理，
     * 这样就可以解决滑动冲突的问题。内部拦截法需要配合requestDisallowInterceptTouchEvent()方法，来确定子View是否允许父布局拦截事件。
     * <p>
     * 实现分析：
     * 自定义一个ScrollView，重写onTouchEvent()方法，在MotionEvent.ACTION_MOVE的时候，得到滑动的距离。如果滑动的距离为0，表示子View已经滚动到开始位置，
     * 此时调用 getParent().requestDisallowInterceptTouchEvent(false)方法，允许父View进行事件拦截；
     * 如果滑动的距离不为0，表示子View没有滚动到开始位置，此时调用 getParent().requestDisallowInterceptTouchEvent(true)方法，禁止父View进行事件拦截。
     * 这样只要子View没有滚动到开始的位置，父布局都不会拦截事件，一旦子View滚动到开始的位置，父布局就开始拦截事件，形成连续的滑动。
     * 好了，针对其他场景更复杂的滑动冲突，解决滑动冲突的原理与方式无非就是这两种方法。
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:

                int scrollY = getScrollY();
                if (scrollY == 0) {
                    //允许父View进行事件拦截
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    //禁止父View进行事件拦截
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
        }
        return super.onTouchEvent(ev);

    }
}
