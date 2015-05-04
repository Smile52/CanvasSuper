package com.example.canvassuper;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class DrawViewShan extends View {
	private int ScrWidth,ScrHeight;
	private float i;
	private float y;
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==0x1333)
				DrawViewShan.this.invalidate();//重新绘制图
		};
	};

	public DrawViewShan(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	
	}
	public DrawViewShan(Context context, AttributeSet attrs) {
		this(context, attrs,0);
		// TODO Auto-generated constructor stub
	}

	public DrawViewShan(Context context) {
		this(context,null);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onDraw(Canvas canvas) {
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				i=new Random().nextInt(360);
				handler.sendEmptyMessage(0x1333);
			}
		}, 1000);
		super.onDraw(canvas);
		
		DisplayMetrics dm=getResources().getDisplayMetrics();
		ScrHeight=dm.heightPixels;
		ScrWidth=dm.widthPixels;
		Paint paint=new Paint();
		Paint paint1=new Paint();
		paint.setAntiAlias(true);//抗锯齿
		paint.setColor(Color.RED);//设置画笔的颜色为红色
		paint.setStyle(Style.FILL);//充满
		paint1.setColor(Color.YELLOW);
		paint1.setStyle(Style.STROKE);
		paint1.setAntiAlias(true);
		
		//canvas.drawCircle(300, 300, 200, paint);//画个圆测试一下
		RectF rec=new RectF(100, 100, 500, 500);
		canvas.drawArc(rec, 0, 360, true, paint1);
		canvas.drawArc(rec, 0, i, true, paint);
		y=i/360f;
		canvas.drawText("扇形百分比："+y, 500, 50, paint);
		
	}

}
