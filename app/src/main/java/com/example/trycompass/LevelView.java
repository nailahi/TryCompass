package com.example.trycompass;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.constraintlayout.solver.widgets.Rectangle;

public class LevelView extends View {
    float x = -50;
    float y = 100;


    public LevelView(Context context) {
        super(context);
    }


    public LevelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(Color.BLACK);
        Paint paintR = new Paint(Color.LTGRAY);
        int w = getWidth();
        int h = getHeight();
        int cx = w / 2;
        int cy = h / 2;
        int radius = 30;
        canvas.drawCircle(cx, cy, radius, paint);
        canvas.drawRect(550, 800, cx , cy, paintR);


    }
}
