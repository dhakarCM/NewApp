package com.phppoets.newapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.phppoets.newapp.Adapter.AdvertiseAdapter;
import com.phppoets.newapp.Adapter.EventHomeAdapter;
import com.phppoets.newapp.Adapter.HomeMenuAdapter;
import com.phppoets.newapp.Adapter.InitiativeAdapter;
import com.phppoets.newapp.Adapter.ViewPagerAdapter;
import com.phppoets.newapp.Model.event.Eventlist;
import com.phppoets.newapp.Model.newHome.NewHomeResponse;
import com.phppoets.newapp.Model.newHome.Slider;
import com.phppoets.newapp.R;
import com.phppoets.newapp.rest.RestClient;
import com.phppoets.newapp.support.AppConfig;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences sharedPreferences;
    private ViewPager viewPager, vPagerEventHome;
    ViewPagerAdapter viewPagerAdapter;
    HomeMenuAdapter homeMenuAdapter;
    AdvertiseAdapter advertiseAdapter;
    EventHomeAdapter eventHomeAdapter;
    InitiativeAdapter initiativeAdapter;
    RecyclerView recyclerViewMenus, recycleViewIni, recycleViewAdvertise, recycleEventHome;
    ArrayList<Slider> arrayList;
    List<Eventlist> eventlists;
    int anInt = 4;
    private TextView[] dots;
    int page_position = 0;
    int event_position = 0;
    NewHomeResponse homeResponse;
    TextView seeMore;
    ImageView imageView;
    TextView txtName;

    NavigationActivity navigationActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);
        recyclerViewMenus = (RecyclerView) findViewById(R.id.recycleViewMenus);
        recycleViewIni = (RecyclerView) findViewById(R.id.recycleViewIni);
        recycleViewAdvertise = (RecyclerView) findViewById(R.id.recycleAdvertise);
//        recycleEventHome= (RecyclerView) findViewById(R.id.recycleEventHome);
        seeMore = (TextView) findViewById(R.id.txtSeeMore);
        imageView= (ImageView) findViewById(R.id.imgProfile);
        txtName= (TextView) findViewById(R.id.txtname1);

        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NavigationActivity.this,EventActivity.class));
            }
        });

        sharedPreferences = getSharedPreferences(AppConfig.KEY_PREFS_NAME, MODE_PRIVATE);
        String link=sharedPreferences.getString(AppConfig.KEY_IMG_LINK,"link");

        txtName.setText(sharedPreferences.getString(AppConfig.KEY_NAME,"name"));

        Picasso.with(this).load(link).into(imageView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NavigationActivity.this, MainActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(NavigationActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewMenus.setLayoutManager(mLayoutManager);
        recyclerViewMenus.setItemAnimator(new DefaultItemAnimator());

        RecyclerView.LayoutManager iLayoutManager = new LinearLayoutManager(NavigationActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recycleViewIni.setLayoutManager(iLayoutManager);
        recycleViewIni.setItemAnimator(new DefaultItemAnimator());

        RecyclerView.LayoutManager nLayoutManager = new LinearLayoutManager(NavigationActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recycleViewAdvertise.setLayoutManager(nLayoutManager);
        recycleViewAdvertise.setItemAnimator(new DefaultItemAnimator());


//        RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(NavigationActivity.this, LinearLayoutManager.HORIZONTAL, false);
//        recycleEventHome.setLayoutManager(eLayoutManager);
//        recycleEventHome.setItemAnimator(new DefaultItemAnimator());

//         method for initialisation
        init();

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == arrayList.size()) {
                    page_position = 0;
                } else {
                    page_position = page_position++;
                }
                viewPager.setCurrentItem(page_position, true);
            }
        };

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (event_position == eventlists.size()) {
                    event_position = 0;
                } else {
                    event_position = event_position++;
                }
                vPagerEventHome.setCurrentItem(event_position, true);
            }
        };

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 5000);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, MainActivity.class));

        } else if (id == R.id.logout) {
            sharedPreferences.edit().clear().apply();
            disconnectFromFacebook();
            startActivity(new Intent(this, LoginActivity.class));
            finish();

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_blog) {
            startActivity(new Intent(this, BlogActivity.class));
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this, GalleryActivity.class));

        } else if (id == R.id.nav_event) {
            startActivity(new Intent(this, EventActivity.class));

        } else if (id == R.id.nav_news) {
            startActivity(new Intent(this, NewsActivity.class));

        } else if (id == R.id.fragment) {
            startActivity(new Intent(this, FormActivity.class));

        } else if (id == R.id.spinner_activity) {
            startActivity(new Intent(this, MovieActivity.class));

        } else if (id == R.id.nav_Grievance) {
            startActivity(new Intent(this, RecyclerviewActivity.class));

        } else if (id == R.id.nav_Profile) {
            startActivity(new Intent(this, MyActivity.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void init() {

            viewPager = (ViewPager) findViewById(R.id.viewPager);
        vPagerEventHome = (ViewPager) findViewById(R.id.vPagerEventHome);

        arrayList = new ArrayList<Slider>();

        //Utils.hideKeyboard(Login.this);

        final Call<NewHomeResponse> loginResponseCall = RestClient.getClient().
                getSlider();
        loginResponseCall.enqueue(new Callback<NewHomeResponse>() {
            @Override
            public void onResponse(Call<NewHomeResponse> call, Response<NewHomeResponse> response) {
                Log.d("MainActivity", "Status Code = " + response.code());

                if (response.isSuccessful()) {
                    homeResponse = response.body();
                    if (homeResponse.getSuccess()) {

                        viewPagerAdapter = new ViewPagerAdapter(NavigationActivity.this, homeResponse.getResponse().getSlider());
                        viewPager.setAdapter(viewPagerAdapter);

                        homeMenuAdapter = new HomeMenuAdapter(NavigationActivity.this, homeResponse.getResponse().getHomemenus());
                        recyclerViewMenus.setAdapter(homeMenuAdapter);

                        initiativeAdapter = new InitiativeAdapter(NavigationActivity.this, homeResponse.getResponse().getInitiatives());
                        recycleViewIni.setAdapter(initiativeAdapter);

                        advertiseAdapter = new AdvertiseAdapter(NavigationActivity.this, homeResponse.getResponse().getAdvertisements());
                        recycleViewAdvertise.setAdapter(advertiseAdapter);

                        eventHomeAdapter = new EventHomeAdapter(NavigationActivity.this, homeResponse.getResponse().getEvents());
                        vPagerEventHome.setAdapter(eventHomeAdapter);

                        // request successful (status code 200, 201)

                    } else {
                        Toast.makeText(NavigationActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    // homeResponse received but request not successful (like 400,401,403 etc)
                    //Handle errors
                }
            }

            @Override
            public void onFailure(Call<NewHomeResponse> call, Throwable t) {

            }
        });

//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//                                              @Override
//                                              public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                                              }
//
//                                              @Override
//                                              public void onPageSelected(int position) {
//                                                  addBottomDots(position);
//                                              }
//
//                                              @Override
//                                              public void onPageScrollStateChanged(int state) {
//
//                                              }
//                                          }

//        );
    }

    public void disconnectFromFacebook() {

        if (AccessToken.getCurrentAccessToken() == null) {
            return; // already logged out
        }else

        new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/permissions/", null, HttpMethod.DELETE, new GraphRequest
                .Callback() {
            @Override
            public void onCompleted(GraphResponse graphResponse) {

                LoginManager.getInstance().logOut();

            }
        }).executeAsync();
    }
}
