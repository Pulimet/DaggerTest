package net.alexandroid.utils.daggertest;

import com.squareup.picasso.Picasso;

import dagger.Component;

@MyApplicationScope
@Component(modules = {PicassoModule.class, TestModule.class})
public interface MyApplicationComponent {

    void inject(MainActivity mainActivity);

    Picasso getPicasso();
}
