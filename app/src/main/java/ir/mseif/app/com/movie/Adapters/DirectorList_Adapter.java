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

import ir.mseif.app.com.movie.Model.Director_List;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;


public class DirectorList_Adapter extends RecyclerView.Adapter<DirectorList_Adapter.MyViewHolder> {

    private List<Director_List> director_lists;
    private Intent intent;

    public DirectorList_Adapter(List<Director_List> director_lists) {
        this.director_lists = director_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_director,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_director_name.setText(director_lists.get(position).getDirector_name() + "");

        Glide.with(holder.context)
                .asBitmap()
                .load(Global.BASE_URL_UPLOADS + director_lists.get(position).getDirector_image())
                .into(holder.img_small_director);
//        holder.btn_movie.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(holder.context, MovieInfo.class);
//                Log.i("adapssss" , movie_lists.get(position).getMovie_id() + "");
//                i.putExtra("movie_id", movie_lists.get(position).getMovie_id()+"");
//                holder.context.startActivity(i);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return director_lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_director_name;
        ImageView img_small_director;
        ViewGroup btn_director;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_director_name = itemView.findViewById(R.id.txt_director_name);
            img_small_director = itemView.findViewById(R.id.img_small_director);
            btn_director = itemView.findViewById(R.id.btn_cast);

        }

    }

}