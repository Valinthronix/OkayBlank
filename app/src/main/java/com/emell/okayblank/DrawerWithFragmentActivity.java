package com.emell.okayblank;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;

/**
 * Created by Val on 2/15/2017.
 */

public abstract class DrawerWithFragmentActivity extends FragmentActivity {

	protected abstract Fragment createFragment();
	private NavigationView mNavigationView;
	private DrawerLayout mDrawerLayout;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawer_fragment);
		mNavigationView = (NavigationView) findViewById(R.id.nav_view);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		final Menu menu = mNavigationView.getMenu();
		final int start = Menu.FIRST + 1;


		final FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.drawer_fragment_container);

		NavigationView.OnNavigationItemSelectedListener navListener = new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem menuItem) {
				menuItem.setChecked(true);
				int id = menuItem.getItemId();
				FragmentTransaction ft = fm.beginTransaction();

				switch (id) {
					case R.id.upcoming:
						ft.replace(R.id.drawer_fragment_container, EventListFragment.newInstance("all"));
						break;
					case R.id.past:
						ft.replace(R.id.drawer_fragment_container, EventListFragment.newInstance("all"));
						break;
				}
				ft.commit();

				mDrawerLayout.closeDrawers();
				return true;
			}
		};

		mNavigationView.setNavigationItemSelectedListener(navListener);

		for (int i = 1; i <= 3; i++) {
			menu.add(R.id.nav_group, start + i, Menu.NONE, Integer.toString(i-1));

			menu.findItem(start+i).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
				@Override
				public boolean onMenuItemClick(MenuItem item) {
					FragmentTransaction ft = fm.beginTransaction();
					ft.replace(R.id.drawer_fragment_container, EventListFragment.newInstance(item.getTitle().toString()));
					ft.commit();
					return false;
				}
			});
		}
		menu.setGroupCheckable(R.id.nav_group, true, true);

		mNavigationView.setCheckedItem(R.id.upcoming);
		//navListener.onNavigationItemSelected(mNavigationView.getMenu().getItem(0));



/*		for (int i = 0, count = mNavigationView.getChildCount(); i < count; i++) {
			final View child = mNavigationView.getChildAt(i);
			if (child != null && child instanceof ListView) {
				final ListView menuView = (ListView) child;
				final HeaderViewListAdapter adapter = (HeaderViewListAdapter) menuView.getAdapter();
				final BaseAdapter wrapped = (BaseAdapter) adapter.getWrappedAdapter();
				wrapped.notifyDataSetChanged();
			}
		}*/


		if (fragment == null) {
			fragment = createFragment();
			fm.beginTransaction()
				.add(R.id.drawer_fragment_container, fragment)
				.commit();
		}
	}

}
