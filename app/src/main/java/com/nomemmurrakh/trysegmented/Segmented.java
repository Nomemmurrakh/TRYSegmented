package com.nomemmurrakh.trysegmented;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.List;

public class Segmented extends LinearLayout implements ToggleButton.OnToggledListener {

    private List<ToggleButton> buttons;
    private OnIndexChangedListener mListener;

    public interface OnIndexChangedListener{
        void onIndexChanged(int index);
    }

    public void setOnIndexChangedListener(OnIndexChangedListener listener){
        this.mListener = listener;
    }

    public Segmented(Context context) {
        super(context);
        this.setOrientation(HORIZONTAL);
    }

    public Segmented(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Segmented(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Segmented(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void addButtonsToContainer(final List<ToggleButton> buttons, float weight){
        this.buttons = buttons;
        LayoutParams params = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT,
                weight
        );
        for (ToggleButton button : buttons){
            button.setOnToggleListener(this);
            button.setLayoutParams(params);
            button.setText("Text Button");
            addView(button);
        }
    }

    @Override
    public void onToggle(View v) {
        for (int i = 0; i < buttons.size(); i++){
            ToggleButton button = buttons.get(i);
            if (((ToggleButton)v).equals(button)){
                button.setToggled(true);
                if (mListener != null){
                    mListener.onIndexChanged(i);
                }
            }else if (button.isToggled()) {
                button.setToggled(false);
            }
        }
    }
}
