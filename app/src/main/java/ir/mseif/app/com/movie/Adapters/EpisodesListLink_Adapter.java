package ir.mseif.app.com.movie.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.mseif.app.com.movie.Model.Episodes_List;
import ir.mseif.app.com.movie.Pages.MovieInfo;
import ir.mseif.app.com.movie.R;


public class EpisodesListLink_Adapter extends RecyclerView.Adapter<EpisodesListLink_Adapter.MyViewHolder> {

    private List<Episodes_List> episodes_lists;
    private Intent intent;

    public EpisodesListLink_Adapter(List<Episodes_List> episodes_lists) {
        this.episodes_lists = episodes_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcy_episode_link,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_link_quality.setText(episodes_lists.get(position).getQuality_name() + "");
        holder.txt_size_number.setText(episodes_lists.get(position).getEpisodes_size() + "");
        holder.txt_encoder_name.setText(episodes_lists.get(position).getEpisodes_encoder() + "");
        holder.txt_description.setText(episodes_lists.get(position).getEpisodes_description() + "");



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

        holder.btn_pakhsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return episodes_lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_link_quality , txt_size_number , txt_encoder_name , txt_description;
        Button btn_download,btn_sub,btn_pakhsh;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_link_quality = itemView.findViewById(R.id.txt_link_quality);
            txt_size_number = itemView.findViewById(R.id.txt_size_number);
            txt_encoder_name = itemView.findViewById(R.id.txt_encoder_name);
            txt_description = itemView.findViewById(R.id.txt_description);
            btn_download = itemView.findViewById(R.id.btn_download);
            btn_sub = itemView.findViewById(R.id.btn_sub);
            btn_pakhsh = itemView.findViewById(R.id.btn_pakhsh);

        }

    }

}