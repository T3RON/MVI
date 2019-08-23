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


import com.squareup.picasso.Picasso;

import java.util.List;

import ir.mseif.app.com.movie.Model.Series_List;
import ir.mseif.app.com.movie.Pages.SerialInfo;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;


public class SeriesList_Adapter extends RecyclerView.Adapter<SeriesList_Adapter.MyViewHolder> {

    private List<Series_List> series_lists;
    private Intent intent;

    public SeriesList_Adapter(List<Series_List> series_lists) {
        this.series_lists = series_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcy_item_serial,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_title.setText(series_lists.get(position).getSeries_name() + "");
        holder.txt_year.setText(series_lists.get(position).getSeries_year() + "");
        holder.txt_rate.setText(series_lists.get(position).getSeries_imdb() + "");


        Picasso.with(holder.context).load(Global.BASE_URL_UPLOADS + series_lists.get(position).getSeries_small_image()).fit().centerCrop()
                .into(holder.img_poster);

        holder.btn_series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.context, SerialInfo.class);
                i.putExtra("series_id", series_lists.get(position).getSeries_id()+"");
                Global.SERIES_NAME = series_lists.get(position).getSeries_name();
                holder.context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return series_lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_year;
        TextView txt_title;
        TextView txt_rate;
        ImageView img_poster;
        ViewGroup btn_series;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_year = itemView.findViewById(R.id.txt_year);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_rate = itemView.findViewById(R.id.txt_rate);
            img_poster = itemView.findViewById(R.id.img_poster);
            btn_series = itemView.findViewById(R.id.btn_more_info);

        }

    }

}