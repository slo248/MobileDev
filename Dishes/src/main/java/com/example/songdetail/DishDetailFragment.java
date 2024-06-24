package com.example.songdetail;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.songdetail.content.DishUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DishDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DishDetailFragment extends Fragment {

    public DishUtils.Dish mDish;

    public DishDetailFragment() {
        // Required empty public constructor
    }

    public static DishDetailFragment newInstance() {
        return new DishDetailFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(DishUtils.SONG_ID_KEY)) {
            // Load the content specified by the fragment arguments.
            mDish = DishUtils.SONG_ITEMS.get(getArguments()
                    .getInt(DishUtils.SONG_ID_KEY));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_dish_detail, container, false);
        if (mDish != null) {
            int imageResId = getResources().getIdentifier(mDish.imageName, "drawable", getActivity().getPackageName());
            ((ImageView) rootView.findViewById(R.id.thumbnail)).setImageResource(imageResId);
            ((TextView) rootView.findViewById(R.id.dish_title)).setText(mDish.title);
            ((TextView) rootView.findViewById(R.id.dish_detail)).setText(mDish.details);
        }
        return rootView;
    }

    public static DishDetailFragment newInstance (int selectedDish) {
        DishDetailFragment fragment = new DishDetailFragment();
        // Set the bundle arguments for the fragment.
        Bundle arguments = new Bundle();
        arguments.putInt(DishUtils.SONG_ID_KEY, selectedDish);
        fragment.setArguments(arguments);
        return fragment;
    }
}