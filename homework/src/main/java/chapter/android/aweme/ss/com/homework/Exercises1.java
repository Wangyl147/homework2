package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import chapter.android.aweme.ss.com.homework.widget.MyApp;

/**
 * 作业1：
 * Logcat在屏幕旋转的时候 #onStop() #onDestroy()会展示出来
 * 但我们的 mLifecycleDisplay 由于生命周期的原因(Tips:执行#onStop()之后，UI界面我们是看不到的)并没有展示
 * 在原有@see Exercises1 基础上如何补全它，让其跟logcat的展示一样?
 * <p>
 * Tips：思考用比Activity的生命周期要长的来存储？  （比如：application、static变量）
 */

public class Exercises1 extends AppCompatActivity {

    private static final String TAG = "wangyuanlong";

    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";


    private TextView mLifecycleDisplay;

    private MyApp app;
    private String Buffer;
    private void logAndAppend(String lifecycleEvent) {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);
        mLifecycleDisplay.append(lifecycleEvent + "\n");
    }

    private void log(String lifecycleEvent){
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);
    }

    private void append(String lifecycleEvent){
        mLifecycleDisplay.append(lifecycleEvent + "\n");
    }

    public void resetLifecycleDisplay(View view) {
        mLifecycleDisplay.setText("Lifecycle callbacks:\n");
    }

    public void showSaveInstance(View view) {
//        startActivity(new Intent(this, SaveInstanceStateActivity.class));
   }

    public void showUpgradeDialog(View view) {
//        new AlertDialog.Builder(this)
//                .setTitle("应用升级")
//                .setMessage("抖音1.1版本升级")
//                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                })
//                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                }).create().show();
        //startActivity(new Intent(this, DialogActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        mLifecycleDisplay = findViewById(R.id.tv_loglifecycle);
        app = (MyApp)getApplication();
        append(app.getValue());
        Buffer="";
        logAndAppend(ON_CREATE);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndAppend(ON_RESTART);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logAndAppend(ON_START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        logAndAppend(ON_RESUME);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Buffer+=ON_PAUSE+'\n';
        log(ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Buffer+=ON_STOP+'\n';
        log(ON_STOP);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Buffer+=ON_DESTROY;
        app.setValue(Buffer);
        log(ON_DESTROY);
    }

}
