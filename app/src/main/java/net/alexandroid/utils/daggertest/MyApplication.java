package net.alexandroid.utils.daggertest;

import android.app.Application;

import com.squareup.picasso.Picasso;

import net.alexandroid.utils.mylog.MyLog;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MyLog.init(this);
        MyLog.setTag("ZAQ");

        MyApplicationComponent component = DaggerMyApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        Picasso picasso = component.getPicasso();
    }
}
