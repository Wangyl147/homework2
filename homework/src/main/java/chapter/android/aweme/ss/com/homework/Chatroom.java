package chapter.android.aweme.ss.com.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Chatroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        TextView sayThings = findViewById(R.id.tv_content_info);
        TextView head = findViewById(R.id.tv_with_name);
        head.setText("消息");
        sayThings.setText("我是第"+getIntent().getIntExtra("Item#",-1)+"个Item");
    }
}
