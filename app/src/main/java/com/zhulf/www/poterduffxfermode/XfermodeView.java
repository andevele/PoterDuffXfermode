package com.zhulf.www.poterduffxfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/4/1.
 */

public class XfermodeView extends View {
    private Paint paint;
    private Paint mDSTpaint;
    private Paint mSrcBluePaint;
    private PorterDuffXfermode xFermode;

    public XfermodeView(Context context) {
        super(context);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        xFermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        mDSTpaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDSTpaint.setColor(0xFFFFCC44);
        mDSTpaint.setAlpha(255);

        mSrcBluePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mSrcBluePaint.setColor(0xFF66AAFF);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int sc = canvas.saveLayer(0, 0, canvas.getWidth(),canvas.getHeight(), null, Canvas.ALL_SAVE_FLAG);

        Bitmap mDstB = getCircleBitmap();
        Bitmap mSrcB = getRetangleBitmap();
        canvas.drawBitmap(mDstB, 0, 0, paint);
        paint.setXfermode(xFermode);
        canvas.drawBitmap(mSrcB, 0, 0, paint);
        paint.setXfermode(null);

        canvas.restoreToCount(sc);

//        int sc = canvas.saveLayer(0, 0, canvas.getWidth(),canvas.getHeight(), null, Canvas.ALL_SAVE_FLAG);
//        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        paint.setColor(0xFFFFCC44);
//        int r = canvas.getWidth() / 4;
//        canvas.drawCircle(r,r,r,paint);
//
//        Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(),canvas.getHeight(), Bitmap.Config.ARGB_8888);
//        Canvas mCanvas = new Canvas(bitmap);
////        paint.reset();
//        paint.setXfermode(xFermode);
//        paint.setColor(0xFF66AAFF);
//        mCanvas.drawRect(r,r,r*3,r*3,paint);
//
//        canvas.drawBitmap(bitmap,0,0,null);
//        paint.setXfermode(null);
//        canvas.restoreToCount(sc);


//    	int sc = canvas.saveLayer(0, 0, canvas.getWidth(), canvas.getHeight(), null, Canvas.ALL_SAVE_FLAG);//增加一个缓冲层
//        canvas.drawCircle(400,400,400,mDSTpaint);
//
//
//        Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
//        Canvas ca = new Canvas(bitmap);
//        ca.drawRect(400, 400, 800, 800, mSrcBluePaint);
//        //注意一下作用域~
//        mSrcBluePaint.setXfermode(xFermode);
//        canvas.drawBitmap(bitmap, 0, 0, mSrcBluePaint);
//        mSrcBluePaint.setXfermode(null);
//        canvas.restoreToCount(sc);

    }

    private Bitmap getRetangleBitmap() {
        /**
         * bm1 在bitmap上面画正方形
         */
        Bitmap rectangleBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c1 = new Canvas(rectangleBitmap);
        //c1.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFF66AAFF);
        c1.drawRect(400, 400, 1200, 1200, paint);
        return rectangleBitmap;
    }

    private Bitmap getCircleBitmap() {
        /**
         * bm 在bitmap上面画圆
         */
        Bitmap circleBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(circleBitmap);
        //c.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFFFFCC44);
        c.drawCircle(400, 400, 400, paint);
        return circleBitmap;
    }
}
