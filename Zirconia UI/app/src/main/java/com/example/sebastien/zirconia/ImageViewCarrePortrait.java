package com.example.sebastien.zirconia;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by sebastien on 18-02-28.
 */

public class ImageViewCarrePortrait extends android.support.v7.widget.AppCompatImageView {

    public ImageViewCarrePortrait(Context context) {
        super(context);
    }

    public ImageViewCarrePortrait(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageViewCarrePortrait(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }


}