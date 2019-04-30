package ir.mseif.app.com.movie.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ir.mseif.app.com.movie.Model.Series_List;
import ir.mseif.app.com.movie.Model.Trailer_List;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;


public class TrailerList_Adapter extends RecyclerView.Adapter<TrailerList_Adapter.MyViewHolder> {

    private List<Trailer_List> trailer_lists;
    private Intent intent;

    public TrailerList_Adapter(List<Trailer_List> trailer_lists) {
        this.trailer_lists = trailer_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcy_item_serial,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_title.setText(trailer_lists.get(position).getTrailer_name() + "");
        holder.txt_year.setText(trailer_lists.get(position).getTrailer_year() + "");
        holder.txt_rate.setVisibility(View.GONE);

        Glide.with(holder.context)
                .asBitmap()
                .load(Global.BASE_URL_UPLOADS + trailer_lists.get(position).getTrailer_image())
                .into(holder.img_poster);
//        holder.btn_pick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(holder.context, Agahi_info.class);
//                i.putExtra("agahi_id", agahi_models.get(position).getAgahi_id());
//                holder.context.startActivity(i);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return trailer_lists.size();
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