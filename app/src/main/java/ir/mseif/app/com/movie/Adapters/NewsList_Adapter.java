package ir.mseif.app.com.movie.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.mseif.app.com.movie.Model.News_List;
import ir.mseif.app.com.movie.Pages.News;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;


public class NewsList_Adapter extends RecyclerView.Adapter<NewsList_Adapter.MyViewHolder> {

    private List<News_List> news_lists;
    private Intent intent;

    public NewsList_Adapter(List<News_List> news_lists) {
        this.news_lists = news_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcy_trailer,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_title.setText(news_lists.get(position).getNews_name() + "");
//        holder.txt_year.setText(news_lists.get(position).getNews_date() + "");



        Picasso.with(holder.context).load(Global.BASE_URL_UPLOADS + news_lists.get(position).getNews_image()).fit().centerCrop()
                .into(holder.img_poster);


        holder.btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.context, News.class);
                i.putExtra("news_id", news_lists.get(position).getNews_id()+"");
                holder.context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return news_lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_year;
        TextView txt_title;
        ImageView img_poster;
        ViewGroup btn_news;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_year = itemView.findViewById(R.id.txt_year);
            txt_title = itemView.findViewById(R.id.txt_title);
            img_poster = itemView.findViewById(R.id.img_poster);
            btn_news = itemView.findViewById(R.id.btn_movie);

        }

    }

}