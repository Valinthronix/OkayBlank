package com.emell.okayblank;

import java.util.UUID;

/**
 * Created by Val on 2/3/2017.
 */

public class Event {
	private UUID mId;
	private String mTitle;
	private String mDescription;
	private int mGrade;

	public Event() {
		mId = UUID.randomUUID();
	}

	public UUID getId() {
		return mId;
	}

	public int getGrade() {
		return mGrade;
	}

	public void setGrade(int grade) {
		mGrade = grade;
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
}
