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

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import android.view.MenuItem;

import com.example.ex3_22125076.content.DishUtils;

/**
 * An activity representing a single song detail screen.
 */
public class DishDetailActivity extends AppCompatActivity {

    // DishItem includes the song title and detail.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // This activity displays the detail. In a real-world scenario,
        // get the data from a content repository.
        if (savedInstanceState == null) {
            int selectedDish =
                    getIntent().getIntExtra(DishUtils.SONG_ID_KEY, 0);
            DishDetailFragment fragment =
                    DishDetailFragment.newInstance(selectedDish);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.song_detail_container, fragment)
                    .commit();
        }
    }

    /**
     * Performs action if the user selects the Up button.
     *
     * @param item Menu item selected (Up button)
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown.
            // NavUtils allows users to navigate up one level in the
            // application structure.
            NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
