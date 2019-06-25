package ir.mseif.app.com.movie.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.mseif.app.com.movie.Model.Comments_List;
import ir.mseif.app.com.movie.R;


public class CommentsList_Adapter extends RecyclerView.Adapter<CommentsList_Adapter.MyViewHolder> {

    private List<Comments_List> comments_lists;
    private Intent intent;

    public CommentsList_Adapter(List<Comments_List> comments_lists) {
        this.comments_lists = comments_lists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txt_comment.setText(comments_lists.get(position).getComments_text() + "");


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
        return comments_lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_comment;

        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_comment = itemView.findViewById(R.id.txt_comment);

        }

    }

}