package com.dariopellegrini.formbuilder;

import android.widget.LinearLayout;

/**
 * Created by dariopellegrini on 19/06/2017.
 */

public class FormButton extends FormObject {
    String title;
    Integer backgroundColor;
    Integer textColor;
    Runnable runnable;
    LinearLayout.LayoutParams params;

    public FormButton() {
    }

    public String getTitle() {
        return title;
    }

    public FormButton setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getBackgroundColor() {
        return backgroundColor;
    }

    public FormButton setBackgroundColor(Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Integer getTextColor() {
        return textColor;
    }

    public FormButton setTextColor(Integer textColor) {
        this.textColor = textColor;
        return this;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public FormButton setRunnable(Runnable runnable) {
        this.runnable = runnable;
        return this;
    }

    public LinearLayout.LayoutParams getParams() {
        return params;
    }

    public FormButton setParams(LinearLayout.LayoutParams params) {
        this.params = params;
        return this;
    }
}
