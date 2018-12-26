package com.isep.linfeng.hubapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.isep.linfeng.custom_views.HubItemView;
import com.isep.linfeng.database.entity.Hub;
import com.isep.linfeng.hubapp.R;
import java.util.List;


public class HubRecyclerViewAdapter extends RecyclerView.Adapter<HubRecyclerViewAdapter.HubViewHolder> {
    private List<Hub> hubList;
    private Context context;
    private HubItemClickListener hubItemClicklistener;

    public HubRecyclerViewAdapter(List<Hub> data, Context context,HubItemClickListener listener) {
        this.hubList = data;
        this.context = context;
        this.hubItemClicklistener = listener;
    }

    public interface HubItemClickListener{
        void onHubItemClick(int hubIndex);
    }

    @NonNull
    @Override
    public HubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HubViewHolder(LayoutInflater.from(context).inflate(R.layout.hub_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HubViewHolder holder, int position) {
        holder.setContent(hubList.get(position));
    }

    @Override
    public int getItemCount() {
        return hubList.size();
    }

    class HubViewHolder extends RecyclerView.ViewHolder{

        private AppCompatImageView hubItemIconView;
        private AppCompatImageView hubItemStarView;
        private AppCompatImageView hubItemArrowView;

        private AppCompatTextView hubItemTitleView;
        private AppCompatTextView hubItemSubtitleView;
        private AppCompatTextView hubItemContentView;
        private AppCompatTextView hubItemTimeView;

        HubViewHolder(View itemView) {
            super(itemView);
            hubItemTitleView = itemView.findViewById(R.id.hub_item_title);
            hubItemSubtitleView = itemView.findViewById(R.id.hub_item_subtitle);
            hubItemContentView = itemView.findViewById(R.id.hub_item_content);
            hubItemTimeView = itemView.findViewById(R.id.hub_item_time_label);

            hubItemIconView = itemView.findViewById(R.id.hub_item_icon);
            hubItemStarView = itemView.findViewById(R.id.hub_item_star);
            hubItemArrowView = itemView.findViewById(R.id.hub_item_arrow);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hubItemClicklistener.onHubItemClick(getAdapterPosition());
                }
            });
        }

        private void setContent(Hub hub){
            hubItemTitleView.setText(hub.getTitle());
            hubItemSubtitleView.setText(hub.getSubTitle());
            hubItemContentView.setText(hub.getContent());
            hubItemTimeView.setText(hub.getTime());

            hubItemIconView.setImageResource(getItemType(hub.getMessageType()));
            hubItemStarView.setImageResource(hub.getIsStar()? R.drawable.ic_star_yellow:R.drawable.ic_star_border);
            hubItemArrowView.setImageResource(R.drawable.ic_arrow_right);
        }

        private int getItemType(String typeInfo) {
            String type = typeInfo.trim().toUpperCase();
            switch (type) {
                case "INCOMING":
                    return R.drawable.ic_call_received;
                case "OUTGOING":
                    return R.drawable.ic_call_made;
                case "MISSED":
                    return R.drawable.ic_call_missed;
                case "SMS":
                    return R.drawable.ic_message;
                default:
                    return 0;
            }
        }
    }
}
