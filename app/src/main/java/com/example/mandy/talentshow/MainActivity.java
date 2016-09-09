package com.example.mandy.talentshow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_tab);

        //获得tabHost对象并初始化setup（）；
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        /**
         * tabHost.newTabSpec()  增加tab一页
         *  spec.setContent()    增加内容
         *  spec.setIndicator()  增加标签
         */
        TabHost.TabSpec spec = tabHost.newTabSpec("bbs");
        spec.setContent(R.id.bbs);
        spec.setIndicator("论坛");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("friends");
        spec.setContent(R.id.friends);
        spec.setIndicator("通讯录");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("chat");
        spec.setContent(R.id.chat);
        spec.setIndicator("聊天");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("mine");
        spec.setContent(R.id.mine);
        spec.setIndicator("人才");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.news:
                Intent intent = new Intent(MainActivity.this, News.class);
                startActivity(intent);
                break;
            case R.id.aboutUs:
                getAboutUs();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getAboutUs() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("关于我们");
        builder.setMessage("你可以在这里发现不同的人才！");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
