package net.alexandroid.utils.daggertest;

import android.app.Application;

import net.alexandroid.utils.mylog.MyLog;

public class MyApplication extends Application {

    private static MyApplication sMyApplication;
    private MyApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApplication = this;
        MyLog.init(this);
        MyLog.setTag("ZAQ");

        mComponent = DaggerMyApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .testModule(new TestModule())
                .build();
        //Picasso picasso = mComponent.getPicasso();
    }

    public static MyApplication getMyApplication() {
        return sMyApplication;
    }

    public MyApplicationComponent getComponent() {
        return mComponent;
    }
}
