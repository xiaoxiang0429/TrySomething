package com.tianzhen.viewpager2.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.tabs.TabLayout;
import com.tianzhen.viewpager2.R;
import com.tianzhen.viewpager2.databinding.FragmentMainBinding;
import com.tianzhen.viewpager2.databinding.FragmentPlaceholder1Binding;
import com.tianzhen.viewpager2.model.Book;
import com.tianzhen.viewpager2.ui.adapter.EasyAdapter;
import com.tianzhen.viewpager2.ui.adapter.ViewHolder;
import com.tianzhen.viewpager2.ui.main.PageViewModel;
import com.tianzhen.viewpager2.ui.main.SectionsPager1Adapter;
import com.tianzhen.viewpager2.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class Placeholder1Fragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    private FragmentPlaceholder1Binding viewBinding;


    public static Placeholder1Fragment newInstance(int index) {
        Placeholder1Fragment fragment = new Placeholder1Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_placeholder1, container, false);
        initView();
        return viewBinding.getRoot();
    }

    private void initView() {
        SectionsPager1Adapter sectionsPagerAdapter = new SectionsPager1Adapter(getActivity(), getParentFragmentManager());
        ViewPager viewPager = viewBinding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        viewBinding.tabs.setupWithViewPager(viewPager);

    }

}