package com.emell.okayblank;

import android.support.v4.app.Fragment;

/**
 * Created by Val on 2/15/2017.
 */

public class MainActivity extends DrawerWithFragmentActivity {

	@Override
	protected Fragment createFragment(){
		return EventListFragment.newInstance("all");
	}


}
