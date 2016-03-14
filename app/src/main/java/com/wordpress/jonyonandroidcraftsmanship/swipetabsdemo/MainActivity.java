package com.wordpress.jonyonandroidcraftsmanship.swipetabsdemo;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

    private ViewPager vpMain = null;
    private FragmentManager fragmentManager = null;
    private ViewPagerAdapter viewPagerAdapter = null;
    private ActionBar actionBar = null;
    private MyTabListener myTabListener = null;
    private MyOnPageChangeListener myOnPageChangeListener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        fragmentManager = getSupportFragmentManager();
        myTabListener = new MyTabListener();
        myOnPageChangeListener=new MyOnPageChangeListener();

        vpMain = (ViewPager) findViewById(R.id.vpMain);
        viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        vpMain.setAdapter(viewPagerAdapter);
        vpMain.addOnPageChangeListener(myOnPageChangeListener);

        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        createTabs();
    }

    private void createTabs() {
        for (int i = 0; i < 3; i++) {
            makeTab(i);
        }
    }

    private void makeTab(int position) {
        ActionBar.Tab tab = actionBar.newTab();
        tab.setText("TAB " + (position + 1));
        tab.setTabListener(myTabListener);
        actionBar.addTab(tab);
    }

    private class MyTabListener implements ActionBar.TabListener {

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            Logger.log("onTabSelected at " + tab.getPosition() + " name " + tab.getText());
            vpMain.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            Logger.log("onTabUnselected at " + tab.getPosition() + " name " + tab.getText());
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            Logger.log("onTabReselected at " + tab.getPosition() + " name " + tab.getText());
        }
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Logger.log("onPageSelected at position " + position + " from " + positionOffset + " with Number of Pixels " + positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            Logger.log("onPageSelected at position " + position);
            actionBar.setSelectedNavigationItem(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
                case ViewPager.SCROLL_STATE_IDLE:
                    Logger.log("onPageScrollStateChanged IDLE");
                    break;
                case ViewPager.SCROLL_STATE_DRAGGING:
                    Logger.log("onPageScrollStateChanged DRAGGING");
                    break;
                case ViewPager.SCROLL_STATE_SETTLING:
                    Logger.log("onPageScrollStateChanged SETTLING");
                    break;
                default:
                    break;
            }
        }
    }

}
