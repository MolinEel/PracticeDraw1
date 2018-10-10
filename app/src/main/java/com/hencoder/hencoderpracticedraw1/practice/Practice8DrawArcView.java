package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(50,50,350,250,250,100,true,paint);
        canvas.drawArc(50,50,350,250,30,120,false,paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(50,50,350,250,180,50,false,paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(400,200,600,400,0,10,true,paint);
        paint.setColor(Color.BLUE);
        canvas.drawArc(400,200,600,400,10,20,true,paint);
        paint.setColor(Color.YELLOW);
        canvas.drawArc(400,200,600,400,30,30,true,paint);
        paint.setColor(Color.RED);
        canvas.drawArc(400,200,600,400,60,60,true,paint);
        paint.setColor(Color.GREEN);
        canvas.drawArc(400,200,600,400,120,90,true,paint);
        paint.setColor(Color.GRAY);
        canvas.drawArc(400,200,600,400,210,150,true,paint);

    }
}
