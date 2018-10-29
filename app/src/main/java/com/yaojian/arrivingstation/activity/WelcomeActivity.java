package com.yaojian.arrivingstation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.yaojian.arrivingstation.main.R;
import com.yaojian.arrivingstation.utils.ActionUtils;

public class WelcomeActivity extends Activity {
    private static final int GOTO_GUIDE_PATH_CODE = 0x10001;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case GOTO_GUIDE_PATH_CODE:
                    Intent intent = new Intent(ActionUtils.GUIDE_MAIN_ACTION);
                    startActivity(intent);
                    finish();
                    break;
                default:
                    break;
            }
            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mHandler.sendEmptyMessageDelayed(GOTO_GUIDE_PATH_CODE,2000);
    }
}
