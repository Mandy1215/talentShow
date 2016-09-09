package com.example.mandy.talentshow;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


import java.util.Calendar;

public class News extends Activity implements View.OnTouchListener ,View.OnClickListener{
    private EditText deadtime;
    private EditText myNews;
    private Button save;
    private String startTime;
    private String endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);

        deadtime = (EditText) findViewById(R.id.deadtime);
        deadtime.setOnTouchListener(this);
        myNews = (EditText) findViewById(R.id.myNews);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(this);
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = View.inflate(this, R.layout.set_time, null);
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


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.save:
              //  addSQLDB();
                break;
        }
    }

  /*  private void addSQLDB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLDB.CONTEXT, myNews.getText().toString());
      //  contentValues.put(SQLDB.START_TIME, getStartTime());
        contentValues.put(SQLDB.END_TIME, getEndTime());
        dbWriter.insert(SQLDB.TABLE_NAME , null , contentValues);
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        endTime = deadtime.getText().toString();
        return endTime;
    }*/
}
