package com.example.cometmap;

import java.util.ArrayList;

import rss.Talk;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


public class MyCustomBaseAdapter extends BaseAdapter {

	private static ArrayList<Talk> talkArrayList;
	
	private LayoutInflater mInflater;
	
	public MyCustomBaseAdapter(Context context,
			ArrayList<Talk> talks) {
		// TODO Auto-generated constructor stub
		talkArrayList=talks;
		System.out.println(talkArrayList.size());
		mInflater = LayoutInflater.from(context);
		System.out.println("Mycustombaseadapter");
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return talkArrayList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return talkArrayList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.custom_row_layout,null);
			holder = new ViewHolder();
			holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
			holder.txtTime = (TextView) convertView.findViewById(R.id.time);
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.txtTitle.setText(talkArrayList.get(position).getTitle());
		holder.txtTime.setText(talkArrayList.get(position).getDate()+" "+talkArrayList.get(position).getBeginTime()+"-"+talkArrayList.get(position).getEndTime());
		return convertView;
	}

	static class ViewHolder {
        TextView txtTitle;
        TextView txtTime;
    }
}
