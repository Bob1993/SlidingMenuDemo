package com.bob.slidingmenu.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.bob.slidingmenu.MainActivity;
import com.bob.slidingmenu.R;
/**
 * @date 2015/4/26
 * @author bob
 * @description 侧边栏菜单
 */
public class LeftFragment extends Fragment implements OnClickListener{
	private View view_1;
	private View view_2;
	private View view_3;
	private View view_4;
	private View view_5;
	private View view_6;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout_menu, null);
		findViews(view);
		
		return view;
	}
	
	
	public void findViews(View view) {
		view_1 = view.findViewById(R.id.sunday);
		view_2 = view.findViewById(R.id.monday);
		view_3 = view.findViewById(R.id.tuesday);
		view_4 = view.findViewById(R.id.wednesday);
		view_5 = view.findViewById(R.id.thursday);
		view_6 = view.findViewById(R.id.friday);
		
		view_1.setOnClickListener(this);
		view_2.setOnClickListener(this);
		view_3.setOnClickListener(this);
		view_4.setOnClickListener(this);
		view_5.setOnClickListener(this);
		view_6.setOnClickListener(this);
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		Fragment newContent = null;
		String title = null;
		switch (v.getId()) {
		case R.id.sunday: // 周日
			newContent = new Fragment_1();
			title = getString(R.string.item_1);
			break;
		case R.id.monday:// 周一
			newContent = new Fragment_2();
			title = getString(R.string.item_2);
			break;
		case R.id.tuesday: // 周二
			newContent = new Fragment_3();
			title = getString(R.string.item_3);
			break;
		case R.id.wednesday: // 周三
			newContent = new Fragment_4();
			title = getString(R.string.item_4);
			break;
		case R.id.thursday: // 周四
			newContent = new Fragment_5();
			title = getString(R.string.item_5);
			break;
		case R.id.friday: // 周五
			newContent = new Fragment_6();
			title = getString(R.string.item_6);
			break;
		default:
			break;
		}
		if (newContent != null) {
			switchFragment(newContent, title);
		}
	}
	
	/**
	 * 切换fragment
	 * @param fragment
	 */
	private void switchFragment(Fragment fragment, String title) {
		if (getActivity() == null) {
			return;
		}
		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchContent(fragment,title);
		}
	}
	
}
