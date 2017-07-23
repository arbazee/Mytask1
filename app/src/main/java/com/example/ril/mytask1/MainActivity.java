package com.example.ril.mytask1;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ril.mytask1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
private Toolbar toolbar;
private TabLayout tabLayout;
private ViewPager viewPager,viewPager1;
private int[] tabIcons = {
        R.mipmap.select_video,
        R.mipmap.select_image,
        R.mipmap.select_milestone
        };


    private LinearLayout ll_dots;
    SliderPagerAdapter sliderPagerAdapter;
    ArrayList<Integer> slider_image_list;
    private TextView[] dots;
    int page_position = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        ll_dots = (LinearLayout) findViewById(R.id.ll_dots);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



        setupTabIcons();

        init();

    addBottomDots(0);

    final Handler handler = new Handler();

    final Runnable update = new Runnable() {
        public void run() {
            if (page_position == slider_image_list.size()) {
                page_position = 0;
            } else {
                page_position = page_position + 1;
            }
            viewPager1.setCurrentItem(page_position, true);
        }
    };

    new Timer().schedule(new TimerTask() {

        @Override
        public void run() {
            handler.post(update);
        }
    }, 500, 3000);




}

    private void addBottomDots(int page_position) {


        dots = new TextView[slider_image_list.size()];
        ll_dots.removeAllViews();;

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#FF5722"));
            ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[page_position].setTextColor(Color.parseColor("#FFFFFF"));


    }

    private void init() {

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));


        viewPager1 = (ViewPager) findViewById(R.id.slider);
        setupViewPager(viewPager1);


        slider_image_list = new ArrayList<>();

        slider_image_list.add(R.drawable.slide1);
        slider_image_list.add(R.drawable.slide2);
        slider_image_list.add(R.drawable.slide3);
        slider_image_list.add(R.drawable.slide4);


        sliderPagerAdapter = new SliderPagerAdapter(MainActivity.this, slider_image_list);
        viewPager1.setAdapter(sliderPagerAdapter);

        viewPager1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("VIDEOS");
        tabOne.setTextColor(getResources().getColor(R.color.orangeColor));
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.select_video, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("IMAGES");
        tabTwo.setTextColor(getResources().getColor(R.color.orangeColor));
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.select_image, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("MILESTONES");
        tabThree.setTextColor(getResources().getColor(R.color.orangeColor));
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.select_milestone, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        }

private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "ONE");
        adapter.addFrag(new TwoFragment(), "TWO");
        adapter.addFrag(new ThreeFragment(), "THREE");
        viewPager.setAdapter(adapter);
        }

class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFrag(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
}