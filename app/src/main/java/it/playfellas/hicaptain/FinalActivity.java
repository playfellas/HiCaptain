package it.playfellas.hicaptain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import it.playfellas.hicaptain.sounds.Baraldi;

public class FinalActivity extends AppCompatActivity {

    @Bind(R.id.captainImageView)
    ImageButton captainImageView;
    @Bind(R.id.skipSoundButton)
    Button skipSoundButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }

    @OnClick(R.id.captainImageView)
    public void onClick(View v) {
        Baraldi.greet(this, new Runnable() {
            @Override
            public void run() {
                //finished
            }
        });
    }

    @OnClick(R.id.skipSoundButton)
    public void skipSound(View v) {
        Baraldi.shutUp(true);
    }
}
