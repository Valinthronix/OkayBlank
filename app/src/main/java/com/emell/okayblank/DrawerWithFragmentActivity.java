package com.emell.okayblank;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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

		mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem menuItem) {
				menuItem.setChecked(true);
				mDrawerLayout.closeDrawers();
				return true;
			}
		});

		final Menu menu = mNavigationView.getMenu();
		for (int i = 1; i <= 3; i++) {
			menu.add(R.id.nav_group, Menu.NONE, Menu.NONE, "Runtime item "+ i);
		}
		menu.setGroupCheckable(R.id.nav_group, true, true);

/*		for (int i = 0, count = mNavigationView.getChildCount(); i < count; i++) {
			final View child = mNavigationView.getChildAt(i);
			if (child != null && child instanceof ListView) {
				final ListView menuView = (ListView) child;
				final HeaderViewListAdapter adapter = (HeaderViewListAdapter) menuView.getAdapter();
				final BaseAdapter wrapped = (BaseAdapter) adapter.getWrappedAdapter();
				wrapped.notifyDataSetChanged();
			}
		}*/

		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.drawer_fragment_container);

		if (fragment == null) {
			fragment = createFragment();
			fm.beginTransaction()
				.add(R.id.drawer_fragment_container, fragment)
				.commit();
		}
	}

}
