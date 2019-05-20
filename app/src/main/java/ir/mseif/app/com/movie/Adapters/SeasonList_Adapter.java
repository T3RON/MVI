package ir.mseif.app.com.movie.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ir.mseif.app.com.movie.Model.Movie_List;
import ir.mseif.app.com.movie.Pages.MovieInfo;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;


public class SeasonList_Adapter extends RecyclerView.Adapter<SeasonList_Adapter.MyViewHolder> {

    private List<Movie_List> movie_lists;
    private Intent intent;

    public SeasonList_Adapter(List<Movie_List> movie_lists) {
        this.movie_lists = movie_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcy_item_film,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_title.setText(movie_lists.get(position).getMovie_name() + "");
        holder.txt_year.setText(movie_lists.get(position).getMovie_year() + "");
        holder.txt_rate.setText(movie_lists.get(position).getMovie_imdb() + "");

        Glide.with(holder.context)
                .asBitmap()
                .load(Global.BASE_URL_UPLOADS + movie_lists.get(position).getMovie_small_image())
                .into(holder.img_poster);
        holder.btn_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.context, MovieInfo.class);
                Log.i("adapssss" , movie_lists.get(position).getMovie_id() + "");
                i.putExtra("movie_id", movie_lists.get(position).getMovie_id()+"");
                holder.context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movie_lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_year;
        TextView txt_title;
        TextView txt_rate;
        ImageView img_poster;
        ViewGroup btn_movie;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_year = itemView.findViewById(R.id.txt_year);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_rate = itemView.findViewById(R.id.txt_rate);
            img_poster = itemView.findViewById(R.id.img_poster);
            btn_movie = itemView.findViewById(R.id.btn_movie);

        }

    }

}