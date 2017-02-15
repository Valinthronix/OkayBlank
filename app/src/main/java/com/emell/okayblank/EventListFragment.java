package com.emell.okayblank;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static java.util.Locale.US;

/**
 * Created by Val on 2/15/2017.
 */

public class EventListFragment extends Fragment {
	private RecyclerView mEventRecyclerView;
	private EventAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_event_list, container, false);

		mEventRecyclerView = (RecyclerView) view.findViewById(R.id.event_recycler_view);
		mEventRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		UpdateUI();

		return view;
	}
	private void UpdateUI() {
		EventMaster eventMaster = EventMaster.get(getActivity());
		List<Event> events = eventMaster.getEvents();

		mAdapter = new EventAdapter(events);
		mEventRecyclerView.setAdapter(mAdapter);
	}
	private class EventHolder extends RecyclerView.ViewHolder
			implements View.OnClickListener{

		private Event mEvent;

		private TextView mTitleTextView;
		private TextView mDescriptionTextView;
		private TextView mGradeTextView;

		public EventHolder(View itemView){
			super(itemView);
			itemView.setOnClickListener(this);
			mTitleTextView = (TextView)
				itemView.findViewById(R.id.list_item_event_title_text_view);
			mDescriptionTextView = (TextView)
				itemView.findViewById(R.id.list_item_event_description_text_view);
			mGradeTextView = (TextView)
				itemView.findViewById(R.id.list_item_event_grade_text_view);
		}

		public void bindEvent(Event event){
			mEvent = event;
			mTitleTextView.setText(mEvent.getTitle());
			mDescriptionTextView.setText(mEvent.getDescription());
			mGradeTextView.setText(String.format(US, "%d", mEvent.getGrade()));
		}

		public void onClick(View v) {
			Toast.makeText(getActivity(),mEvent.getTitle(), Toast.LENGTH_SHORT).show();
		}

	}

	private class EventAdapter extends RecyclerView.Adapter<EventHolder>{
		private List<Event> mEvents;

		public EventAdapter(List<Event> events){
			mEvents = events;
		}

		@Override
		public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
			View view = layoutInflater.inflate(R.layout.list_item_event, parent, false);
			return new EventHolder(view);
		}

		public void onBindViewHolder(EventHolder holder, int position) {
			Event event = mEvents.get(position);
			holder.bindEvent(event);
		}

		public int getItemCount(){
			return mEvents.size();
		}

	}
}
