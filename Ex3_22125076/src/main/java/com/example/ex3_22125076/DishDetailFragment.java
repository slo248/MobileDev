package com.example.ex3_22125076;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ex3_22125076.content.DishUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DishDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DishDetailFragment extends Fragment implements ReviewFragment.OnFragmentInteractionListener {
    public DishUtils.Dish mDish;
    private Button mButton;
    private Options mRadioButtonChoice = Options.NONE; // The default (no choice).
    private boolean isFragmentDisplayed = false;
    // Saved instance state key.
    static final String STATE_FRAGMENT = "state_of_fragment";

    public DishDetailFragment() {
        // Required empty public constructor
    }

    public static DishDetailFragment newInstance() {
        return new DishDetailFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(DishUtils.DISH_ID_KEY)) {
            // Load the content specified by the fragment arguments.
            mDish = DishUtils.DISH_ITEMS.get(getArguments()
                    .getInt(DishUtils.DISH_ID_KEY));
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

        mButton = rootView.findViewById(R.id.btnReview);

        // If returning from a configuration change, get the
        // fragment state and set the button text.
        if (savedInstanceState != null) {
            isFragmentDisplayed = savedInstanceState.getBoolean(STATE_FRAGMENT);
            if (isFragmentDisplayed) {
                // If the fragment is displayed, change button to "close".
                mButton.setText(R.string.close);
            }
        }
        // Set the click listener for the button.
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFragmentDisplayed) {
                    displayFragment();
                } else {
                    closeFragment();
                }
            }
        });
        
        return rootView;
    }

    /**
     * This method is called when the user clicks the button
     * to open the fragment.
     */
    private void displayFragment() {
        // Instantiate the fragment.
        ReviewFragment reviewFragment = ReviewFragment.newInstance(mRadioButtonChoice);
        // Get the FragmentManager and start a transaction.
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Add the ReviewFragment.
        fragmentTransaction.replace(R.id.fragment_container, reviewFragment).commit();

        // Update the Button text.
        mButton.setText(R.string.close);
        // Set boolean flag to indicate fragment is open.
        isFragmentDisplayed = true;
    }

    /**
     * This method is called when the user clicks the button to
     * close the fragment.
     */
    private void closeFragment() {
        // Get the FragmentManager.
        FragmentManager fragmentManager = getChildFragmentManager();
        // Check to see if the fragment is already showing.
        ReviewFragment reviewFragment = (ReviewFragment) fragmentManager
                .findFragmentById(R.id.fragment_container);
        if (reviewFragment != null) {
            // Create and commit the transaction to remove the fragment.
            FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();
            fragmentTransaction.remove(reviewFragment).commit();
        }
        // Update the Button text.
        mButton.setText(R.string.open);
        // Set boolean flag to indicate fragment is closed.
        isFragmentDisplayed = false;
    }

    @Override
    public void onRadioButtonChoice(Options choice) {
        // Keep the radio button choice to pass it back to the fragment.
        mRadioButtonChoice = choice;
        Toast.makeText(getActivity(), "Choice is " + choice.toString(),Toast.LENGTH_SHORT).show();
    }

    public static DishDetailFragment newInstance (int selectedDish) {
        DishDetailFragment fragment = new DishDetailFragment();
        // Set the bundle arguments for the fragment.
        Bundle arguments = new Bundle();
        arguments.putInt(DishUtils.DISH_ID_KEY, selectedDish);
        fragment.setArguments(arguments);
        return fragment;
    }
}