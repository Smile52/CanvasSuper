package com.example.canvassuper;

import java.util.ArrayList;
import java.util.List;
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
import android.view.View;

public class DrawViewZhu extends View {
	private int rd,rd1,rd2;
	private List<Integer> data1=new ArrayList<Integer>();
	private  int maxData=6;
	
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==0x1444){
				DrawViewZhu.this.invalidate();//重新绘图
			}
		};
	};
	public DrawViewZhu(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
					
					handler.sendEmptyMessage(0x1444);
				
			}
		}).start();
	}

	public DrawViewZhu(Context context, AttributeSet attrs) {
		this(context, attrs,0);
		// TODO Auto-generated constructor stub
	}

	public DrawViewZhu(Context context) {
		this(context,null);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// 定义一个定时器 ，让画图每个0.5秒执行一次
				new Timer().schedule(new TimerTask() {
					
					@Override
					public void run() {
					 rd1=new Random().nextInt(6);
					 rd =new Random().nextInt(6);
					 rd2=new Random().nextInt(6);
						// TODO Auto-generated method stub
						handler.sendEmptyMessage(0x1444);
					}
				}, 500);
				super.onDraw(canvas);

				Paint paint=new Paint();
				paint.setStyle(Style.STROKE);//设置画笔为空心
				paint.setColor(Color.BLUE);
				Paint paintRed=new Paint();
				paintRed.setColor(Color.RED);
				canvas.drawLine(100, 60, 100, 500, paint);//画y轴
				canvas.drawLine(100, 500, 700, 500, paint);//画x轴
				//画y轴上的箭头
				canvas.drawLine(100, 60, 80, 80, paint);
				canvas.drawLine(100, 60, 120, 80, paint);
		
//		Paint paint =new Paint();
//		paint.setColor(Color.GREEN);
//		paint.setStyle(Style.FILL);
//		paint.setAntiAlias(true);
		
		
		canvas.drawLine(100, 60, 100, 500, paint);//画y轴
		canvas.drawLine(100, 500, 700, 500, paint);//画x轴
		//画y轴上的箭头
		canvas.drawLine(100, 60, 80, 80, paint);
		canvas.drawLine(100, 60, 120, 80, paint);
		//canvas.drawRect(100, 200, 300, 500, paint);
		
		//画柱状；动态图，就要改变柱状的top值
				RectF r=new RectF(200, rd*100, 270, 500);
				canvas.drawRect(r, paintRed);
				
				RectF r1=new RectF(300, rd1*100, 370, 500);
				canvas.drawRect(r1, paintRed);
				
				RectF r2=new RectF(400, rd2*100, 470, 500);
				canvas.drawRect(r2, paintRed);
				
		

		
	}

}
