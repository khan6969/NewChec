package com.example.newchec;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyViewPagerForTabs extends FragmentPagerAdapter {

    private final List<Fragment> fragmentsList = new ArrayList<>();
    private final List<String> FragmentListTitle = new ArrayList<>();

    public MyViewPagerForTabs(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return  fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentListTitle.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentListTitle.get(position);
    }


    public void addfragment (Fragment fragment, String title)
    {
        fragmentsList.add(fragment);
        FragmentListTitle.add(title);
    }
}
