package com.example.android.feino.util;

public class AppDataHolder {

    private static AppDataHolder instance;

    private AppDataHolder(){

    }
    public static AppDataHolder getInstance(){
        if(instance == null ){
            instance = new AppDataHolder();
        }
        return instance;
    }



}
