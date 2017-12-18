package com.mycompany.crazylesson3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/12/18.
 */

public class PlaneView extends View {
    public float currentX;
    public float currentY;
    String str;
    Bitmap bitmap;
    public PlaneView(Context context)
    {
        super(context);
        setFocusable(true);
    }
    public PlaneView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint paint=new Paint();    //采用默认设置创建一个画笔
        paint.setAntiAlias(true);//使用抗锯齿功能
        paint.setColor(0xFFA4C739);    //设置画笔的颜色为绿色
        paint.setStyle(Paint.Style.FILL);//设置画笔类型为填充
        /***********绘制圆弧*************/
        RectF rectf_head=new RectF(10, 10, 100, 100);//确定外切矩形范围
        rectf_head.offset(100, 20);//使rectf_head所确定的矩形向右偏移100像素，向下偏移20像素
       // canvas.drawArc(rectf_head, -10, -160, false, paint);//绘制圆弧，不含圆心

        canvas.drawCircle(currentX, currentY, 90, paint);

        paint.setColor(Color.RED);
        paint.setTextSize(40); //以px为单位
        canvas.drawText(str,100,100,paint);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
    }
}
