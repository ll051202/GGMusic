package gl.com.ggmusic.activity;


import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import gl.com.ggmusic.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private android.widget.TextView textView;

    public MainActivity() {
        setContentView(R.layout.activity_main);
    }

    @Override
    void init() {
        toolbar.setVisibility(View.GONE);


        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    void initView() {

    }

    @Override
    void setListener() {
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                startActivity(new Intent(MainActivity.this,SettingActivity.class));
            break;

            default:
                break;
        }
    }
}
