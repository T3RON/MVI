package ir.mseif.app.com.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;

public class m extends AppCompatActivity {

    ExpandableLayout expandableLayout;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        // get the listview
        expandableLayout = (ExpandableLayout) findViewById(R.id.lvExp);

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