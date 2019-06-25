package ir.mseif.app.com.movie.Adapters;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.mseif.app.com.movie.Model.Movie_List;
import ir.mseif.app.com.movie.Model.Season_List;
import ir.mseif.app.com.movie.Pages.MovieInfo;
import ir.mseif.app.com.movie.Pages.Serial_Episodes;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;


public class SeasonList_Adapter extends RecyclerView.Adapter<SeasonList_Adapter.MyViewHolder> {

    private List<Season_List> season_lists;

    public SeasonList_Adapter(List<Season_List> season_lists) {
        this.season_lists = season_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcy_season_link,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_season_name.setText(season_lists.get(position).getSeason_name() + "");
        holder.txt_season_number.setText(season_lists.get(position).getSeason_number() + "");


        holder.btn_season.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.context, Serial_Episodes.class);
                i.putExtra("series_id", season_lists.get(position).getSeries_id()+"");
                i.putExtra("season_id", season_lists.get(position).getSeason_id()+"");
                i.putExtra("season_name", season_lists.get(position).getSeason_name()+"");
                Global.SEASON_NAME = season_lists.get(position).getSeason_name();
                holder.context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return season_lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_season_name , txt_season_number;
        ViewGroup btn_season;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_season_name = itemView.findViewById(R.id.txt_season_name);
            txt_season_number = itemView.findViewById(R.id.txt_season_number);
            btn_season = itemView.findViewById(R.id.btn_season);

        }

    }

}