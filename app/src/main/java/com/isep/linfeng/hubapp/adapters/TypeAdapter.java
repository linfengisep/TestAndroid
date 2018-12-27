package com.isep.linfeng.hubapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isep.linfeng.hubapp.R;

import java.util.List;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.TypeViewHolder> {
    private List<String> typeList;
    private Context context;
    public TypeAdapter(Context context,List<String> typeList){
        this.typeList = typeList;
        this.context = context;
    }
    @NonNull
    @Override
    public TypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TypeViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.type_select_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TypeViewHolder holder, int position) {
        holder.setContent(typeList.get(position));
    }

    @Override
    public int getItemCount() {
        return typeList.size();
    }

    class TypeViewHolder extends RecyclerView.ViewHolder{
        private AppCompatTextView typeView;
        private AppCompatButton typeBtn;
        private boolean isClicked=false;

        TypeViewHolder(View itemView) {
            super(itemView);
            typeView = itemView.findViewById(R.id.type_text);
            typeBtn = itemView.findViewById(R.id.type_button);
            typeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(isClicked){
                        typeBtn.setBackgroundResource(R.drawable.type_selection_btn_bg);
                        isClicked = false;
                    }else{
                        typeBtn.setBackgroundResource(R.drawable.type_selection_btn_bg_blue);
                        isClicked = true;
                    }
                }
            });
        }
        void setContent(String type){
            typeView.setText(type);
        }
    }
}
