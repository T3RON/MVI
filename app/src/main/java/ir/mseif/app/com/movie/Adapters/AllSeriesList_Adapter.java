package ir.mseif.app.com.movie.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.mseif.app.com.movie.Model.Series_List;
import ir.mseif.app.com.movie.Pages.SerialInfo;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;


public class AllSeriesList_Adapter extends RecyclerView.Adapter<AllSeriesList_Adapter.MyViewHolder> {

    private List<Series_List> series_lists;
    private Intent intent;

    public AllSeriesList_Adapter(List<Series_List> series_lists) {
        this.series_lists = series_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcy_item_more_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_year.setText(series_lists.get(position).getSeries_year() + "");
        holder.txt_rate.setText(series_lists.get(position).getSeries_imdb() + "");

        Picasso.with(holder.context).load(Global.BASE_URL_UPLOADS + series_lists.get(position).getSeries_small_image()).fit().centerCrop()
                .into(holder.img_poster);

        holder.btn_more_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.context, SerialInfo.class);
                i.putExtra("series_id", series_lists.get(position).getSeries_id()+"");
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
        TextView txt_rate;
        ImageView img_poster;
        ViewGroup btn_more_info;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_year = itemView.findViewById(R.id.txt_year);
            txt_rate = itemView.findViewById(R.id.txt_rate);
            img_poster = itemView.findViewById(R.id.img_poster);
            btn_more_info = itemView.findViewById(R.id.btn_more_info);

        }

    }

    public void addImages(List<Series_List> ml) {
        for (Series_List im : ml) {
            series_lists.add(im);
        }
        notifyDataSetChanged();
    }

}