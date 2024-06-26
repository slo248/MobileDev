/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.ex3_22125076;

import static com.example.ex3_22125076.Application.choices;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ex3_22125076.content.DishUtils;

import java.util.List;

/**
 * An activity representing a list of dish titles (items). When one is
 * touched, an intent starts {@link DishDetailActivity} representing
 * dish details.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */

    /**
     * Sets up a dish list as a RecyclerView.
     *
     * @param savedInstanceState
     */
    private boolean mTwoPane = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_list);

        // Set the toolbar as the app bar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        // Get the dish list as a RecyclerView.
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.dish_list);
        recyclerView.setAdapter
                (new SimpleItemRecyclerViewAdapter(DishUtils.DISH_ITEMS));

        if (findViewById(R.id.dish_detail_container) != null) {
            mTwoPane = true;
        }
    }

    /**
     * The ReyclerView for the dish list.
     */
    class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter
            <SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<DishUtils.Dish> mValues;

        SimpleItemRecyclerViewAdapter(List<DishUtils.Dish> items) {
            mValues = items;
        }

        /**
         * This method inflates the layout for the dish list.
         * @param parent ViewGroup into which the new view will be added.
         * @param viewType The view type of the new View.
         * @return
         */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.dish_list_content, parent, false);
            return new ViewHolder(view);
        }

        /**
         * This method implements a listener with setOnClickListener().
         * When the user taps a dish title, the code checks if mTwoPane
         * is true, and if so uses a fragment to show the dish detail.
         * If mTwoPane is not true, it starts DishDetailActivity
         * using an intent with extra data about which dish title was selected.
         *
         * @param holder   ViewHolder
         * @param position Position of the dish in the array.
         */
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(String.valueOf(position + 1));
            holder.mContentView.setText(mValues.get(position).title);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        int selectedDish = holder.getAdapterPosition();
                        DishDetailFragment fragment =
                                DishDetailFragment.newInstance(selectedDish);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.dish_detail_container, fragment)
                                .addToBackStack(null)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, DishDetailActivity.class);
                        intent.putExtra(DishUtils.DISH_ID_KEY,
                                holder.getAdapterPosition());
                        context.startActivity(intent);
                    }
                }
            });
        }

        /**
         * Get the count of dish list items.
         * @return
         */
        @Override
        public int getItemCount() {
            return mValues.size();
        }

        /**
         * ViewHolder describes an item view and metadata about its place
         * within the RecyclerView.
         */
        class ViewHolder extends RecyclerView.ViewHolder {
            final View mView;
            final TextView mIdView;
            final TextView mContentView;
            DishUtils.Dish mItem;

            ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }
}
