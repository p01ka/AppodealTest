package test.support.appodeal.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.InterstitialCallbacks;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    Timer timer = new Timer();
    public Button button;
    public TextView textTime;
    public boolean buttonOnClick = false;
    public ShowTImeTask showTImeTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String appKey = "fee50c333ff3825fd6ad6d38cff78154de3025546d47a84f";
        Appodeal.disableLocationPermissionCheck();
        Appodeal.initialize(this, appKey, Appodeal.INTERSTITIAL | Appodeal.REWARDED_VIDEO | Appodeal.BANNER | Appodeal.NATIVE | Appodeal.MREC);
        Appodeal.setInterstitialCallbacks(new InterstitialCallbacks() {
            @Override
            public void onInterstitialLoaded(boolean b) {

            }

            @Override
            public void onInterstitialFailedToLoad() {

            }

            @Override
            public void onInterstitialShown() {
                timer.cancel();
            }

            @Override
            public void onInterstitialClicked() {

            }

            @Override
            public void onInterstitialClosed() {
                timer = new Timer();
                StartAdsTimer();
            }
        });
        View.OnClickListener onClickListener =
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonOnClick = true;
                        timer.cancel();
                    }
                };


        Appodeal.show(this, Appodeal.BANNER_TOP);

        button = findViewById(R.id.button);
        button.setOnClickListener(onClickListener);
        textTime = findViewById(R.id.textTime);
        StartAdsTimer();

    }

    public void StartAdsTimer() {
        showTImeTask = new ShowTImeTask(this);
        timer.schedule(showTImeTask, 0, 1000);
    }
}
