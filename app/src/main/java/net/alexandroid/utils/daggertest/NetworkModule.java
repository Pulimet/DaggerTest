package net.alexandroid.utils.daggertest;

import android.content.Context;

import net.alexandroid.utils.mylog.MyLog;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @MyApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @MyApplicationScope
    Cache cache(File cacheFile) {
        cacheFile.mkdirs();
        return new Cache(cacheFile, 10 * 1024 * 1024); // 10 MB)
    }

    @Provides
    @MyApplicationScope
    File cacheFile(Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @MyApplicationScope
    HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                MyLog.d(message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return loggingInterceptor;
    }
}
