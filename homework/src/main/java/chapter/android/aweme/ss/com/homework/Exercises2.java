package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    Button bt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        bt = findViewById(R.id.button);
    }

    public int getAllChildViewCount(View view) {
        int viewCount = 0;
        if(view == null){
            return 0;
        }
        if(view instanceof ViewGroup) {
            viewCount++;
            for(int i = 0;i<((ViewGroup) view).getChildCount();i++) {
                View newView = ((ViewGroup) view).getChildAt(i);
                if(newView instanceof ViewGroup){
                    viewCount+=getAllChildViewCount(newView);
                }
                else{
                    viewCount++;
                }
            }
        }
        return viewCount;
    }

    public void onButtonClicked(View view){
        try {
            bt.setText(getAllChildViewCount(this.getWindow().getDecorView())+" ");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
