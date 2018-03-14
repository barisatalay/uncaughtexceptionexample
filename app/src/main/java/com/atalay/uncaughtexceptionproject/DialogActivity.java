package com.atalay.uncaughtexceptionproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by barisatalay on 14.03.2018.
 */

public class DialogActivity extends AppCompatActivity{
    public static Intent newInstance(Context mContext, String message){
        Intent intent = new Intent(mContext, DialogActivity.class);
        intent.putExtra("Message",message);

        return intent;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_dialog);

        if (getIntent().hasExtra("Message"))
            ((TextView)findViewById(R.id.textView)).setText(getIntent().getExtras().getString("Message"));
    }
}
