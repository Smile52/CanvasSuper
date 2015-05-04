package com.example.canvassuper;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;

public class MainActivity extends FragmentActivity {
	private ViewPager viewpage;
	private FragmentZhe zhe;
	private FragmentZhu zhu;
	private FragmentShan shan;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewpage=(ViewPager) findViewById(R.id.viewPager);
		 Fragment fragmentshan=new FragmentShan();//创建Fragment对象
		 Fragment fragmentzhe=new FragmentZhe();
		 Fragment fragmentzhu=new FragmentZhu();
		 //定义一个Fragment数组，然后将开始我们定义的Fragment对象放进去
		 Fragment[] fragementArray=new Fragment[]{fragmentshan,fragmentzhe,fragmentzhu};
		 FragmentPageAdapter adapter=new FragmentPageAdapter( getSupportFragmentManager(), fragementArray);
		 viewpage.setAdapter(adapter);
		 viewpage.setOffscreenPageLimit(3);
		 viewpage.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	 public void doClick(View v){
		 switch (v.getId()) {
		case R.id.zhu_bt:
			viewpage.setCurrentItem(2);
			break;
		case R.id.zhexian_bt:
			viewpage.setCurrentItem(0);
			break;
		case R.id.shanxing_bt:
			viewpage.setCurrentItem(1);
		default:
			break;
		}
	 }
	

	

}
