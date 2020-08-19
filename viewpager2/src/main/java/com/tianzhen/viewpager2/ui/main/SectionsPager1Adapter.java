package com.tianzhen.viewpager2.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.tianzhen.viewpager2.R;
import com.tianzhen.viewpager2.ui.main.fragment.Placeholder1Fragment;
import com.tianzhen.viewpager2.ui.main.fragment.Placeholder2Fragment;
import com.tianzhen.viewpager2.ui.main.fragment.PlaceholderFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPager1Adapter extends FragmentStatePagerAdapter {

    private static final String[] TAB_TITLES = new String[]{"fragment1 tab1", "fragment1 tab2"};
    private final Context mContext;

    public SectionsPager1Adapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_TITLES[position];
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}