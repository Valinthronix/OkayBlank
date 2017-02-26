package com.emell.okayblank;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;


/**
 * Created by Val on 2/15/2017.
 */

public class EventFragment extends Fragment {
	private Event mEvent;
	private TextView mTitleField;
	private TextView mDescriptionField;
	private static final String ARG_EVENT_ID = "event_id";

	public static EventFragment newInstance(UUID eventId){
		Bundle args = new Bundle();
		args.putSerializable(ARG_EVENT_ID, eventId);

		EventFragment fragment = new EventFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		UUID eventId = (UUID) getArguments().getSerializable(ARG_EVENT_ID);
		mEvent = EventMaster.get(getActivity()).getEvent(eventId);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_event, container, false);
		mTitleField = (TextView) v.findViewById(R.id.event_title);
		mDescriptionField = (TextView) v.findViewById(R.id.event_description);
		mTitleField.setText(mEvent.getTitle());
		mDescriptionField.setText(mEvent.getDescription());
		return v;
	}
}
