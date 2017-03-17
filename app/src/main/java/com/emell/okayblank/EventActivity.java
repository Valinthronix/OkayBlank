package com.emell.okayblank;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import java.util.UUID;

public class EventActivity extends DrawerWithFragmentActivity{

	private static final String EXTRA_EVENT_ID = "com.emell.OkayBlank.event_id";

    @Override
	protected Fragment createFragment(){
	    UUID eventId = (UUID) getIntent().getExtras().getSerializable(EXTRA_EVENT_ID);
	    return EventFragment.newInstance(eventId);
    }

	public static Intent newIntent(Context packageContext, UUID event_id){
		Intent intent = new Intent(packageContext, EventActivity.class);
		intent.putExtra(EXTRA_EVENT_ID, event_id);
		return intent;
	}


}
