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

import ir.mseif.app.com.movie.Model.Trailer_List;
import ir.mseif.app.com.movie.Pages.Player;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcy_trailer,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_title.setText(trailer_lists.get(position).getTrailer_name() + "");
        holder.txt_year.setText(trailer_lists.get(position).getTrailer_year() + "");



        Picasso.with(holder.context).load(Global.BASE_URL_UPLOADS + trailer_lists.get(position).getTrailer_image()).fit().centerCrop()
                .into(holder.img_poster);


        holder.btn_show_trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.context, Player.class);
                i.putExtra("trailer_id", trailer_lists.get(position).getTrailer_id()+"");
                Log.i("sdasdasdasdas",trailer_lists.get(position).getTrailer_id()+"");
                holder.context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trailer_lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_year;
        TextView txt_title;
        ImageView img_poster;
        ViewGroup btn_show_trailer;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_year = itemView.findViewById(R.id.txt_year);
            txt_title = itemView.findViewById(R.id.txt_title);
            img_poster = itemView.findViewById(R.id.img_poster);
            btn_show_trailer = itemView.findViewById(R.id.btn_show_trailer);

        }

    }

}