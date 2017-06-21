# FormBuilder
An Android library to build form and form validations easily.

<img src="https://raw.githubusercontent.com/dariopellegrini/FormBuilder/master/screen1.png" width="348">
<img src="https://raw.githubusercontent.com/dariopellegrini/FormBuilder/master/screen2.png" width="348">
<img src="https://raw.githubusercontent.com/dariopellegrini/FormBuilder/master/screen3.png" width="348">

## Example
COMING SOON

## Requirements
Android 4.3+

## Installation
Add edit your build.gradle file
``` groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
Then add as dependency to yout app/build.gradle
``` groovy
dependencies {
    ...
    compile 'com.github.dariopellegrini:FormBuilder:v0.9'
}
```

## Usage
This library let's you to create forms and add them in a LinearLayout.
If you want to scroll this linear layout remember to add it inside a ScrollView.
Here is an example:

```Java
LinearLayout mLinearLayout;
FormBuilder formBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        formBuilder = new FormBuilder(this, mLinearLayout);
        List<FormObject> formObjects = new ArrayList<FormObject>();
        
        formObjects.add(new FormElement()
            .setTag("text") // Tag is necessary in order to retrieve values
            .setHint("text") // Hint is the placeholder of the generated EditText
            .setType(FormElement.Type.TEXT) // Type of form
            .setEnabled(true) // Enable or not the EditText (default true)
            .setRequired(true) // For validation purpose (default false)
            );
        formObjects.add(new FormElement().setTag("email").setHint("email").setType(FormElement.Type.EMAIL));
        formObjects.add(new FormElement().setTag("phone").setHint("phone").setType(FormElement.Type.PHONE));
        
        formObjects.add(new FormButton()
                .setTitle("Go!")
                .setBackgroundColor(Color.RED)
                .setTextColor(Color.WHITE)
                .setRunnable(new Runnable() {
                    @Override
                    public void run() {
                        boolean isValid = formBuilder.validate();
                        Log.i("Forms", formBuilder.formMap.toString());
                    }
                })
        );

        formBuilder.build(formObjects);
    }
```

## Details
It's possible to add different type of form.

```Java
FormBuilder formBuilder = new FormBuilder(this, mLinearLayout);
List<FormObject> formObjects = new ArrayList<FormObject>();

// Header
formObjects.add(new FormHeader().setTitle("Hello"));

// Simple text
formObjects.add(new FormElement().setTag("text").setHint("text").setType(FormElement.Type.TEXT));

// Simple text withou placeholder animation (for long text for example)
formObjects.add(new FormElement().setTag("view").setHint("view").setType(FormElement.Type.TEXTVIEW));

// E-mail
formObjects.add(new FormElement().setTag("email").setHint("email").setType(FormElement.Type.EMAIL));

// Phone
formObjects.add(new FormElement().setTag("phone").setHint("phone").setType(FormElement.Type.PHONE));

// Number
formObjects.add(new FormElement().setTag("number").setHint("number").setType(FormElement.Type.NUMBER));

// Password
formObjects.add(new FormElement().setTag("password").setHint("password").setType(FormElement.Type.PASSWORD));

// Postal code
formObjects.add(new FormElement().setTag("zip").setHint("zip").setType(FormElement.Type.ZIP));

// Date type: it's possible to set date format (default is "ddMMyyyy")
formObjects.add(new FormElement().setTag("date").setHint("date").setType(FormElement.Type.DATE).setDateFormat("dd-MM-yyyy"));

// Time type: it's possible to set time format (default is "HH:mm:ss")
formObjects.add(new FormElement().setTag("time").setHint("time").setType(FormElement.Type.TIME).setTimeFormat("HH:mm"));

// Single selection
List<String> arrayList = new ArrayList<String>();
        arrayList.add("hello");
        arrayList.add("hi");
        arrayList.add("goodmorning");
formObjects.add(new FormElement().setTag("single").setHint("single").setType(FormElement.Type.SELECTION).setOptions(arrayList));

// Multiple selection
List<String> arrayList2 = new ArrayList<String>();
        arrayList2.add("hello2");
        arrayList2.add("hi2");
        arrayList2.add("goodmorning2");
formObjects.add(new FormElement().setTag("multiple").setHint("multiple").setType(FormElement.Type.MULTIPLE_SELECTION).setOptions(arrayList2));

formBuilder.build(formObjects);

// Button: it's possible to set background color, text color and a runnable that will be executed once the button is pressed.
formObjects.add(new FormButton()
                .setTitle("Go!")
                .setBackgroundColor(Color.RED)
                .setTextColor(Color.WHITE)
                .setParams(layoutParams)
                .setRunnable(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("Forms", formBuilder.formMap.toString());
                    }
                })
        );
```

## Retrieve values
Values inserted are saved inside a map of the object FormBuilder, using tags as key.
```Java
String textValue = formBuilder.formMap.get("text").getValue();
```

## Layout
Every object inside a form has a params attribute which represent LayoutParams of the generated form.
```Java
// This will create a form of type TEXTVIEW with a height of 320.
final FormElement formElement = new FormElement().setTag("view")
      .setHint("view")
      .setType(FormElement.Type.TEXTVIEW)
      .setParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 320));
```

## Validation
To make a validation simply call
```Java
boolean isValid = formBuilder.validate();
```
This will show an error on all forms that has been set as required.

It's possible to change error content on each form element.
```Java
formObjects.add(new FormElement()
      .setTag("text")
      .setHint("text")
      .setType(FormElement.Type.TEXT)
      .setErrorMessage("You can learn from this error"));
```

Every form element can accept a customized code for it's validation.
```Java
final FormElement formElement = new FormElement().setTag("view").setHint("view").setType(FormElement.Type.TEXTVIEW));

        formElement.setFormValidation(new FormValidation() {
                                          @Override
                                          public boolean validate() {
                                              return formElement.getValue().length() > 5;
                                          }
                                      }
        ).setErrorMessage("Too short");

```

## TODO
- Add different types of errors.
- Add SPINNER type.
- Testing.

## Author

Dario Pellegrini, pellegrini.dario.1303@gmail.com
