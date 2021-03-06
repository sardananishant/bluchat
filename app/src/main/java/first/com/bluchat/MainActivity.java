package first.com.bluchat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DBHandler db = new DBHandler(getApplicationContext());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 2000);
    }
}

