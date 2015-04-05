package com.zack.csdn.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zack.csdn.fragment.MainFragment;

public class TabAdapter extends FragmentPagerAdapter {
	public static final String tag = "TabAdapter";
	private String[] TITLES;

	public TabAdapter(FragmentManager fm,String[] titles) {
		super(fm);
		this.TITLES = titles;
	}

	@Override
	public Fragment getItem(int arg0) {
		MainFragment fragment = new MainFragment(arg0 + 1);
		return fragment;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return TITLES[position % TITLES.length];
	}

	@Override
	public int getCount() {
		return TITLES.length; //¸öÊý
	}
}
