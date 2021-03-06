package com.xiangchao.demo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

import com.xiangchao.demo.R;


public class NineGridViewWrapper extends ImageView {

    private int moreNum = 0;              //显示更多的数量
    private int maskColor = 0x88000000;   //默认的遮盖颜色
    private float textSize = 35;          //显示文字的大小单位sp
    private int textColor = 0xFFFFFFFF;   //显示文字的颜色

    private TextPaint textPaint;              //文字的画笔
    private String msg = "";                  //要绘制的文字

    private boolean mIsGif;                   //是否GIF样式
    private boolean mIsVideo;                 //是否视频样式

    public NineGridViewWrapper(Context context) {
        this(context, null);
    }

    public NineGridViewWrapper(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NineGridViewWrapper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //转化单位
        textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, textSize, getContext().getResources().getDisplayMetrics());

        textPaint = new TextPaint();
        textPaint.setTextAlign(Paint.Align.CENTER);  //文字居中对齐
        textPaint.setAntiAlias(true);                //抗锯齿
        textPaint.setTextSize(textSize);             //设置文字大小
        textPaint.setColor(textColor);               //设置文字颜色
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mIsVideo) {
            // 播放按钮
            Bitmap bmpPlay = BitmapFactory.decodeResource(this.getContext().getResources(), R.mipmap.ic_play);
            canvas.drawBitmap(bmpPlay, (getWidth() - bmpPlay.getWidth()) / 2, (getHeight() - bmpPlay.getHeight()) / 2, textPaint);
        }
        if (mIsGif) {
            // 播放按钮
            Bitmap bmpPlay = BitmapFactory.decodeResource(this.getContext().getResources(), R.mipmap.ic_gif);
            canvas.drawBitmap(bmpPlay, getWidth() - bmpPlay.getWidth(), getHeight() - bmpPlay.getHeight(), textPaint);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setImageDrawable(null);
    }

    /**
     * 是否gif图片
     *
     * @param mIsGif
     */
    public void setIsGif(boolean mIsGif) {
        this.mIsGif = mIsGif;
    }

    /**
     * 是否视频样式
     *
     * @param isVideo
     */
    public void setIsVideo(boolean isVideo) {
        this.mIsVideo = isVideo;
    }

    public int getMoreNum() {
        return moreNum;
    }

    public void setMoreNum(int moreNum) {
        this.moreNum = moreNum;
        msg = "+" + moreNum;
        invalidate();
    }

    public int getMaskColor() {
        return maskColor;
    }

    public void setMaskColor(int maskColor) {
        this.maskColor = maskColor;
        invalidate();
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
        textPaint.setTextSize(textSize);
        invalidate();
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        textPaint.setColor(textColor);
        invalidate();
    }
}