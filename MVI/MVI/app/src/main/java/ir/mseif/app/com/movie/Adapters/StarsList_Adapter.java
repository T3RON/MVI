package ir.mseif.app.com.movie.Adapters;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ir.mseif.app.com.movie.Model.Stars_List;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;


public class StarsList_Adapter extends RecyclerView.Adapter<StarsList_Adapter.MyViewHolder> {

    private List<Stars_List> stars_lists;
    private Intent intent;

    public StarsList_Adapter(List<Stars_List> stars_lists) {
        this.stars_lists = stars_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stars,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_stars_name.setText(stars_lists.get(position).getStars_name() + "");

        Glide.with(holder.context)
                .asBitmap()
                .load(Global.BASE_URL_UPLOADS + stars_lists.get(position).getStars_image())
                .into(holder.img_small_stars);
//        holder.btn_movie.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(holder.context, MovieInfo.class);
//                Log.i("adapssss" , movie_lists.get(position).getMovie_id() + "");
//                i.putExtra("movie_id", movie_lists.get(position).getMovie_id()+"");
//                holder.context.startActivity(i);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return stars_lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_stars_name;
        ImageView img_small_stars;
        ViewGroup btn_stars;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_stars_name = itemView.findViewById(R.id.txt_stars_name);
            img_small_stars = itemView.findViewById(R.id.img_small_stars);
            btn_stars = itemView.findViewById(R.id.btn_stars);

        }

    }

}