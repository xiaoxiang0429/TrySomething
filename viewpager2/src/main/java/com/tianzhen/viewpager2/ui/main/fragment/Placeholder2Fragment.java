package com.tianzhen.viewpager2.ui.main.fragment;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.tianzhen.viewpager2.R;
import com.tianzhen.viewpager2.databinding.FragmentPlaceholder2Binding;
import com.tianzhen.viewpager2.model.Book;
import com.tianzhen.viewpager2.ui.main.PageViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class Placeholder2Fragment extends Fragment {

    private static final String ARG_BOOK = "bean_book";


    public static Placeholder2Fragment newInstance(Book book) {
        Placeholder2Fragment fragment = new Placeholder2Fragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_BOOK, book);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        FragmentPlaceholder2Binding fragmentPlaceholder2Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_placeholder2, container, false);
        if (getArguments() != null) {
            Book book = (Book) getArguments().getSerializable(ARG_BOOK);
            fragmentPlaceholder2Binding.setBook(book);
        }
        return fragmentPlaceholder2Binding.getRoot();
    }
}