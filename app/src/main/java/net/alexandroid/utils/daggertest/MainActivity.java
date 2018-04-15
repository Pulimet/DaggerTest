package net.alexandroid.utils.daggertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    TestManager mTestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication.getMyApplication().getComponent().injectTestModule(this);
        Toast.makeText(this, mTestManager.getFakeString(), Toast.LENGTH_SHORT).show();
    }
}
