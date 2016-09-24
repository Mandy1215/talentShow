package com.example.mandy.talentshow;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Calendar;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class News extends Activity implements View.OnTouchListener {
    private EditText deadtime;
    private EditText myNews;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        deadtime = (EditText) findViewById(R.id.deadtime);
        deadtime.setOnTouchListener(this);
        myNews = (EditText) findViewById(R.id.myNews);
        save = (Button) findViewById(R.id.save);

 /*       //默认初始化
        Bmob.initialize(this, BmobInfo.appID);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dead_time = deadtime.getText().toString();
                String my_new = myNews.getText().toString();
                SaveNews saveNews = new SaveNews();
                saveNews.setDeadline(dead_time);
                saveNews.setContent(my_new);
                saveNews.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (e == null) {
                            Toast.makeText(News.this, "no ", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(News.this, "ok ", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
*/
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            AlertDialog.Builder builder = new AlertDialog.Builder(News.this);
            View view = View.inflate(News.this, R.layout.set_time, null);
            final DatePicker datePicker = (DatePicker) view.findViewById(R.id.datePicket);
            builder.setView(view);

            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(System.currentTimeMillis());
            datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH), null);
            if (v.getId() == R.id.deadtime) {
                final int inType = deadtime.getInputType();
                deadtime.setInputType(InputType.TYPE_NULL);
                deadtime.onTouchEvent(event);
                deadtime.setInputType(inType);
                deadtime.setSelection(deadtime.getText().length());

                builder.setTitle("选取起始时间");
                builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        sb.append("  ");
                        deadtime.setText(sb);
                        dialog.cancel();
                    }
                });
            }
            Dialog dialog = builder.create();
            dialog.show();
        }
        return true;
    }





}