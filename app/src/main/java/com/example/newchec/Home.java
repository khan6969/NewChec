package com.example.newchec;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class Home extends Fragment {
     TabLayout tabLayout;
     ViewPager viewPager;


    public Home() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewpager);
        setViewPager();
        return view;


    }

    private void setViewPager() {
        MyViewPagerForTabs adapter = new ProductViewPagerAdapter(getChildFragmentManager());

        adapter.addfragment((new Men()), "Men");
        adapter.addfragment((new Women()), "Women");
        adapter.addfragment((new Curvy()), "Curvy");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    }


