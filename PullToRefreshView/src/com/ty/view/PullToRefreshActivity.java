package com.ty.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ty.pull.to.refresh.PullToRefreshView;

public class PullToRefreshActivity extends Activity {

	public static final int REFRESH_DELAY = 2000;

	private PullToRefreshView mPullToRefreshView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pull_to_refresh);

		Map<String, Integer> map;
		List<Map<String, Integer>> sampleList = new ArrayList<Map<String, Integer>>();

		int[] icons = { R.drawable.icon_1, R.drawable.icon_2, R.drawable.icon_3 };

		int[] colors = { R.color.saffron, R.color.eggplant, R.color.sienna };

		for (int i = 0; i < icons.length; i++) {
			map = new HashMap<String, Integer>();
			map.put(RefreshAdapter.KEY_ICON, icons[i]);
			map.put(RefreshAdapter.KEY_COLOR, colors[i]);
			sampleList.add(map);
		}

		ListView listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(new RefreshAdapter(this, R.layout.list_item,
				sampleList));

		mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_to_refresh);

		mPullToRefreshView
				.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
					@Override
					public void onRefresh() {
						mPullToRefreshView.postDelayed(new Runnable() {
							@Override
							public void run() {
								Toast.makeText(PullToRefreshActivity.this,
										"Success", Toast.LENGTH_SHORT).show();
								mPullToRefreshView.setRefreshing(false);
							}
						}, REFRESH_DELAY);
					}
				});
	}
}
