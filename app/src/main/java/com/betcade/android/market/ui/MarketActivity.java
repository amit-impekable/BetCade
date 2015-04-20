package com.betcade.android.market.ui;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.betcade.android.market.R;
import com.betcade.android.market.model.WebContent;
import com.betcade.android.market.ui.fragment.NavigationDrawerFragment;

import java.util.Locale;

public class MarketActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    private static final String TAG = MarketActivity.class.getSimpleName();

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), getResources().getStringArray(R.array.tab_names));

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(getIntent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_market, menu);
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            restoreActionBar();
            // Associate searchable configuration with the SearchView
            MenuItem menuItem = menu.findItem(R.id.search);
            if (null != menuItem) {
                Log.d(TAG, "Menu item: " + menuItem.getClass().getCanonicalName());
                SearchView searchView = (SearchView) menuItem.getActionView();
                if (null != searchView) {
                    Log.d(TAG, "Search view: " + searchView.getClass().getCanonicalName());
                    //                SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
                    //                searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, MarketActivity.class)));
                    searchView.setOnQueryTextListener(searchViewQueryListener);
                } else {
                    Log.e(TAG, "Search view: NULL");
                }
            } else {
                Log.e(TAG, "Menu item: NULL");
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "Search view: " + item.getClass().getCanonicalName());
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
//                .commit();
        Log.d(TAG, "Item clicked @ position: " + String.valueOf(position));


        String[] menuArray=getResources().getStringArray(R.array.tab_names);
        if (null != mViewPager) {



           if(menuArray[position].equalsIgnoreCase(getString(R.string.cat_privacy)) || menuArray[position].equalsIgnoreCase(getString(R.string.cat_eula)))
            {
                if(menuArray[position].equalsIgnoreCase(getString(R.string.cat_privacy)))
                {
                    startActivity(new Intent(this, WebContentActivity.class).putExtra("webUrl",new WebContent().getPP()).putExtra("title",getString(R.string.cat_privacy)));
                }
                else if(menuArray[position].equalsIgnoreCase(getString(R.string.cat_eula)))
                {
                    startActivity(new Intent(this, WebContentActivity.class).putExtra("webUrl",new WebContent().getEULA()).putExtra("title",getString(R.string.cat_eula)));
                }
            }
            else
            {
                mViewPager.setCurrentItem(position);
            }
        }
    }

    private SearchView.OnQueryTextListener searchViewQueryListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
            Log.d(TAG, "onQueryTextSubmit: " + s);
            return false;

        }

        @Override
        public boolean onQueryTextChange(String s) {
            Log.d(TAG, "onQueryTextChange: " + s);
            return false;
        }
    };

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    private void handleIntent(Intent intent) {
        Log.d(TAG, "Processing intent");
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            Log.d(TAG, "Search intent matched");
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        String[] categories;

        public SectionsPagerAdapter(FragmentManager fm, String[] categories) {
            super(fm);
            this.categories = categories;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            if (null == categories)
                return 0;
            return categories.length-2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            if (null == categories || position > categories.length)
                return getString(R.string.tab_home).toUpperCase(l);
            return categories[position].toUpperCase(l);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_market, container, false);
            return rootView;
        }
    }

}
