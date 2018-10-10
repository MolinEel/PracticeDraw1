package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice10HistogramView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float interval = 20;
    private float perWidth = 66;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        RectF rectF1 = new RectF(80 + 1 * interval + 0 * perWidth,300 - 2,80 + 1 * perWidth + 1 * interval,300);
        RectF rectF2 = new RectF(80 + 2 * interval + 1 * perWidth,300 - 16,80 + 2 * perWidth + 2 * interval,300);
        RectF rectF3 = new RectF(80 + 3 * interval + 2 * perWidth,300 - 16,80 + 3 * perWidth + 3 * interval,300);
        RectF rectF4 = new RectF(80 + 4 * interval + 3 * perWidth,300 - 120,80 + 4 * perWidth + 4 * interval,300);
        RectF rectF5 = new RectF(80 + 5 * interval + 4 * perWidth,300 - 200,80 + 5 * perWidth + 5 * interval,300);
        RectF rectF6 = new RectF(80 + 6 * interval + 5 * perWidth,300 - 250,80 + 6 * perWidth + 6 * interval,300);
        RectF rectF7 = new RectF(80 + 7 * interval + 6 * perWidth,300 - 100,80 + 7 * perWidth + 7 * interval,300);

        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rectF1,paint);
        canvas.drawRect(rectF2,paint);
        canvas.drawRect(rectF3,paint);
        canvas.drawRect(rectF4,paint);
        canvas.drawRect(rectF5,paint);
        canvas.drawRect(rectF6,paint);
        canvas.drawRect(rectF7,paint);

        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        canvas.drawLines(new float[]{50,20,50,300,50,300,700,300},paint);
        canvas.drawLines(new float[]{46,24,50,20,50,20,54,24},paint);
        canvas.drawLines(new float[]{696,296,700,300,700,300,696,304},paint);

        paint.setTextSize(18);
        canvas.drawText("Froyo",80 + 1 * interval + 0.5f * perWidth-paint.measureText("Froyo")/2,320,paint);
        canvas.drawText("GB",80 + 2 * interval + 1.5f * perWidth-paint.measureText("GB")/2,320,paint);
        canvas.drawText("ICS",80 + 3 * interval + 2.5f * perWidth-paint.measureText("ICS")/2,320,paint);
        canvas.drawText("JB",80 + 4 * interval + 3.5f * perWidth-paint.measureText("JB")/2,320,paint);
        canvas.drawText("KitKat",80 + 5 * interval + 4.5f * perWidth-paint.measureText("KitKat")/2,320,paint);
        canvas.drawText("L",80 + 6 * interval + 5.5f * perWidth-paint.measureText("L")/2,320,paint);
        canvas.drawText("M",80 + 7 * interval + 6.5f * perWidth-paint.measureText("M")/2,320,paint);
//
        paint.setTextSize(30);
        canvas.drawText("直方图",getMeasuredWidth()/2-paint.measureText("直方图")/2,400,paint);
        Log.e("zhif","屏幕尺寸--"+getMeasuredHeight()+"----"+getMeasuredWidth());

    }
}
