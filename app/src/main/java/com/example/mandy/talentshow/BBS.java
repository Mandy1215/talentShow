package com.example.mandy.talentshow;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by Mandy on 2016/9/8.
 */
public class BBS extends LinearLayout {
    private ListView listBBS;
    public BBS(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BBS(Context context) {
        super(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
      //  listBBS = (ListView) findViewById(R.id.list_bbs);
    }
}
