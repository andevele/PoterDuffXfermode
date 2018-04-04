package com.zhulf.www.poterduffxfermode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/4/4.
 */

public class LayerView extends View {
    private Paint mPaint;
    private Xfermode mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    private static int LAYER_FLAGS = Canvas.MATRIX_SAVE_FLAG | Canvas.CLIP_SAVE_FLAG
            | Canvas.HAS_ALPHA_LAYER_SAVE_FLAG | Canvas.FULL_COLOR_LAYER_SAVE_FLAG
            | Canvas.CLIP_TO_LAYER_SAVE_FLAG;

    public LayerView(Context context) {
        super(context);
    }

    public LayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
//        canvas.translate(10, 10);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(300, 300, 250, mPaint);
        mPaint.setXfermode(mXfermode);
//        canvas.saveLayerAlpha(0, 0, 800, 800, 0x88, Canvas.ALL_SAVE_FLAG);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(450, 450, 250, mPaint);
        mPaint.setXfermode(null);
//        canvas.restore();
    }
}
