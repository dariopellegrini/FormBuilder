package com.dariopellegrini.formbuilder;

/**
 * Created by dariopellegrini on 20/06/2017.
 */

public abstract class FormValidation {
    private boolean result;

    public FormValidation() {
    }

    public abstract boolean validate();

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
