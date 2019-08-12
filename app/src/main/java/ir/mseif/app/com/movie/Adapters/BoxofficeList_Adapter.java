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

import ir.mseif.app.com.movie.Model.Boxoffice_List;
import ir.mseif.app.com.movie.Model.News_List;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;


public class BoxofficeList_Adapter extends RecyclerView.Adapter<BoxofficeList_Adapter.MyViewHolder> {

    private List<Boxoffice_List> boxoffice_lists;
    private Intent intent;

    public BoxofficeList_Adapter(List<Boxoffice_List> boxoffice_lists) {
        this.boxoffice_lists = boxoffice_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcy_item_box_office,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_title.setText(boxoffice_lists.get(position).getBoxofice_name() + "");
        holder.txt_year.setText(boxoffice_lists.get(position).getBoxoffice_year() + "");
        holder.txt_rate.setText(boxoffice_lists.get(position).getBoxofice_rate() + "");
        holder.txt_sell.setText(boxoffice_lists.get(position).getBoxofice_gross() + "");
        holder.txt_week.setText(boxoffice_lists.get(position).getBoxofice_weeks() + "");
        Picasso.with(holder.context).load(Global.BASE_URL_UPLOADS + boxoffice_lists.get(position).getBoxofice_image()).fit().centerCrop()
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
        return boxoffice_lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_year;
        TextView txt_title;
        TextView txt_week;
        TextView txt_sell;
        TextView txt_rate;
        ImageView img_poster;
        ViewGroup btn_movie;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_year = itemView.findViewById(R.id.txt_year);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_week = itemView.findViewById(R.id.txt_week);
            txt_sell = itemView.findViewById(R.id.txt_sell);
            txt_rate = itemView.findViewById(R.id.txt_rate);
            img_poster = itemView.findViewById(R.id.img_poster);
            btn_movie = itemView.findViewById(R.id.btn_movie);

        }

    }

}