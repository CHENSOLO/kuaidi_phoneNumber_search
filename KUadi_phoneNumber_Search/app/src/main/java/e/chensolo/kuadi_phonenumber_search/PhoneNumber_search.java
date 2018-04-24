package e.chensolo.kuadi_phonenumber_search;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Administrator on 2018/4/21.
 */

public class PhoneNumber_search extends AppCompatActivity implements View.OnClickListener {

    private EditText mNumberEditText;
    private Button mQueryButton;
    private TextView mProvinceTextView;
    private TextView mCatNameTextView;
    private TextView mTelStringTextView;
    private TextView mCarrierTextView;

    private static final int WHAT_SET_PHONE = 1;
    private static final int WHAT_GET_PHONE_FAIL = 2;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT_SET_PHONE:
                    Phone phone = (Phone) msg.obj;
                    mProvinceTextView.setText(phone.getProvince());
                    mCatNameTextView.setText(phone.getCatName());
                    mTelStringTextView.setText(phone.getTelString());
                    mCarrierTextView.setText(phone.getCarrier());
                    break;
                case WHAT_GET_PHONE_FAIL:
                    Toast.makeText(PhoneNumber_search.this, "获取归属地信息失败，请检查网络", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phonenumber_main);

        mNumberEditText = (EditText) findViewById(R.id.et_number);
        mProvinceTextView = (TextView) findViewById(R.id.tv_province);
        mCatNameTextView = (TextView) findViewById(R.id.tv_catName);
        mTelStringTextView = (TextView) findViewById(R.id.tv_telString);
        mCarrierTextView = (TextView) findViewById(R.id.tv_carrier);
        mQueryButton = (Button) findViewById(R.id.btn_query);
        mQueryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String number = mNumberEditText.getText().toString().trim();
        if (number.length() != 11) {
            Toast.makeText(this, "号码输入错误", Toast.LENGTH_SHORT).show();
            return;
        }
        new Thread(new GetPhoneThread(number)).start();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    class GetPhoneThread implements Runnable {
        private String mNumber;

        public GetPhoneThread(String number) {
            mNumber = number;
        }

        @Override
        public void run() {
            try {
                Phone phone = NumberAttributionQuerier.getPhone(mNumber);
                Message message = Message.obtain(mHandler, WHAT_SET_PHONE);
                message.obj = phone;
                message.sendToTarget();
            } catch (IOException e) {
                e.printStackTrace();
                Message message = Message.obtain(mHandler, WHAT_GET_PHONE_FAIL);
                message.sendToTarget();
            }
        }
    }
}

