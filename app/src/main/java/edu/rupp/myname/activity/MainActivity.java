package edu.rupp.myname.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import edu.rupp.myname.Fragment.ContactFragment;
import edu.rupp.myname.Fragment.CourseFragment;
import edu.rupp.myname.Fragment.FeedBackFragment;
import edu.rupp.myname.Fragment.ProfileFragment;
import edu.rupp.myname.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tlb = (Toolbar) findViewById(R.id.tlb_main);
        setSupportActionBar(tlb);
        getSupportActionBar().setTitle(R.string.app_name);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_lyt);
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,tlb,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    private void onNewsClick()
    {
        /*
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        NewsFragment newsFragment=new NewsFragment();
        fragmentTransaction.replace(R.id.lyt_content, newsFragment);
        fragmentTransaction.commit();*/
        Intent intent=new Intent(this,NewsActivity.class);
        startActivity(intent);

    }

    private void onCourseClick()
    {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        CourseFragment courseFragment=new CourseFragment();
        fragmentTransaction.replace(R.id.lyt_content, courseFragment);
        fragmentTransaction.commit();
    }
    private void onProfileClick()
    {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        ProfileFragment profileFragment=new ProfileFragment();
        fragmentTransaction.replace(R.id.lyt_content, profileFragment);
        fragmentTransaction.commit();
    }
    private void onFeedbackClick()
    {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        FeedBackFragment feedBackFragment=new FeedBackFragment();
        fragmentTransaction.replace(R.id.lyt_content, feedBackFragment);
        fragmentTransaction.commit();
    }
    private void onContactClick()
    {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        ContactFragment contactFragment=new ContactFragment();
        fragmentTransaction.replace(R.id.lyt_content, contactFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();
        switch (item.getItemId())
        {
            case R.id.mnu_news:
                onNewsClick();
                break;
            case R.id.mnuu_course:
                onCourseClick();
                break;
            case R.id.mnu_profile:
                onProfileClick();
                break;
            case R.id.mnu_feedback:
                onFeedbackClick();
                break;
            case R.id.mnu_contact:
                onContactClick();
                break;
        }
        return false;
    }
}

