package com.example.canvassuper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class DrawViewZhe extends View {
	private int ScrWidth,ScrHeight;
	private List<Integer> data=new ArrayList<Integer>();
	private int maxData=6;
	
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==0x1234){
				DrawViewZhe.this.invalidate();//重绘
			}
		};
	};
	
	public DrawViewZhe(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(data.size() >= 7){
						data.remove(0);//当最大值超过7，就移除屏幕第一条线
					}
					data.add(new Random().nextInt(4) + 1);
					handler.sendEmptyMessage(0x1234);
				}
			}
		}).start();
		
	}
	
	
	public DrawViewZhe(Context fragmentZhe) {
		this(fragmentZhe,null);

	}
	protected void onDraw(Canvas canvas) {	
		//获取系统屏幕的宽高
		DisplayMetrics dm=getResources().getDisplayMetrics();
		ScrHeight=dm.heightPixels;
		ScrWidth=dm.widthPixels;
		Paint paint=new Paint();
		paint.setColor(Color.BLUE);
		paint.setStyle(Style.STROKE);//设置画笔为空心
		paint.setAntiAlias(true);
		//画x轴
		canvas.drawLine(ScrWidth*0.1f, ScrHeight*0.5f, ScrWidth*0.8f, ScrHeight*0.5f, paint);//切记要加f
		//画Y轴
		canvas.drawLine(ScrWidth*0.1f, ScrHeight*0.5f, ScrWidth*0.1f, ScrHeight*0.1f, paint);
		//画连线
		if (data.size()>1){
			for(int i=1;i<data.size();i++){
				canvas.drawLine(ScrWidth*0.1f+(i-1)*100, ScrHeight*0.5f-data.get(i-1)*100,
						ScrWidth*0.1f + i*100, ScrHeight*0.5f-data.get(i)*100, paint);
			}
		}
	}
	
	public DrawViewZhe(Context context, AttributeSet attrs) {
		this(context, attrs,0);
		// TODO Auto-generated constructor stub
	}
}
