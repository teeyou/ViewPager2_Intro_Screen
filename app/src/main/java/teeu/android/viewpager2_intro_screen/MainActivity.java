package teeu.android.viewpager2_intro_screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 mViewPager;
    private ViewPagerAdapter mPagerAdapter;
    private List<Item> mList;
    private TabLayout mTabLayout;
    private Button mButton;
    private Button mStartButton;
    private int idx = 0;
    private Animation mBtnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = new ArrayList<>();
        mList.add(new Item("First", R.drawable._sunset));
        mList.add(new Item("Second", R.drawable._snowman_dark));
        mList.add(new Item("Third", R.drawable._end_year));

        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tabLayout);
        mButton = findViewById(R.id.button);
        mStartButton = findViewById(R.id.btn_start);
        mBtnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);

        mPagerAdapter = new ViewPagerAdapter(mList);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == mList.size() - 1) {
                    loadLastPage();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        new TabLayoutMediator(mTabLayout, mViewPager, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("첫번째");
                        break;
                    case 1:
                        tab.setText("두번째");
                        break;
                    case 2:
                        tab.setText("세번째");
                        break;
                }
            }
        }).attach();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(idx < mList.size()) {
                    idx++;
                    mViewPager.setCurrentItem(idx);
                }

                if(idx == mList.size() - 1) {
                    loadLastPage();
                }
            }
        });
    }

    private void loadLastPage() {
        mButton.setVisibility(View.INVISIBLE);
        mStartButton.setVisibility(View.VISIBLE);
        mTabLayout.setVisibility(View.INVISIBLE);
        mStartButton.setAnimation(mBtnAnim);
    }
}