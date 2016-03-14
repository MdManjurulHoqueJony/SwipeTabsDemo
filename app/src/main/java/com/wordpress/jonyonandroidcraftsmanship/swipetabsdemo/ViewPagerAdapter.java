package com.wordpress.jonyonandroidcraftsmanship.swipetabsdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//        Logger.log("getItem() "+position+" is called !");
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new AFragment();
                break;
            case 1:
                fragment = new BFragment();
                break;
            case 2:
                fragment = new CFragment();
                break;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
//        Logger.log("getCount() is called !");
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String title = new String();
        switch (position) {
            case 0:
                title = "TAB 1";
                break;
            case 1:
                title = "TAB 2";
                break;
            case 2:
                title = "TAB 3";
                break;
            default:
                break;
        }
        return title;
    }

}
