package com.qihoo.hair.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.qihoo.haierdemo.R;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
    private int prePosition;
    //搜索条件列表
    private ListView searchListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mTitle = mDrawerTitle = getTitle();

        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        // adding nav drawer items to array
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[6], navMenuIcons.getResourceId(6, -1)));

        // Recycle the typed array
        navMenuIcons.recycle();

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
        View headerView = getLayoutInflater().inflate(R.layout.user,null);
        mDrawerList.addHeaderView(headerView);
        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(),navDrawerItems);
        mDrawerList.setAdapter(adapter);
        headerView.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));

        // enabling action bar app icon and behaving it as toggle button
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        initQueryListView();
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                hideSoftKeyBorad();
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }
    }

    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            if (position>0) {
                displayView(position);
            }
            else {
                mDrawerList.setItemChecked(prePosition, true);
                mDrawerList.setSelection(prePosition);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_search:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        searchListView.setVisibility(View.GONE);
        if (mTitle.equals(navMenuTitles[2])) {
            MenuItem searchMenu = menu.findItem(R.id.action_search);
            if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                searchMenu.setVisible(false);
                return true;
            }

            searchMenu.setVisible(true);

            final SearchView searchview=(SearchView) searchMenu.getActionView();

            searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    if (!TextUtils.isEmpty(newText)) {
                        searchListView.setVisibility(View.GONE);
                    }else {
                        if (!searchview.isIconified()&&TextUtils.isEmpty(searchview.getQuery())) {
                            searchListView.setVisibility(View.VISIBLE);
                        }
                    }
                    return false;
                }
            });

            searchview.setOnCloseListener(new SearchView.OnCloseListener() {
                @Override
                public boolean onClose() {
                    searchListView.setVisibility(View.GONE);
                    return false;
                }
            });
            searchview.setOnSearchClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchview.setQuery("",false);
                    searchListView.setVisibility(View.VISIBLE);
                }
            });
            searchview.setQueryHint("请输入搜索关键词");

//            searchview.setIconifiedByDefault(false);
//            SearchManager mSearchManager=(SearchManager)getSystemService(Context.SEARCH_SERVICE);
//            SearchableInfo info=mSearchManager.getSearchableInfo(getComponentName());
//            searchview.setSearchableInfo(info);
        }else {
            menu.findItem(R.id.action_search).setVisible(false);
        }
        return true;
    }

    /**
     * 隐藏软键盘.
     */
    private void hideSoftKeyBorad() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        // update the main content by replacing fragments
        if (position == 0) {
            mDrawerList.setItemChecked(prePosition, true);
            mDrawerList.setSelection(prePosition);
            initSearchFragment();
            return;
        }
        prePosition = position;
        Fragment fragment = null;
        switch (position) {
            case 1:
                fragment = new HairSpaceFragment();
                break;

            case 2:
                fragment = new OrderAndConsultFragment();
                break;

            case 3:
                fragment = new SearchAndExploreFragment();
                break;

            case 4:
                fragment = new DiscountFragment();
                break;

            case 5:
                fragment = new ShowFragment();
                break;

            case 6:
                fragment = new InfosFragment();
                break;

            case 7:
                fragment = new SettingsFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position-1]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    /**
     * 第一个页面为搜索页面.
     */
    private void initSearchFragment() {
        Fragment fragment = new SearchAndExploreFragment();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        // update selected item and title, then close the drawer
        mDrawerList.setItemChecked(3, true);
        mDrawerList.setSelection(3);
        setTitle(navMenuTitles[3-1]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * 初始化搜索框.
     */
    private void initQueryListView() {
        searchListView = (ListView)findViewById(R.id.search_list);
        ArrayList<String> list = new ArrayList<String>();
        list.add("按距离搜索（从近到远）");
        list.add("按人气搜索（从高到低）");
        list.add("按作品数搜索（从高到低）");
        list.add("按评价搜索（从高到低）");
        list.add("按优惠活动搜索（从近到远）");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.search_list_item,R.id.search_text,list);
        searchListView.setAdapter(arrayAdapter);
        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        searchListView.setVisibility(View.GONE);
    }
}
