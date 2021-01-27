package kim.anautomatic.android.slider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {

    private Context context;
    private List<SliderModel> sliderModelList;


    public SliderPagerAdapter(Context context, List<SliderModel> sliderModelList) {
        this.context = context;
        this.sliderModelList = sliderModelList;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout = inflater.inflate(R.layout.slider_items_layout,null);

        ImageView hero_img = sliderLayout.findViewById(R.id.hero_img);
        TextView slider_title = sliderLayout.findViewById(R.id.slider_title);

        hero_img.setImageResource(sliderModelList.get(position).getHero_img());
        slider_title.setText(sliderModelList.get(position).getSlider_Title());
        container.addView(sliderLayout);
        return sliderLayout;
    }

    @Override
    public int getCount() {
        return sliderModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
