package it.playfellas.hicaptain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    private boolean greetingsEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.greetingsEnabled = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }

    @OnClick(R.id.captainImageView)
    public void onClick(View v) {
        if (greetingsEnabled) {
            Baraldi.greet(this, new Runnable() {
                @Override
                public void run() {
                    greetingsEnabled = true;
                }
            });
        }
        greetingsEnabled = false;
    }

    @OnClick(R.id.skipSoundButton)
    public void skipSound(View v) {
        Baraldi.shutUp(true);
    }
}
