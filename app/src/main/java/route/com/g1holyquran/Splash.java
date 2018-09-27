package route.com.g1holyquran;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import route.com.g1holyquran.Base.MyBaseActivity;

public class Splash extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(activity,HomeActivity.class));
            }
        },2000);


    }


}
