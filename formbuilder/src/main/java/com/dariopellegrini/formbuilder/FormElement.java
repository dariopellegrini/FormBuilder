package com.dariopellegrini.formbuilder;

import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by dariopellegrini on 19/06/2017.
 */

public class FormElement extends FormObject {

    public enum Type {
        TEXT, TEXTVIEW, EMAIL, PASSWORD, PHONE, NUMBER, URL, SPINNER, ZIP,
        SELECTION, MULTIPLE_SELECTION, DATE, TIME
    }

    private String tag;
    private Type type;
    private String title;
    private String value;
    private String hint;
    private List<String> options; // list of options for single and multi picker
    private List<String> optionsSelected; // list of selected options for single and multi picker
    private boolean isRequired;
    private boolean isEnabled;
    private String dateFormat;
    private String timeFormat;
    private String dateTimeFormat;
    private LinearLayout.LayoutParams params;
    private FormValidation formValidation;
    private String errorMessage;

    public FormElement() {
        isEnabled = true;
        isRequired = false;
        dateFormat = "ddMMyyyy";
        timeFormat = "HH:mm:ss";
        dateTimeFormat = "ddMMyyyy HH:mm:ss";
        options = new ArrayList<String>();
        optionsSelected = new ArrayList<String>();
    }

    public String getTag() {
        return tag;
    }

    public FormElement setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getTagOrToString() {
        return tag == null ? toString() : tag;
    }

    public Type getType() {
        return type;
    }

    public FormElement setType(Type type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FormElement setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getValue() {
        return value;
    }

    public FormElement setValue(String value) {
        this.value = value;
        return this;
    }

    public String getHint() {
        return hint;
    }

    public FormElement setHint(String hint) {
        this.hint = hint;
        return this;
    }

    public List<String> getOptions() {
        return options;
    }

    public FormElement setOptions(List<String> options) {
//        this.options = options;
        this.options = new ArrayList<String>(new HashSet<String>(options)); // Prevent duplicates (distinct)
        return this;
    }

    public List<String> getOptionsSelected() {
        return optionsSelected;
    }

    public FormElement setOptionsSelected(List<String> optionsSelected) {
        this.optionsSelected = optionsSelected;
        return this;
    }

    public boolean getRequired() {
        return isRequired;
    }

    public FormElement setRequired(boolean required) {
        isRequired = required;
        return this;
    }

    public boolean getEnabled() {
        return isEnabled;
    }

    public FormElement setEnabled(boolean enabled) {
        isEnabled = enabled;
        return this;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public FormElement setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public FormElement setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
        return this;
    }

    public String getDateTimeFormat() {
        return dateTimeFormat;
    }

    public FormElement setDateTimeFormat(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
        return this;
    }

    public LinearLayout.LayoutParams getParams() {
        return params;
    }

    public FormElement setParams(LinearLayout.LayoutParams params) {
        this.params = params;
        return this;
    }
    
    public boolean [] getCheckedValues() {
        boolean [] booleans = new boolean[options.size()];
        for (int i = 0; i < options.size(); i++) {
            String element = options.get(i);
            booleans[i] = optionsSelected.contains(element);
        }
        return booleans;
    }

    public int getCheckedValue() {
        if (optionsSelected.size() > 0) {
            String element = optionsSelected.get(0);
            if(options.contains(element)) {
                return options.indexOf(element);
            }
        }
        return 0;
    }

    public FormValidation getFormValidation() {
        return formValidation;
    }

    public FormElement setFormValidation(FormValidation formValidation) {
        this.formValidation = formValidation;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public FormElement setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public String getErrorMessageOrDefault() {
        return errorMessage ==  null ? "Error" : errorMessage;
    }
}
