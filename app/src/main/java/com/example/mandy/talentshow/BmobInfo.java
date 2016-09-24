package com.example.mandy.talentshow;

/**
 * Created by Mandy on 2016/9/21.
 */
public class BmobInfo {
    public static String appID = "ace3893742349b48e647a268061d907c";

    private static BmobInfo ourInstance = new BmobInfo();

    public static BmobInfo getInstance() {
        return ourInstance;
    }

    private BmobInfo() {
    }

}

