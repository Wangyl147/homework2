package chapter.android.aweme.ss.com.homework.widget;

import android.annotation.SuppressLint;
import android.app.Application;

public class MyApp extends Application {
    private String value;
    @Override
    public void onCreate(){
        super.onCreate();
        setValue("");
    }
    public void setValue(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
