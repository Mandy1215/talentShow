package com.example.mandy.talentshow;

import cn.bmob.v3.BmobObject;

/**
 * Created by Mandy on 2016/9/21.
 */
public class SaveNews extends BmobObject {
    private String deadline;
    private  String content;

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
