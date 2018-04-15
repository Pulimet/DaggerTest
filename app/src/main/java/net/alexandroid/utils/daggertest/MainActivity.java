package net.alexandroid.utils.daggertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    TestManager mTestManager;

    @Inject
    Picasso mPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication.getMyApplication().getComponent().inject(this);

        ImageView imageView = findViewById(R.id.imageView);
        mPicasso.load(R.mipmap.ic_launcher).into(imageView);

        Toast.makeText(this, mTestManager.getFakeString(), Toast.LENGTH_SHORT).show();
    }
}
