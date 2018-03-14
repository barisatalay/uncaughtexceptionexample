package com.atalay.uncaughtexceptionproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.atalay.exceptionlibrary.ExceptionHandler;
import com.atalay.exceptionlibrary.model.BaseException;
import com.atalay.exceptionlibrary.model.ExceptionListener;
import com.atalay.exceptionlibrary.model.ExceptionType;

public class MainActivity extends AppCompatActivity implements ExceptionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                throw new BaseException("Bu çok fena bir hata!", ExceptionType.Warning);
            }
        });

        Thread thread = Thread.currentThread();
        thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
    }

    @Override
    public void onException(final BaseException exception) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                startActivity(DialogActivity.newInstance(getApplicationContext(), exception.getMessage()));
            }
        });
    }
}
