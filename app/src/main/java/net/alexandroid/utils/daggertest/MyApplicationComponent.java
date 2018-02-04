package net.alexandroid.utils.daggertest;

import com.squareup.picasso.Picasso;

import dagger.Component;

@Component(modules = PicassoModule.class)
public interface MyApplicationComponent {
    Picasso getPicasso();
}
