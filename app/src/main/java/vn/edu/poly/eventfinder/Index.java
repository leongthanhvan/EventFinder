package vn.edu.poly.eventfinder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.github.aakira.expandablelayout.Utils;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.eventfinder.functionmenu.CapnhatThongtin;
import vn.edu.poly.eventfinder.functionmenu.Sukiendathamgia;

import static vn.edu.poly.eventfinder.R.id.drawer;

public class Index extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    FloatingActionButton fab;
    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, Index.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        // Adding Toolbar to Main screen
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Setting ViewPager for each Tabs
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(drawer);
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        //RecycialView
        getSupportActionBar().setTitle(Index.class.getSimpleName());

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final List<ItemModel> data = new ArrayList<>();
        data.add(new ItemModel(
                "Nguyễn A",
                "0123456789",
                R.mipmap.ic_launcher,
                R.color.white,
                R.color.gray_light,
                Utils.createInterpolator(Utils.DECELERATE_INTERPOLATOR)));
        recyclerView.setAdapter(new RecyclerViewRecyclerAdapter(data));

        // Adding menu icon to Toolbar
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        // Set behavior of Navigation drawer
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);

                        if (menuItem.getItemId() == R.id.dsSukien) {
                            Intent i  = new Intent(Index.this,Index.class);
                            startActivity(i);
                            fab.setVisibility(View.VISIBLE);
                        }
                        if (menuItem.getItemId() == R.id.SuienTG) {
                            fab.setVisibility(View.GONE);
                            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.containerView,new Sukiendathamgia()).commit();

                        }
                        if (menuItem.getItemId() == R.id.Capnhat) {
                            fab.setVisibility(View.GONE);
                            FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                            xfragmentTransaction.replace(R.id.containerView,new CapnhatThongtin()).commit();
                        }
                        mDrawerLayout.closeDrawers();

                        return true;

                    }
                });
        // Adding Floating Action Button to bottom right of main view
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Hello Snackbar!",
                        Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.toolbar) {
            return true;
        } else if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }


}
