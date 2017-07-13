package org.flyve.mdm.agent.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.flyve.mdm.agent.R;

import java.util.ArrayList;
import java.util.HashMap;

public class LogAdapter extends BaseAdapter {

	private Activity _activity;
	private ArrayList<HashMap<String, String>> _data;
	private static LayoutInflater inflater = null;

	public LogAdapter(Activity activity, ArrayList<HashMap<String, String>> data) {
		this._data = data;
		this._activity = activity;
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return _data.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;

		HashMap<String, String> hashdata = _data.get(position);

		vi = inflater.inflate(R.layout.listitem_main, null);

		TextView txtType = (TextView) vi.findViewById(R.id.txtType);
		txtType.setText(hashdata.get("type"));

		TextView txtDate = (TextView) vi.findViewById(R.id.txtDate);
		txtDate.setText(hashdata.get("date"));

		TextView txtTitle = (TextView) vi.findViewById(R.id.txtTitle);
		txtTitle.setText(hashdata.get("title"));

		TextView txtBody = (TextView) vi.findViewById(R.id.txtBody);
		txtBody.setText(hashdata.get("body"));

		return vi;

	}

}
