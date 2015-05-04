package com.example.canvassuper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentShan extends android.support.v4.app.Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootview=inflater.inflate(R.layout.fragment_shan, container,false);
		
		return rootview;
	}
}


