package com.isep.linfeng.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class HubItemView extends ConstraintLayout {
    private AppCompatTextView titleView;
    private AppCompatTextView subtitleView;
    private AppCompatTextView contentView;
    private AppCompatTextView timeView;

    private AppCompatImageView iconView;
    private AppCompatImageView starView;
    private AppCompatImageView arrowView;
    private String title,subtitle,content,time;


    @DrawableRes
    private int iconImage;
    @DrawableRes
    private int starImage;
    @DrawableRes
    private int arrowImage;

    public HubItemView(Context context) {
        this(context,null);
    }

    public HubItemView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public HubItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(attrs !=null){
            initView(attrs);
        }
    }

    private void initView(AttributeSet attrs){
        inflate(getContext(),R.layout.hub_item_view,this);
        titleView = findViewById(R.id.hub_item_title);
        subtitleView = findViewById(R.id.hub_item_subtitle);
        contentView = findViewById(R.id.hub_item_content);
        timeView = findViewById(R.id.hub_item_time_label);
        iconView = findViewById(R.id.hub_item_icon);
        starView = findViewById(R.id.hub_item_star);
        arrowView = findViewById(R.id.hub_item_arrow);
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs,R.styleable.HubItemView,0,0);
        try{
            title = typedArray.getString(R.styleable.HubItemView_title);
            subtitle = typedArray.getString(R.styleable.HubItemView_subtitle);
            content = typedArray.getString(R.styleable.HubItemView_hubContent);
            time = typedArray.getString(R.styleable.HubItemView_time);
            this.titleView.setText(title);
            this.subtitleView.setText(subtitle);
            this.contentView.setText(content);
            this.timeView.setText(time);

            setIconImage(iconImage);
            setArrowImage(arrowImage);
            setStarImage(starImage);
        }finally {
            typedArray.recycle();
        }
    }

    private void redrawView() {
        requestLayout();
        invalidate();
    }

    public void setTitle(String title) {
        this.title = title;
        this.titleView.setText(title);
        redrawView();
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
        this.subtitleView.setText(subtitle);
        redrawView();
    }

    public void setContent(String content) {
        this.content = content;
        this.contentView.setText(content);
        redrawView();
    }

    public void setTime(String time) {
        this.time = time;
        this.timeView.setText(time);
        redrawView();
    }

    private void setIconImage(int icon){
        this.iconImage = icon;
        iconView.setImageResource(icon);
        redrawView();
    }

    private void setStarImage(int star){
        this.starImage = star;
        starView.setImageResource(star);
        redrawView();
    }

    private void setArrowImage(int arrow){
        this.arrowImage = arrow;
        arrowView.setImageResource(arrow);
        redrawView();
    }
}
