package com.mine.newsapp2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlaylistAdapter
    extends RecyclerView.Adapter<PlaylistAdapter.VH> {

    private final List<PlaylistItem> items;

    public PlaylistAdapter(List<PlaylistItem> items) {
        this.items = items;
    }

    /** Replace data & refresh UI */
    public void setItems(List<PlaylistItem> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_playlist, parent, false);
        return new VH(v);
    }

    @Override public void onBindViewHolder(@NonNull VH holder, int pos) {
        PlaylistItem it = items.get(pos);
        holder.tvUrl.setText(it.getUrl());

        holder.itemView.setOnClickListener(v -> {
            String url = it.getUrl();
            String id  = url.substring(url.indexOf("v=") + 2);
            holder.itemView.getContext().startActivity(
                new Intent(holder.itemView.getContext(), VideoPlayerActivity.class)
                    .putExtra("videoId", id)
            );
        });
    }

    @Override public int getItemCount() {
        return items.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvUrl;
        VH(@NonNull View itemView) {
            super(itemView);
            tvUrl = itemView.findViewById(R.id.tvUrl);
        }
    }
}
