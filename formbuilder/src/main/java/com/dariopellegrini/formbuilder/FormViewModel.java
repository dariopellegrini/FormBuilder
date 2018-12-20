package com.dariopellegrini.formbuilder;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

public class FormViewModel extends ViewModel {
    private ArrayList<FormObject> mForm;
    public void setForm(ArrayList<FormObject> form){
        mForm = form;
    }
    public ArrayList<FormObject> getForm(){
        return mForm;
    }
    public boolean hasForm(){
        return mForm != null;
    }
}
