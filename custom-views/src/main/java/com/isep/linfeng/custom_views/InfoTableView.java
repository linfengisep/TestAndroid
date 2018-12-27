package com.isep.linfeng.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.isep.linfeng.custom_views.Utils.DpUtil;

public class InfoTableView extends ConstraintLayout {

    private AppCompatTextView tableTitleView;
    private AppCompatTextView tableSubtitleView;
    private AppCompatTextView tableContentView;
    private AppCompatTextView tablePointView;
    private String title,subtitle,content,number;

    public InfoTableView(Context context) {
        this(context, null);
    }

    public InfoTableView(Context context, AttributeSet attrs) {
        this(context,attrs, 0);
    }

    public InfoTableView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if(attrs !=null){
            init(attrs,defStyle);
        }
    }

    private void init(AttributeSet attrs,int defStyle) {
        inflate(getContext(), R.layout.info_table_view, this);

        tableTitleView = findViewById(R.id.table_title);
        tableSubtitleView = findViewById(R.id.table_subtitle);
        tableContentView = findViewById(R.id.table_content);
        tablePointView = findViewById(R.id.table_point);

        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.InfoTableView, defStyle, 0);
        try{
            title = a.getString(R.styleable.InfoTableView_tableTitle);
            subtitle = a.getString(R.styleable.InfoTableView_tableSubtitle);
            content = a.getString(R.styleable.InfoTableView_tableContent);
            number = a.getString(R.styleable.InfoTableView_tablePoint);
            setTitle(title);
            setSubtitle(subtitle);
            setContent(content);
        }finally {
            a.recycle();
        }
    }


    public void setTitle(String title) {
        this.title = title;
        tableTitleView.setText(title);
        redrawView();
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
        this.tableSubtitleView.setText(subtitle);
        redrawView();
    }
    public void setContent(String content){
        this.content = content;
        this.tableContentView.setText(content);
        redrawView();
    }

    public void setPoint(String number,int visibility,int size){
        int dpSize = DpUtil.dpToPixel(size,getContext());
        this.number = number;
        this.tablePointView.setVisibility(visibility);
        this.tablePointView.setText(number);
        ViewGroup.LayoutParams params = this.tablePointView.getLayoutParams();
        params.height = dpSize;
        params.width = dpSize;
        this.setLayoutParams(params);
    }
    private void redrawView() {
        requestLayout();
        invalidate();
    }
}
