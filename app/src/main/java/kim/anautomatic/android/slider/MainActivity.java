package kim.anautomatic.android.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private List<The_Slide_Items_Model_Class> listItems;
    private ViewPager page;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = findViewById(R.id.my_pager) ;
        tabLayout = findViewById(R.id.my_tablayout);

        // Make a copy of the slides you'll be presenting.
        listItems = new ArrayList<>() ;
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.item1,"Slider 1 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.item2,"Slider 2 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.item3,"Slider 3 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.item4,"Slider 4 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.item5,"Slider 5 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.item6,"Slider 6 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.item7,"Slider 7 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.item8,"Slider 8 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.item9,"Slider 9 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.item10,"Slider 10 Title"));

        The_Slide_items_Pager_Adapter itemsPager_adapter = new The_Slide_items_Pager_Adapter(this, listItems);
        page.setAdapter(itemsPager_adapter);

        // The_slide_timer
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(),2000,3000);
        tabLayout.setupWithViewPager(page,true);
    }

    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (page.getCurrentItem()< listItems.size()-1) {
                        page.setCurrentItem(page.getCurrentItem()+1);
                    }
                    else
                        page.setCurrentItem(0);
                }
            });
        }
    }
}
