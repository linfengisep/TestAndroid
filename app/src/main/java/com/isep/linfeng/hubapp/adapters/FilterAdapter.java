package com.isep.linfeng.hubapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isep.linfeng.hubapp.R;

import java.util.List;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder> {
    private List<String> dataset;
    private Context context;
    public FilterAdapter(List<String> dataset,Context context) {
        this.dataset = dataset;
        this.context = context;
    }
    @NonNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FilterViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.filter_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilterViewHolder holder, int position) {
        holder.setContent(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    class FilterViewHolder extends RecyclerView.ViewHolder{
        private AppCompatButton filterItemView;

        FilterViewHolder(View itemView) {
            super(itemView);
            filterItemView = itemView.findViewById(R.id.filter_item);
        }

        void setContent(String content){
            filterItemView.setText(content);
        }
    }
}
