package ir.mseif.app.com.movie.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import ir.mseif.app.com.movie.R;

public class DownloaderAdapter extends RecyclerView.Adapter<DownloaderAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Map<String, String>> downloadsInfo;
    public EventListener eventListener;

    public DownloaderAdapter(Context context, List<Map<String, String>> downloadsInfo) {
        inflater = LayoutInflater.from(context);
        this.downloadsInfo = downloadsInfo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rcy_item_downloader, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(downloadsInfo.get(position).get("title"));
        holder.progress.setText(downloadsInfo.get(position).get("progress") + "%");

    }

    @Override
    public int getItemCount() {
        return downloadsInfo.size();
    }

    public void setOnClickListener(EventListener listener) {
        this.eventListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, eta, progress;
        ConstraintLayout layout;
        ImageButton play;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txt_movie_name);
            eta = itemView.findViewById(R.id.txt_time_to_end);
            progress = itemView.findViewById(R.id.txt_percentage);
            layout = itemView.findViewById(R.id.rcy_item_layout);
            play = itemView.findViewById(R.id.btn_play);


            layout.setOnClickListener(v -> eventListener.onSelect(v, getAdapterPosition()));
            play.setOnClickListener(v -> eventListener.onPlay(v, getAdapterPosition()));

        }

    }


    public interface EventListener {

        void onSelect(View v, int position);
        void onPlay(View v, int position);

    }

}
