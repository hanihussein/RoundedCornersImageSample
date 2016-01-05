package com.hussein.hani.roundedcornersimagesample.lib;

/**
 * Created by hani hussein on 9/4/2015.
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.hussein.hani.roundedcornersimagesample.R;

public class RoundedCornersImageView extends ImageView {
    private Context mContext;
    private float roundedCorners = 5;


    public RoundedCornersImageView(Context context) {
        super(context);

        mContext = context;
    }

    public RoundedCornersImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);

    }

    public RoundedCornersImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, 0);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RoundedCornersImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(context, attrs, 0);

    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        mContext = context;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundedCornersImageView, 0, 0);

        try {

            roundedCorners = typedArray.getDimension(R.styleable.RoundedCornersImageView_corners, 0);

        } finally {

            typedArray.recycle();
        }
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        if (bm == null) return;
        setImageDrawable(new BitmapDrawable(mContext.getResources(),
                getRoundedCornerBitmap(bm, roundedCorners)));
    }


    @Override
    public void setImageDrawable(Drawable drawable) {

        if (mContext != null) {

            super.setImageDrawable(new BitmapDrawable(mContext.getResources(),
                    getRoundedCornerBitmap(((BitmapDrawable) drawable).getBitmap(), roundedCorners)));


        } else {
            super.setImageDrawable(drawable);

        }
    }


    /**
     * Creates a circular bitmap and uses whichever dimension is smaller to determine the width
     * <br/>Also constrains the circle to the leftmost part of the image
     *
     * @param bitmap
     * @return bitmap
     */
    public Bitmap getRoundedCornerBitmap(Bitmap bitmap, float pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }


}
