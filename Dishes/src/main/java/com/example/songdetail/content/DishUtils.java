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

package com.example.songdetail.content;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample song content.
 */
public class DishUtils {

    // An ArrayList of Dishs
    public static final List<Dish> SONG_ITEMS = new ArrayList<>();

    // The ID for the index into song titles.
    public static final String SONG_ID_KEY = "item_id";

    // The number of songs.
    private static final int COUNT = 7;

    /**
     * A Dish item represents a song title, and song details.
     */
    public static class Dish {
        public final String song_title;
        public final String details;

        private Dish(String content, String details) {
            this.song_title = content;
            this.details = details;
        }
    }

    /**
     * Add an item to the array.
     *
     * @param item Each song
     */
    private static void addItem(Dish item) {
        SONG_ITEMS.add(item);
    }

    static {
        // Fill the array with songs.
        for (int i = 0; i < COUNT; i++) {
            addItem(createDishAtPosition(i));
        }
    }

    private static Dish createDishAtPosition(int position) {
        String newTitle;
        String newDetail;
        switch (position) {
            case 0:
                newTitle = "Pho";
                newDetail = "Pho\n\nPho is a popular food in Vietnam. It's a type of noodle soup that consists of broth, rice noodles, and meat, usually beef or chicken. Pho is often served with a side of fresh herbs, lime, and chili.";
                break;
            case 1:
                newTitle = "Banh Mi";
                newDetail = "Banh Mi\n\nBanh Mi is a Vietnamese sandwich that is a fusion of meats and vegetables from native Vietnamese cuisine such as chả lụa (pork sausage), coriander leaf (cilantro), cucumber, pickled carrots, and pickled daikon combined with condiments from French cuisine such as pâté, along with jalapeño and mayonnaise.";
                break;
            case 2:
                newTitle = "Bun Cha";
                newDetail = "Bun Cha\n\nBun Cha is a Vietnamese dish of grilled pork and noodle, which is thought to have originated from Hanoi, Vietnam. Bun cha is served with grilled fatty pork (chả) over a plate of white rice noodle (bún) and herbs with a side dish of dipping sauce.";
                break;
            case 3:
                newTitle = "Goi Cuon";
                newDetail = "Goi Cuon\n\nGoi Cuon, also known as Vietnamese spring roll, is a Vietnamese dish traditionally consisting of pork, prawn, vegetables, bún (rice vermicelli), and other ingredients wrapped in Vietnamese bánh tráng (commonly known as rice paper or cold roll).";
                break;
            case 4:
                newTitle = "Banh Xeo";
                newDetail = "Banh Xeo\n\nBanh Xeo is a crispy, stuffed rice pancake popular in Vietnam. Banh Xeo is stuffed with individual preferences, and therefore, can include a variety of ingredients. A common stuffing includes pork slices, shrimps, diced green onion, mung bean, and bean sprouts.";
                break;
            case 5:
                newTitle = "Cao Lau";
                newDetail = "Cao Lau\n\nCao Lau is a regional Vietnamese dish made with noodles, pork, and local greens, that is found only in the town of Hội An, in the Quảng Nam Province of central Vietnam. Its unique taste and texture is achieved by using water from an ancient well, just outside of the town.";
                break;
            default:
                newTitle = "Cha Ca";
                newDetail = "Cha Ca\n\nCha Ca, also known as Cha Ca La Vong, is a famous dish from Hanoi. The main ingredients are grilled fish, turmeric, dill, shrimp paste, and rice noodles.";
                break;
        }
        return new Dish(newTitle, newDetail);
    }
}
