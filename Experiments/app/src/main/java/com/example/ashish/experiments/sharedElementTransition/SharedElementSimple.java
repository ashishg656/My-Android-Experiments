package com.example.ashish.experiments.sharedElementTransition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.ashish.experiments.R;

/**
 * Created by Ashish on 30/04/16.
 */
public class SharedElementSimple extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_simple);

        findViewById(R.id.image1).setOnClickListener(this);
    }

    void openNextActivity() {
        Intent intent = new Intent(this, SharedElementSimpleSecond.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation(this, findViewById(R.id.image1), "image1");
            startActivity(intent, options.toBundle());

        } else {
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        openNextActivity();
    }
}
