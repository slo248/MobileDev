package com.example.ex3_22125076;

import com.example.ex3_22125076.content.DishUtils;

public class Application extends android.app.Application {
    public static Options[] choices;
    @Override
    public void onCreate() {
        super.onCreate();
        choices = new Options[DishUtils.DISH_ITEMS.size()];
        for (int i = 0; i < choices.length; i++) {
            choices[i] = Options.NONE;
        }
    }

}
