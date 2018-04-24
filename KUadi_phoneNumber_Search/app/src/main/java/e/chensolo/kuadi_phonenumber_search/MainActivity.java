package e.chensolo.kuadi_phonenumber_search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button phoneNumber_search;
private Button kuaidi_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber_search=findViewById(R.id.phoneNumber_search);
        kuaidi_search=findViewById(R.id.kuaidi_search);

        phoneNumber_search.setOnClickListener(this);
        kuaidi_search.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.phoneNumber_search:{
                Intent i = new Intent(this,PhoneNumber_search.class);
                startActivity(i);
                break;
            }
            case R.id.kuaidi_search:{
                Intent r = new Intent(this,KuaiDi_search.class);
                startActivity(r);
                break;
            }
        }
    }
}
