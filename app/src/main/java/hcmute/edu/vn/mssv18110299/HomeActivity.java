package hcmute.edu.vn.mssv18110299;

import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.adapter.ItemAdapter;
import hcmute.edu.vn.mssv18110299.adapter.StoreAdapter;
import hcmute.edu.vn.mssv18110299.data.Category;
import hcmute.edu.vn.mssv18110299.data.Item;
import hcmute.edu.vn.mssv18110299.data.Store;
import hcmute.edu.vn.mssv18110299.data.repository.CategoryRepository;
import hcmute.edu.vn.mssv18110299.data.repository.ItemRepository;
import hcmute.edu.vn.mssv18110299.data.repository.StoreRepository;
import hcmute.edu.vn.mssv18110299.fragment.ViewPagerAdapter;
import hcmute.edu.vn.mssv18110299.utilities.Session;

public class HomeActivity extends AppCompatActivity {

    private CategoryRepository categoryRepository;
    private TabLayout tabLayout;
    private FloatingActionButton floatingActionButton;
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    private Session session;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        session = new Session(this);
        session.checkLogging();
        categoryRepository = new CategoryRepository();
        floatingActionButton = findViewById(R.id.floating_action_button);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        viewPager = findViewById(R.id.home_viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPager.setAdapter(viewPagerAdapter);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menu_home:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.menu_tracking:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.menu_profile:
                    viewPager.setCurrentItem(3);
                    break;
                case R.id.menu_notification:
                    viewPager.setCurrentItem(2);
                    break;
            }
            return true;
        });
        floatingActionButton.setOnClickListener(v-> viewPager.setCurrentItem(4));


    }


}
