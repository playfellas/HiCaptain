package it.playfellas.hicaptain;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends ImmersiveAppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.centralImageView)
    ImageButton centralImageView;
    @Bind(R.id.captainImageView)
    ImageButton captainImageView;
    @Bind(R.id.pruaImageView)
    ImageButton pruaImageView;

    private boolean captainEnabled = true;
    private boolean pruaEnabled = false;

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
        if(captainEnabled && !pruaEnabled) {
            Log.d(TAG, "Captain clicked");
        }

        captainEnabled = false;
        pruaEnabled = true;
    }

    @OnClick(R.id.pruaImageView)
    public void pruaClicked(View v) {
        if(!captainEnabled && pruaEnabled) {
            Log.d(TAG, "Prua clicked");
        }

        captainEnabled = false;
        pruaEnabled = false;
    }
}
