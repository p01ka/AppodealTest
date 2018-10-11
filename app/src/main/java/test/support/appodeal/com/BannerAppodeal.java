package test.support.appodeal.com;

import com.appodeal.ads.Appodeal;

import java.util.TimerTask;

public class BannerAppodeal extends TimerTask {
    private MainActivity a;

    public BannerAppodeal(MainActivity a) {
        this.a = a;
    }

    @Override
    public void run() {
        a.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Appodeal.setSmartBanners(false);
            }
        });
    }
}
