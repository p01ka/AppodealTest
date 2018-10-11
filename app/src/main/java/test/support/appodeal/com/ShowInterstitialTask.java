package test.support.appodeal.com;

import com.appodeal.ads.Appodeal;

import java.util.TimerTask;

public class ShowInterstitialTask extends TimerTask {
    // вывод рекламы
    private MainActivity a;

    public ShowInterstitialTask(MainActivity a) {
        this.a = a;
    }

    @Override
    public void run() {
        if (!a.buttonOnClick) {
            a.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Appodeal.show(a, Appodeal.INTERSTITIAL);
                }
            });
        }
    }
}
