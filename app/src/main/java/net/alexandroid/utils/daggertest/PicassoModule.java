package net.alexandroid.utils.daggertest;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class PicassoModule {

    @Provides
    public Picasso picasso(Context context, OkHttpClient okHttpClient) {
            return new Picasso.Builder(context)
                    .downloader(new OkHttp3Downloader(okHttpClient))
                    .build();
    }




}
