package com.atalay.exceptionlibrary;

import com.atalay.exceptionlibrary.model.BaseException;
import com.atalay.exceptionlibrary.model.ExceptionListener;
import com.atalay.exceptionlibrary.model.ExceptionType;

/**
 * Created by barisatalay on 14.03.2018.
 */

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    private final ExceptionListener listener;

    public ExceptionHandler(ExceptionListener listener) {
        this.listener = listener;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (listener != null) {
            BaseException newException;
            if (throwable instanceof BaseException)
                newException = (BaseException) throwable;
            else{
                newException = new BaseException("Tanımsız hata vs. vs.", ExceptionType.Error);
            }
            listener.onException(newException);

            //TODO: Amacım burada uygulamayı kapatmaktan ziyade kendi custom errorlarımı dialog olarak göstermek.
            //TODO: Çünkü custom errorlarım uygulama içerisinde örneğin bir yer boş kaldıgında verdiydiğim hatalardır.

            //TODO: Sanırım yapmak istediğim şey ile bu yapının kullanım amacı uyuşmuyor

            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } else {
        }
    }
}
