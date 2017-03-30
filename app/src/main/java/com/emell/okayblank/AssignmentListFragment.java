package com.emell.okayblank;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Val on 3/29/2017.
 */

public class AssignmentListFragment extends EventListFragment {


	public static AssignmentListFragment newInstance(String block){
		Bundle args = new Bundle();
		args.putString(ARG_BLOCK, block);

		AssignmentListFragment fragment = new AssignmentListFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	protected List<Event> getEventList(EventMaster eventMaster) {
		List<Event> events = eventMaster.getAssignmentsOfBlock(getArguments().getString(ARG_BLOCK));
		return events;
	}

	@Override
	protected EventHolder getHolder(View itemView){
		return new AssignmentHolder(itemView);
	}


	protected class AssignmentHolder extends EventListFragment.EventHolder {


		public AssignmentHolder(View itemView){
			super(itemView);
			itemView.setOnClickListener(this);
			mTitleTextView = (TextView)
					                 itemView.findViewById(R.id.list_item_event_title_text_view);
			mDescriptionTextView = (TextView)
					                       itemView.findViewById(R.id.list_item_event_description_text_view);
			mDateTextView = (TextView)
					                itemView.findViewById(R.id.list_item_event_date);
		}

	}



}
