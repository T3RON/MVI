package ir.mseif.app.com.movie.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;
import ir.mseif.app.com.movie.Fruit;
import ir.mseif.app.com.movie.FruitCategory;
import ir.mseif.app.com.movie.R;

public class LinkFragmetSerial extends Fragment {

    ExpandableLayout expandableLayout;


    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab in you classes
        return inflater.inflate(R.layout.fragment_link_serial, container, false);
    }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // get the listview
        expandableLayout = (ExpandableLayout) view.findViewById(R.id.lvExp);

        expandableLayout.setRenderer(new ExpandableLayout.Renderer<FruitCategory, Fruit>() {
            @Override
            public void renderParent(View view, FruitCategory model, boolean isExpanded, int parentPosition) {
                ((TextView) view.findViewById(R.id.lblListHeader)).setText(model.name);
            }

            @Override
            public void renderChild(View view, Fruit model, int parentPosition, int childPosition) {
                ((TextView) view.findViewById(R.id.lblListItem)).setText(model.name);
            }
        });



        expandableLayout.addSection(getSection());
    }
    private Section<FruitCategory, Fruit> getSection() {
        Section<FruitCategory, Fruit> section = new Section<>();
        FruitCategory fruitCategory = new FruitCategory("Luna");

        List <Fruit> fruitList = new ArrayList<>();
        for(int i=1;i<=10;i++)
            fruitList.add(new Fruit("Luna"+i));

        section.parent = fruitCategory;
        section.children.addAll(fruitList);
        return section;
    }
}