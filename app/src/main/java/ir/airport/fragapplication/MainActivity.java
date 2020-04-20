package ir.airport.fragapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.google.android.material.tabs.TabLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class MainActivity extends AppCompatActivity {
    private int[] tabIcons = {
            R.drawable.home,
            R.drawable.contact,
            R.drawable.live,
            R.drawable.chat,
            R.drawable.phone,
            R.drawable.camera
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager=findViewById(R.id.pager);
        TabLayout smartTab = (TabLayout) findViewById(R.id.smartab);

        //TabLayout tab=findViewById(R.id.tab);
        ViewpagerAdapter adapter=
                new ViewpagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pager.setAdapter(adapter);
        //tab.setupWithViewPager(pager);
        smartTab.setupWithViewPager(pager);

        smartTab.getTabAt(0).setIcon(tabIcons[0]);
        smartTab.getTabAt(1).setIcon(tabIcons[1]);
        smartTab.getTabAt(2).setIcon(tabIcons[2]);
        smartTab.getTabAt(3).setIcon(tabIcons[3]);
        smartTab.getTabAt(4).setIcon(tabIcons[4]);
        smartTab.getTabAt(5).setIcon(tabIcons[5]);
        smartTab.setSelectedTabIndicatorColor(Color.parseColor("#F44336"));
        ViewGroup vg = (ViewGroup) smartTab.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int i = 0; i < tabsCount; i++)
        {
            int delay = (i * 200) + 900; //this is starting delay
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(i);
            vgTab.setScaleX(0f);
            vgTab.setScaleY(0f);

            vgTab.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setStartDelay(delay)
                    .setInterpolator(new FastOutSlowInInterpolator())
                    .setDuration(700)
                    .start();
        }
        pager.setPageTransformer(true, new RotateUpTransformer());
        View root = smartTab.getChildAt(0);
        if (root instanceof LinearLayout) {
            ((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(getResources().getColor(R.color.accent));
            drawable.setSize(2, 0);
            ((LinearLayout) root).setDividerPadding(20);
            ((LinearLayout) root).setDividerDrawable(drawable);
        }





    }

}
