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

import ir.mseif.app.com.movie.Model.Episodes_List;
import ir.mseif.app.com.movie.Model.Movie_List;
import ir.mseif.app.com.movie.Pages.MovieInfo;
import ir.mseif.app.com.movie.Pages.Serial_Episode_Link;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;


public class EpisodesList_Adapter extends RecyclerView.Adapter<EpisodesList_Adapter.MyViewHolder> {

    private List<Episodes_List> episodes_lists;
    private Intent intent;

    public EpisodesList_Adapter(List<Episodes_List> episodes_lists) {
        this.episodes_lists = episodes_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcy_episode,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_episode_name.setText(episodes_lists.get(position).getEpisodes_name() + "");
        holder.txt_episode_number.setText(episodes_lists.get(position).getEpisodes_number() + "");



        holder.btn_episode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.context, Serial_Episode_Link.class);
                i.putExtra("episode_id", episodes_lists.get(position).getEpisodes_id()+"");
                Global.EPISODE_NAME = episodes_lists.get(position).getEpisodes_name();
                holder.context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return episodes_lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_episode_name , txt_episode_number;
        ViewGroup btn_episode;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_episode_name = itemView.findViewById(R.id.txt_episode_name);
            txt_episode_number = itemView.findViewById(R.id.txt_episode_number);
            btn_episode = itemView.findViewById(R.id.btn_episode);

        }

    }

}