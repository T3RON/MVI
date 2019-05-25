package ir.mseif.app.com.movie.Adapters;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ir.mseif.app.com.movie.Model.Movie_Link_List;
import ir.mseif.app.com.movie.R;


public class MovieLink_Adapter extends RecyclerView.Adapter<MovieLink_Adapter.MyViewHolder> {

    private List<Movie_Link_List> movie_link_lists;
    private Intent intent;

    public MovieLink_Adapter(List<Movie_Link_List> movie_link_lists) {
        this.movie_link_lists = movie_link_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcy_item_film_link,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_link_quality.setText(movie_link_lists.get(position).getQuality_name() + "");
        holder.txt_size.setText(movie_link_lists.get(position).getMovie_link_size() + "");
        holder.txt_encoder.setText(movie_link_lists.get(position).getEncoder_name() + "");

        holder.btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return movie_link_lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_link_quality , txt_size , txt_encoder;
        Button btn_sub , btn_download;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            txt_link_quality = itemView.findViewById(R.id.txt_link_quality);
            txt_size = itemView.findViewById(R.id.txt_size);
            txt_encoder = itemView.findViewById(R.id.txt_encoder);
            btn_download = itemView.findViewById(R.id.btn_download);
            btn_sub = itemView.findViewById(R.id.btn_sub);

        }

    }

}