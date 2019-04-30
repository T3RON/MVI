package ir.mseif.app.com.movie.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ir.mseif.app.com.movie.Fragments.CastFragment;
import ir.mseif.app.com.movie.Fragments.CommentsFragment;
import ir.mseif.app.com.movie.Fragments.LinkFragmetSerial;

public class Series_TabAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public Series_TabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount= tabCount;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CommentsFragment commentsFragment = new CommentsFragment();
                return commentsFragment;
            case 1:
                CastFragment castFragment = new CastFragment();
                return castFragment;
            case 2:
                LinkFragmetSerial LinkFragmetSerial = new LinkFragmetSerial();
                return LinkFragmetSerial;
            default:
                return null;
        }

    }


    @Override
    public int getCount() {
        return tabCount;
    }
}
