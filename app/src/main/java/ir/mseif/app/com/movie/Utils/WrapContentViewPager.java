package ir.mseif.app.com.movie.Utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import android.util.AttributeSet;
import android.view.View;


public class WrapContentViewPager extends ViewPager {

    public WrapContentViewPager(@NonNull Context context) {
        super(context);
    }

    public WrapContentViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        try {
            int numChildren = getChildCount();
            for (int i = 0; i < numChildren; i++) {
                View child = getChildAt(i);
                if (child != null) {
                    child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                    int h = child.getMeasuredHeight();
                    heightMeasureSpec = Math.max(heightMeasureSpec, MeasureSpec.makeMeasureSpec(h, MeasureSpec.EXACTLY));
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

