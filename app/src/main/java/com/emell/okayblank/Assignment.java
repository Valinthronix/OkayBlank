package com.emell.okayblank;

import java.util.Calendar;

/**
 * Created by Val on 3/17/2017.
 */

public class Assignment extends Event {
	private int mGrade;
	private boolean isSummative;
	private String mCategory;
	private String mComments;

	public Assignment() {
		super();
	}

	public Assignment(String title, String description, Calendar date, int grade, String block, boolean isSummative, String category, String comments) {
		super(title, description, date, block);
		mGrade = grade;
		this.isSummative = isSummative;
		mCategory = category;
		mComments = comments;
	}

	public int getGrade() {
		return mGrade;
	}

	public void setGrade(int grade) {
		mGrade = grade;
	}

	public boolean isSummative() {
		return isSummative;
	}

	public void setSummative(boolean summative) {
		isSummative = summative;
	}

	public String getCategory() {
		return mCategory;
	}

	public void setCategory(String category) {
		mCategory = category;
	}

	public String getComments() {
		return mComments;
	}

	public void setComments(String comments) {
		mComments = comments;
	}
}
