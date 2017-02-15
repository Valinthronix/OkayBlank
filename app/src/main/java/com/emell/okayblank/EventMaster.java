package com.emell.okayblank;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Val on 2/15/2017.
 */

public class EventMaster {
	private static EventMaster sEventMaster;

	private List<Event> mEvents;

	public static EventMaster get(Context context) {
		if (sEventMaster == null) {
			sEventMaster = new EventMaster(context);
		}
		return sEventMaster;
	}

	private EventMaster(Context context) {
		mEvents = new ArrayList<>();
		for (int i = 0; i < 100; i++){
			Event event = new Event();
			event.setTitle("Event #" + i);
			event.setDescription("Description #" + i);
			event.setGrade(7);
			mEvents.add(event);
		}
	}

	public List<Event> getEvents() {
		return mEvents;
	}

	public Event getEvent(UUID id) {
		for (Event event : mEvents) {
			if (event.getId().equals(id)) {
				return event;
			}
		}
		return null;
	}
}

