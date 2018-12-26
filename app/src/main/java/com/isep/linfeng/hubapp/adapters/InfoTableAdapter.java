package com.isep.linfeng.hubapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isep.linfeng.database.entity.Transfer;
import com.isep.linfeng.hubapp.R;

import java.util.List;

public class InfoTableAdapter extends RecyclerView.Adapter<InfoTableAdapter.InfoTableViewHolder> {
    private Context context;
    private List<Transfer> data;
    public InfoTableAdapter(Context context,List<Transfer> data){
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public InfoTableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InfoTableViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.info_table_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull InfoTableViewHolder holder, int position) {
        holder.setContent(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class InfoTableViewHolder extends RecyclerView.ViewHolder{

        private AppCompatTextView tableTitleView;
        private AppCompatTextView tableSubtitleView;
        private AppCompatTextView tableContentView;

        InfoTableViewHolder(View itemView) {
            super(itemView);
            tableContentView = itemView.findViewById(R.id.table_content);
            tableTitleView = itemView.findViewById(R.id.table_title);
            tableSubtitleView = itemView.findViewById(R.id.table_subtitle);
        }

        void setContent(Transfer element){
            tableTitleView.setText(element.getName());
            tableSubtitleView.setText(element.getDuration());
            tableContentView.setText(element.getDate());
        }
    }
}
