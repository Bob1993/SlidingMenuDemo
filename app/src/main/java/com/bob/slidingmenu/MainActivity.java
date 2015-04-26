package com.bob.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.bob.slidingmenu.fragment.LeftFragment;
import com.bob.slidingmenu.fragment.TodayFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity implements
        OnClickListener{
    private ImageView topButton;//顶部呼出侧边菜单的按钮
    private Fragment mContent;//当前显示在主界面的fragment
    private TextView titleView;//当前主界面的标题

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSlidingMenu(savedInstanceState);//用可能包含有数据的bundle来初始化侧边栏菜单
        topButton= (ImageView) findViewById(R.id.topButton);
        topButton.setOnClickListener(this);
        titleView= (TextView) findViewById(R.id.topTv);
    }

    private void initSlidingMenu(Bundle saveInstanceState){
        if (saveInstanceState!= null) {
            mContent= getFragmentManager().getFragment(saveInstanceState,"mContent");
            //FragManager从数据集（里边以键值对存储）中获取fragment的方法
        }
        if (mContent== null)
        {//没能从数据集中获取到fragment，表示第一次初始化侧边栏，默认显示Today
            mContent= new TodayFragment();//一定要注意v4包与app包的引入区分
        }

		/** 设置左侧滑动菜单
		 * fragment必须要有父布局，而且在替换的时候，也是以父布局为依据来替换里边的fragment的
		 */
        setBehindContentView(R.layout.menu_frame_left);//设置菜单的父布局
        getFragmentManager().beginTransaction().replace(R.id.menu_frame, new LeftFragment()).commit();
        //植入策划菜单的fragment

        /**
         * 设置策划菜单参数
         */
        SlidingMenu sm= getSlidingMenu();//获取当前活动的侧滑菜单对象
        sm.setMode(SlidingMenu.LEFT);//选择滑动模式
        sm.setShadowWidth(R.dimen.shadow_width);//设置滑动阴影的宽度
        sm.setShadowDrawable(null);//设置阴影背景
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);//设置菜单宽度
        sm.setFadeDegree(0.35f);//设置渐入渐出效果参数
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//设置全屏滑动
        sm.setBehindScrollScale(0.0f);//设置下方视图在滚动时的缩放比例

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getFragmentManager().putFragment(outState,"mContent",mContent);
        //在活动被暂停时，利用manager给数据束里添加当前显示的fragment，以便在程序返回MainActivity时又重新显示离开时的样子
    }

    public void switchContent(Fragment fragment, String title) {//点击切换后空FrameLayout才会被填入（替换）为新的fragment
        mContent= fragment;
        getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        //植入或者称替换掉当前显示的fragment，其中content_frame为当前显示页面的父布局
        getSlidingMenu().showContent();
        titleView.setText(title);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.topButton:
                toggle();
                break;
        }
    }
}
