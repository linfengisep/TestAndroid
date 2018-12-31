package com.isep.linfeng.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class UserCardView extends ConstraintLayout {
    private SimpleDraweeView iconImageView;
    private AppCompatTextView titleView;
    private AppCompatTextView subtitleView;

    private String subtitleText;
    private String iconUrl;


    public UserCardView(Context context) {
        this(context, null);
    }

    public UserCardView(Context context, AttributeSet attrs) {
        this(context,attrs, 0);
    }

    public UserCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs, defStyle);
    }

    private void init(final Context context,AttributeSet attrs, int defStyle) {
        Fresco.initialize(context);
        inflate(getContext(), R.layout.user_card_view, this);

        iconImageView = findViewById(R.id.card_icon);
        titleView = findViewById(R.id.card_title_view);
        subtitleView = findViewById(R.id.card_subtitle_view);

        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.UserCardView, defStyle, 0);
        try{
            String titleText = a.getString(R.styleable.UserCardView_cardTitle);
            subtitleText = a.getString(R.styleable.UserCardView_cardSubtitle);
            iconUrl = a.getString(R.styleable.UserCardView_iconUrl);
            setTitle(titleText);
            setSubtitle(subtitleText);
            if (iconUrl != null) {
                setIconUrl(iconUrl);
            }
        }finally {
            a.recycle();
        }
    }

    public void setTitle(String title) {
        titleView.setText(title);
        redrawView();
    }

    public void setSubtitle(String subtitle) {
        this.subtitleText = subtitle;
        this.subtitleView.setText(subtitle);
        redrawView();
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        iconImageView.setImageURI(iconUrl);
    }

    private void redrawView() {
        requestLayout();
        invalidate();
    }
}
