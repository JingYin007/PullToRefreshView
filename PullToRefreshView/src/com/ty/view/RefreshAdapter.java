package com.ty.view;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;


public class RefreshAdapter extends ArrayAdapter<Map<String, Integer>> {

	public static final String KEY_ICON = "icon";
	public static final String KEY_COLOR = "color";

	private final LayoutInflater mInflater;
	private final List<Map<String, Integer>> mData;

	public RefreshAdapter(Context context, int layoutResourceId,
			List<Map<String, Integer>> data) {
		super(context, layoutResourceId, data);
		mData = data;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(final int position, View convertView,
			ViewGroup parent) {
		final ViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.list_item, parent,
					false);
			viewHolder.imageViewIcon = (ImageView) convertView
					.findViewById(R.id.image_view_icon);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.imageViewIcon.setImageResource(mData.get(position).get(
				KEY_ICON));
		convertView.setBackgroundResource(mData.get(position)
				.get(KEY_COLOR));

		return convertView;
	}

	class ViewHolder {
		ImageView imageViewIcon;
	}

}
