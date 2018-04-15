package net.alexandroid.utils.daggertest;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    @Provides
    @MyApplicationScope
    TestManager provideTestManager() {
        return new TestManager();
    }

}
