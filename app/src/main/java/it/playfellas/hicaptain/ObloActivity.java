package it.playfellas.hicaptain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObloActivity extends ImmersiveAppCompatActivity {

    @Bind(R.id.chefButton)
    ImageButton chefButton;

    @Bind(R.id.incastri1Button)
    ImageButton incastri1Button;

    @Bind(R.id.incastri2Button)
    ImageButton incastri2Button;

    @Bind(R.id.intruso1Button)
    ImageButton intruso1Button;

    @Bind(R.id.intruso2Button)
    ImageButton intruso2Button;

    @Bind(R.id.superappButton)
    ImageButton superappButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oblo);

        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.chefButton, R.id.incastri1Button, R.id.incastri2Button, R.id.intruso1Button, R.id.intruso2Button, R.id.superappButton})
    public void onClick(View v) {
        startActivity(new Intent(this, FinalActivity.class));
    }
}
