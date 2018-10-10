package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Practice11PieChartView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    private float mRidus = 200f;

    float skewingLength;

    //模拟数据
    private Map<String, Float> datasMap = new LinkedHashMap<>();
    private int mWidth;
    private int mHeight;
    private int mSectorX;
    private int mSectorY;
    private List<SectorsData> mSectorDataList;

    {
        datasMap.put("Froyo", 2f);
        datasMap.put("Gingerbread", 6f);
        datasMap.put("ice Cream Sandwich", 5f);
        datasMap.put("Jelly Bean", 50f);
        datasMap.put("KitKat", 80f);
        datasMap.put("Lollipop", 110f);
        datasMap.put("Marshmallow", 40f);

    }

    private int[] mColors = {Color.parseColor("#5C5D61"),
            Color.parseColor("#641499"), Color.parseColor("#A0EC07"),
            Color.parseColor("#0B7C67"), Color.parseColor("#0E70EF"),
            Color.parseColor("#D42436"), Color.parseColor("#D19724")};

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取当前view的宽高
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();

        //扇形的中心坐标
        mSectorX = mWidth / 2;
        mSectorY = mHeight / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
//        paint.setStyle(Paint.Style.FILL);
//
//        paint.setColor(Color.parseColor("#5C5D61"));
//        canvas.drawArc(150,50,550,450,0,2,true,paint);
//
//        paint.setColor(Color.parseColor("#641499"));
//        canvas.drawArc(150,50,550,450,2,11,true,paint);
//
//        paint.setColor(Color.parseColor("#A0EC07"));
//        canvas.drawArc(150,50,550,450,13,11,true,paint);
//
//        paint.setColor(Color.parseColor("#0B7C67"));
//        canvas.drawArc(150,50,550,450,24,66,true,paint);
//
//        paint.setColor(Color.parseColor("#0E70EF"));
//        canvas.drawArc(150,50,550,450,90,100,true,paint);
//
//        paint.setColor(Color.parseColor("#D42436"));
//        canvas.drawArc(150,50,550,450,190,120,true,paint);
//
//        paint.setColor(Color.parseColor("#D19724"));
//        canvas.drawArc(150,50,550,450,310,50,true,paint);


        //------------------------
        drawSectors(canvas);
        drawLines(canvas);
        drawTexts(canvas);
    }

    /**
     * 绘制文字
     *
     * @param canvas
     */
    private void drawTexts(Canvas canvas) {

    }

    /**
     * 绘制线
     *
     * @param canvas
     */
    private void drawLines(Canvas canvas) {

    }

    /**
     * 绘制扇形
     *
     * @param canvas
     */
    private void drawSectors(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);

        mSectorDataList = calculateSectorsDatas();
        SectorsData sectorsData;
        for (int i = 0; i < mSectorDataList.size(); i++) {
            sectorsData = mSectorDataList.get(i);
            paint.setColor(mColors[i]);
            canvas.drawArc(sectorsData.left, sectorsData.top, sectorsData.right, sectorsData.bottom,
                    sectorsData.startAngle, sectorsData.sweepAngle, true, paint);
        }

    }

    /**
     * 计算扇形的坐标以及角度
     *
     * @return
     */
    private List<SectorsData> calculateSectorsDatas() {
        List<SectorsData> sectorsDataList = new ArrayList<>();
        float startAngle = 0;   //起始角度
        float sweepAngle;  //扇形角度
        float sum = 0;  //总量
        float maxValue = getMaxValue();

        for (String key : datasMap.keySet()) {
            sum += datasMap.get(key);
        }

        for (String key : datasMap.keySet()) {

            // 偏移量   突出最大的扇形
            if (datasMap.get(key) == maxValue) {
                skewingLength = 20f;
            } else {
                skewingLength = 6f;
            }

            sweepAngle = (datasMap.get(key) / sum) * 360;
            SectorsData data = calculateDirectionCoord(startAngle, sweepAngle);
            data.startAngle = startAngle;
            data.sweepAngle = sweepAngle;
            sectorsDataList.add(data);
            startAngle += sweepAngle;
        }

        return sectorsDataList;
    }

    /**
     * 根据扇形角度计算扇形的偏移方向以及最终坐标
     *
     * @param startAngle 起始角度
     * @param sweepAngle 扇形角度
     * @return
     */
    private SectorsData calculateDirectionCoord(float startAngle, float sweepAngle) {

        SectorsData data = new SectorsData();
        data.middleAngle = startAngle + sweepAngle / 2; //扇形中间角度，用于计算偏移方向

        float skwingX;
        float skwingY;
        skwingX = (float) (skewingLength * Math.cos(data.middleAngle * Math.PI / 180));
        skwingY = (float) (skewingLength * Math.sin(data.middleAngle * Math.PI / 180));
        data.left = mSectorX - mRidus + skwingX;
        data.top = mSectorY - mRidus + skwingY;
        data.right = mSectorX + mRidus + skwingX;
        data.bottom = mSectorY + mRidus + skwingY;
        data.sectorX = mSectorX + skwingX;
        data.sectorY = mSectorY + skwingY;

        return data;
    }

    /**
     * 获取最大的一块扇形，突出最大的扇形
     *
     * @return
     */
    private float getMaxValue() {
        float max = 0f;
        for (String key : datasMap.keySet()) {
            if (datasMap.get(key) > max) {
                max = datasMap.get(key);
            }
        }
        return max;
    }

    //扇形数据类
    private class SectorsData {
        float left;
        float top;
        float right;
        float bottom;
        float startAngle;
        float sweepAngle;
        float middleAngle;
        float sectorX;
        float sectorY;
    }
}
