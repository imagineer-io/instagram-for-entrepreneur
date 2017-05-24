package io.imagineer.instagramclone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by marco on 5/25/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ThumbnailItem> mThumbnailItems;

    public RecyclerAdapter(List<ThumbnailItem> thumbnailItems) {
        mThumbnailItems = thumbnailItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.list_thumbnail_item, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ThumbnailItem thumbnailItem = mThumbnailItems.get(position);
        RecyclerViewHolder viewHolder = (RecyclerViewHolder) holder;
        viewHolder.thumbnail.setImageBitmap(thumbnailItem.image);
        viewHolder.thumbnail.setScaleType(ImageView.ScaleType.FIT_START);
    }

    @Override
    public int getItemCount() {
        return mThumbnailItems.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView thumbnail;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }
}
