package test.support.appodeal.com;

import android.annotation.SuppressLint;

import com.appodeal.ads.Appodeal;

import java.util.TimerTask;

public class ShowTImeTask extends TimerTask {
    //вывод таймера
    private MainActivity a;
    private ShowInterstitialTask task;
    private int countSeconds = 30;

    public ShowTImeTask(MainActivity a) {
        this.a = a;
    }

    @Override
    public void run() {
        a.runOnUiThread(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                a.textTime.setText("реклама начнется через: " + countSeconds);
                countSeconds--;
                if (countSeconds == 0) {
                    a.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Appodeal.show(a, Appodeal.INTERSTITIAL);
                        }
                    });
                    countSeconds = 30;
                }
            }
        });
    }
}
