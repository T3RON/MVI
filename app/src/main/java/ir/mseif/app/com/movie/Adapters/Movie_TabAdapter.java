package ir.mseif.app.com.movie.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ir.mseif.app.com.movie.Fragments.CastFragment;
import ir.mseif.app.com.movie.Fragments.CommentsFragment;
import ir.mseif.app.com.movie.Fragments.LinkFragment;


public class Movie_TabAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public Movie_TabAdapter(FragmentManager fm, int tabCount) {
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
                LinkFragment linkFragment = new LinkFragment();
                return linkFragment;
            default:
                return null;
        }

    }


    @Override
    public int getCount() {
        return tabCount;
    }
}
