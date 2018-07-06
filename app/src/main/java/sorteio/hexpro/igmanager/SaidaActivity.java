package sorteio.hexpro.igmanager;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class SaidaActivity extends Activity {
    private AdView mAdview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saida);

       // MobileAds.initialize (this , "ca-app-pub-9634143315631553~7432610619" );
        mAdview =  findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("ca-app-pub-3940256099942544/6300978111").build();
        mAdview.loadAd(adRequest);
    }


}
