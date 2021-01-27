package kim.anautomatic.android.slider;

public class SliderModel {

    private int hero_img;
    private String slider_Title;

    public SliderModel(int hero, String title) {
        this.hero_img = hero;
        this.slider_Title = title;
    }

    public int getHero_img() {
        return hero_img;
    }

    public String getSlider_Title() {
        return slider_Title;
    }

    public void setHero_img(int hero_img) {
        this.hero_img = hero_img;
    }

    public void setSlider_Title(String slider_Title) {
        this.slider_Title = slider_Title;
    }
}
