package marketplace.jpr.com.barncopharmeasydemoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActionBar toolbar;
    private ImageView cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cart=findViewById(R.id.cart);

        toolbar = getSupportActionBar();

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //toolbar.setTitle("Shop");
        loadFragment(new HomeFragment());

        

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //toolbar.setTitle("Shop");

                    fragment = new HomeFragment();
                    loadFragment(fragment);

                    return true;
                case R.id.navigation_reminders:
                   // toolbar.setTitle("My Gifts");

                    fragment = new RemindersFragment();
                    loadFragment(fragment);

                    return true;
                case R.id.navigation_articals:
                    //toolbar.setTitle("Cart");

                    fragment = new ArticalsFragment();
                    loadFragment(fragment);

                    return true;
                case R.id.navigation_notifications:
                   // toolbar.setTitle("Profile");

                    fragment = new NotificationsFragment();
                    loadFragment(fragment);

                    return true;

                case R.id.navigation_account:
                    // toolbar.setTitle("Profile");

                   /* fragment = new AccountFragment();
                    loadFragment(fragment);*/

                   Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                   startActivity(intent);

                    return true;
            }
            return false;
        }
    };


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
