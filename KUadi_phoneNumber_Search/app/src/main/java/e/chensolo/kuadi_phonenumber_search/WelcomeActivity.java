package e.chensolo.kuadi_phonenumber_search;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/4/21.
 */

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
                return false;
            }
        }).sendEmptyMessageDelayed(0,2000);
    }
}


