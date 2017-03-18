package com.emell.okayblank;

import java.util.Calendar;
import java.util.UUID;

/**
 * Created by Val on 2/3/2017.
 */

public class Event {
	private UUID mId;
	private String mTitle;
	private String mDescription;
	private Calendar mDate;
	private String mBlock;

	public Event() {
		mId = UUID.randomUUID();
	}

	public Event( String title, String description, Calendar date, String block) {
		mId = UUID.randomUUID();
		mTitle = title;
		mDescription = description;
		mDate = date;
		mBlock = block;
	}

	public UUID getId() {
		return mId;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public String getDescription() {
		return mDescription;
	}

	public void setDescription(String description) {
		mDescription = description;
	}

	public Calendar getDate() {
		return mDate;
	}

	public void setDate(Calendar date) {
		mDate = date;
	}

	public String getBlock() {
		return mBlock;
	}

	public void setBlock(String block) {
		mBlock = block;
	}
}
