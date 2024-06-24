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
        public final String title;
        public final String details;
        public final String imageName;

        private Dish(String content, String details, String imageName) {
            this.title = content;
            this.details = details;
            this.imageName = imageName;
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
        String imageName;
        switch (position) {
            case 0:
                newTitle = "Phở";
                newDetail = "Phở is a popular food in Vietnam. It's a type of noodle soup that consists of broth, rice noodles, and meat, usually beef or chicken. Phở is often served with a side of fresh herbs, lime, and chili.";
                imageName = "pho";
                break;
            case 1:
                newTitle = "Bánh Mì";
                newDetail = "Bánh Mì is a Vietnamese sandwich that is a fusion of meats and vegetables from native Vietnamese cuisine such as chả lụa (pork sausage), coriander leaf (cilantro), cucumber, pickled carrots, and pickled daikon combined with condiments from French cuisine such as pâté, along with jalapeño and mayonnaise.";
                imageName = "banh_mi";
                break;
            case 2:
                newTitle = "Bún Chả";
                newDetail = "Bún Chả is a Vietnamese dish of grilled pork and noodle, which is thought to have originated from Hanoi, Vietnam. Bún Chả is served with grilled fatty pork (chả) over a plate of white rice noodle (bún) and herbs with a side dish of dipping sauce.";
                imageName = "bun_cha";
                break;
            case 3:
                newTitle = "Gỏi Cuốn";
                newDetail = "Gỏi Cuốn, also known as Vietnamese spring roll, is a Vietnamese dish traditionally consisting of pork, prawn, vegetables, bún (rice vermicelli), and other ingredients wrapped in Vietnamese bánh tráng (commonly known as rice paper or cold roll).";
                imageName = "goi_cuon";
                break;
            case 4:
                newTitle = "Bánh Xèo";
                newDetail = "Bánh Xèo is a crispy, stuffed rice pancake popular in Vietnam. Bánh Xèo is stuffed with individual preferences, and therefore, can include a variety of ingredients. A common stuffing includes pork slices, shrimps, diced green onion, mung bean, and bean sprouts.";
                imageName = "banh_xeo";
                break;
            case 5:
                newTitle = "Cơm Tấm";
                newDetail = "Cơm Tấm, also known as broken rice, is a Vietnamese dish made from rice with fractured rice grains. It's usually served with grilled pork (either ribs or shredded) over broken rice. The dish is typically served with a side of pickled vegetables, cucumber slices, and nuoc cham sauce.";
                imageName = "com_tam";
                break;
            default:
                newTitle = "Bún Bò";
                newDetail = "Bún Bò, also known as Vietnamese Beef Noodle Soup, is a popular dish from central Vietnam. It's a hearty soup that features rice vermicelli, beef, and a flavorful broth made with beef bones and spices.";
                imageName = "bun_bo";
                break;
        }
        return new Dish(newTitle, newDetail, imageName);
    }
}
