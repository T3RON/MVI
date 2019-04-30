package ir.mseif.app.com.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class m extends AppCompatActivity {

    @BindView(R.id.button)
    LinearLayout button_2;
    @BindView(R.id.constraintLayout_55)
    LinearLayout button;
    @BindView(R.id.view2) View  view_11;
    @BindView(R.id.view3) View  view_12;

//    HashMap<Integer, String> season = new HashMap<>();
//    HashMap<Integer, String> episode = new HashMap<>();
//    HashMap<Integer, String> quality = new HashMap<>();
//    HashMap<Integer, String> link = new HashMap<>();




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
        ButterKnife.bind(this);




    }


    public void view_1 (View view) {
        if(button.getVisibility() != View.VISIBLE){
            button.setVisibility(View.VISIBLE);
        }
        else{
            button.setVisibility(View.GONE);
            Toast.makeText(getBaseContext(), ("Im here baby :)"),
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void view_2 (View view) {
        if(button_2.getVisibility() != View.VISIBLE){
            button_2.setVisibility(View.VISIBLE);
        }
        else{
            button_2.setVisibility(View.GONE);
            Toast.makeText(getBaseContext(), ("Im here baby :)"),
                    Toast.LENGTH_SHORT).show();
        }
    }
}