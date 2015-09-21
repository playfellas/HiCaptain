package it.playfellas.hicaptain;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import it.playfellas.hicaptain.sounds.Baraldi;

public class MainActivity extends ImmersiveAppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.centralImageView)
    ImageButton centralImageView;
    @Bind(R.id.captainImageView)
    ImageButton captainImageView;
    @Bind(R.id.pruaImageView)
    ImageButton pruaImageView;
    @Bind(R.id.skipSoundButton)
    Button skipSoundButton;

    private boolean captainEnabled = true;
    private boolean pruaEnabled = false;
    private int easterEgg = 0;

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
    public void captainClicked(View v) {
        if (captainEnabled && !pruaEnabled) {
            Log.d(TAG, "Captain clicked");
            this.captainEnabled = false;
            this.startCaptainSound();
        }
        easterEgg--;
    }

    @OnClick(R.id.pruaImageView)
    public void pruaClicked(View v) {
        if (!captainEnabled && pruaEnabled) {
            Log.d(TAG, "Prua clicked");
            this.startPruaSound();
            this.pruaEnabled = false;
        }
        easterEgg++;
    }

    private void startCaptainSound() {
        Baraldi.welcome(this, new Runnable() {
            @Override
            public void run() {
                captainSoundFinished();
            }
        });
    }

    private void captainSoundFinished() {
        pruaEnabled = true;
    }

    private void startPruaSound() {
        Baraldi.askHelp(this, new Runnable() {
            @Override
            public void run() {
                pruaSoundFinished();
            }
        });
    }

    private void pruaSoundFinished() {
        startActivity(new Intent(this, ObloActivity.class));
    }

    @OnClick(R.id.skipSoundButton)
    public void skipSound(View v) {
        Baraldi.shutUp(true);
    }
}
