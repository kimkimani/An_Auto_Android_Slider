package kim.anautomatic.android.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private List<SliderModel> sliderList;
    private ViewPager sliderViewPager;
    private TabLayout tabLayoutIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderViewPager = findViewById(R.id.slider_pager) ;
        tabLayoutIndicator = findViewById(R.id.slider_tablayout_indicator);

        // prepare a list of slides
        sliderList = new ArrayList<>() ;
        sliderList.add(new SliderModel(R.drawable.slider1,"Slider 1 Title"));
        sliderList.add(new SliderModel(R.drawable.slider2,"Slider 2 Title"));
        sliderList.add(new SliderModel(R.drawable.slider3,"Slider 3 Title"));
        sliderList.add(new SliderModel(R.drawable.slider4,"Slider 4 Title"));
        sliderList.add(new SliderModel(R.drawable.slider5,"Slider 5 Title"));
        sliderList.add(new SliderModel(R.drawable.slider6,"Slider 6 Title"));
        sliderList.add(new SliderModel(R.drawable.slider7,"Slider 7 Title"));
        sliderList.add(new SliderModel(R.drawable.slider8,"Slider 8 Title"));
        sliderList.add(new SliderModel(R.drawable.slider9,"Slider 9 Title"));
        sliderList.add(new SliderModel(R.drawable.slider10,"Slider 10 Title"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this, sliderList);
        sliderViewPager.setAdapter(adapter);

        // setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(),2000,3000);
        tabLayoutIndicator.setupWithViewPager(sliderViewPager,true);
    }

    public class SliderTimer extends TimerTask {
        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderViewPager.getCurrentItem()< sliderList.size()-1) {
                        sliderViewPager.setCurrentItem(sliderViewPager.getCurrentItem()+1);
                    }
                    else
                        sliderViewPager.setCurrentItem(0);
                }
            });

        }
    }
}
