package com.isep.linfeng.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TypeSelectionView extends ConstraintLayout {
    private AppCompatTextView typeView;
    private AppCompatButton btnView;
    private String type;

    public TypeSelectionView(Context context) {
        this(context, null);
    }

    public TypeSelectionView(Context context, AttributeSet attrs) {
        this(context,attrs, 0);
    }

    public TypeSelectionView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if(attrs !=null){
            init(attrs,defStyle);
        }
    }

    private void init(AttributeSet attrs,int defStyle) {
        inflate(getContext(), R.layout.type_selection_view, this);

        typeView = findViewById(R.id.type_text);
        btnView = findViewById(R.id.type_button);

        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.TypeSelectionView, defStyle, 0);
        try{
            type = a.getString(R.styleable.TypeSelectionView_typeText);
            setType(type);
        }finally {
            a.recycle();
        }
    }


    public void setType(String type) {
        this.type = type;
        typeView.setText(type);
        redrawView();
    }

    private void redrawView() {
        requestLayout();
        invalidate();
    }
}
