package com.example.famismartsdq.canvansdemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by famismartsdq on 17/2/7.
 */

public class CustomView extends View{
    private Path path;
    private Context context;
    public CustomView(Context context) {
        super(context);
        this.context=context;
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int height=getHeight();
        int width=getWidth();
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        path=new Path();
        path.moveTo(width/2,height/2);
//        path.quadTo(width/2+100,height/2-40,width/2,height/2+100);
        path.cubicTo(width/2+100,height/2-100,width/2+400,height/2+40,width/2,height/2+400);
        canvas.drawPath(path,paint);
        path.moveTo(width/2,height/2);
        path.cubicTo(width/2-100,height/2-100,width/2-400,height/2+40,width/2,height/2+400);
        canvas.drawPath(path,paint);
        //画手
        path.reset();
        Paint penshouPaint=new Paint();
        penshouPaint.setColor(Color.WHITE);
        penshouPaint.setAntiAlias(true);
        penshouPaint.setStyle(Paint.Style.STROKE);
        penshouPaint.setStrokeWidth(2);
        path.moveTo(width/2-400,height/2+400);
        path.quadTo(width/2-400+10,height/2+200,width/2-400+20,height/2+340);
        canvas.drawPath(path,penshouPaint);
        path.moveTo(width/2-400+20,height/2+340);
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inSampleSize=2;
        Resources res=context.getResources();

//        canvas.drawCircle(100,100,20,paint);
    }
}
