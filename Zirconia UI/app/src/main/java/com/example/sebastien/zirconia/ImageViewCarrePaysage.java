package com.example.sebastien.zirconia;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by sebastien on 18-02-28.
 */

public class ImageViewCarrePaysage extends android.support.v7.widget.AppCompatImageView {

    public ImageViewCarrePaysage(Context context) {
        super(context);
    }

    public ImageViewCarrePaysage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageViewCarrePaysage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(heightMeasureSpec, heightMeasureSpec);
    }


}