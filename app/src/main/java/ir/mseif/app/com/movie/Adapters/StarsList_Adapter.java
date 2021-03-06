package ir.mseif.app.com.movie.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.mseif.app.com.movie.Model.Stars_List;
import ir.mseif.app.com.movie.Pages.MovieInfo;
import ir.mseif.app.com.movie.Pages.PersonInfo;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;


public class StarsList_Adapter extends RecyclerView.Adapter<StarsList_Adapter.MyViewHolder> {

    private List<Stars_List> starsLists;
    private Intent intent;

    public StarsList_Adapter(List<Stars_List> starsLists) {
        this.starsLists = starsLists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stars,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_title.setText(starsLists.get(position).getStars_name());

        Log.i("Sdasdsa",starsLists.get(position).getStars_name());


        Picasso.with(holder.context).load(Global.BASE_URL_UPLOADS + starsLists.get(position).getStars_image()).fit().centerCrop()
                .into(holder.img_poster);

        holder.btn_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.context, PersonInfo.class);
                i.putExtra("person_id", starsLists.get(position).getStars_id()+"");
                holder.context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return starsLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_title;
        ImageView img_poster;
        ViewGroup btn_movie;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_title = itemView.findViewById(R.id.txt_title);
            img_poster = itemView.findViewById(R.id.img_poster);
            btn_movie = itemView.findViewById(R.id.btn_movie);

        }

    }

}