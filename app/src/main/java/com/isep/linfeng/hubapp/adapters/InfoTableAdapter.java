package com.isep.linfeng.hubapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isep.linfeng.custom_views.InfoTableView;
import com.isep.linfeng.database.entity.Transfer;
import com.isep.linfeng.hubapp.R;

import java.util.List;
import java.util.Locale;

public class InfoTableAdapter extends RecyclerView.Adapter<InfoTableAdapter.InfoTableViewHolder> {
    private Context context;
    private List<Transfer> data;
    private boolean isPointVisible;
    private int size;

    public InfoTableAdapter(Context context,List<Transfer> data,boolean isPointVisible,int size){
        this.context = context;
        this.data = data;
        this.isPointVisible = isPointVisible;
        this.size = size;
    }
    @NonNull
    @Override
    public InfoTableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InfoTableViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.info_table_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull InfoTableViewHolder holder, int position) {
        holder.setContent(data.get(position),data.size()-position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class InfoTableViewHolder extends RecyclerView.ViewHolder{

        private AppCompatTextView tableTitleView;
        private AppCompatTextView tableSubtitleView;
        private AppCompatTextView tableContentView;
        private AppCompatButton tablePointView;
        private InfoTableView infoTableView;

        InfoTableViewHolder(View itemView) {
            super(itemView);
            tableContentView = itemView.findViewById(R.id.table_content);
            tableTitleView = itemView.findViewById(R.id.table_title);
            tableSubtitleView = itemView.findViewById(R.id.table_subtitle);
            tablePointView = itemView.findViewById(R.id.table_point);
            infoTableView = itemView.findViewById(R.id.info_table);
        }

        void setContent(Transfer element,int position){
            tableTitleView.setText(element.getName());
            tableSubtitleView.setText(element.getDuration());
            tableContentView.setText(element.getDate());
            tablePointView.setVisibility(isPointVisible? View.VISIBLE:View.INVISIBLE);
            if(size !=0){
                infoTableView.setPoint(String.format(Locale.getDefault(),"%d",position),View.VISIBLE,size);
            }
        }
    }
}
