package com.emell.okayblank;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;
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
			Event event;
			if ((i % 2) == 0) {
				event = new Event();
				event.setTitle("Event #" + i);
			}
			else{
				event = new Assignment();
				event.setTitle("Assignment #" + i);
			}
			event.setDescription("Description #" + i);
			event.setDate(Calendar.getInstance());
			event.setBlock(Integer.toString(i % 3));
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

	public List<Assignment> getAssignments() {
		List<Assignment> assignments = new ArrayList<>();
		for (Event event : mEvents) {
			if (event instanceof Assignment){
				assignments.add((Assignment)event);
			}
		}
		return assignments;
	}

	public List<Event> getEventsOfBlock(String block){
		List<Event> events = new ArrayList<>();
		if (block.equals("all")){
			return mEvents;
		}
		for (Event event : mEvents){
			if (event.getBlock().equals(block)){
				events.add(event);
			}
		}
		return events;
	}

	public List<Event> getAssignmentsOfBlock(String block) {
		List<Event> events = new ArrayList<>();
		if (block.equals("all")){
			getEvents();
		}
		for (Event event : mEvents){
			if (event.getBlock().equals(block) && event instanceof Assignment){
				events.add(event);
			}
		}
		return events;
	}
}

