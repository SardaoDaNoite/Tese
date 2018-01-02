package com.example.ricardosousa.tese;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo Sousa on 1/2/2018.
 */

public class PageAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> FragmentList = new ArrayList<>();
    private final List<String> FragmentTitle = new ArrayList<>();

    public void AddFragment(Fragment frag , String Title){
        FragmentList.add(frag);
        FragmentTitle.add(Title);
    }

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentTitle.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentList.size();
    }
}
