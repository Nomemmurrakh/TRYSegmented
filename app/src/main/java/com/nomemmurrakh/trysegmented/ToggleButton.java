package com.nomemmurrakh.trysegmented;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ToggleButton extends androidx.appcompat.widget.AppCompatButton {

    private boolean isToggled;
    private OnToggledListener mListener;
    private ToggleButton mButton = this;

    public interface OnToggledListener{
        void onToggle(View v);
    }

    public void setOnToggleListener(OnToggledListener listener){
        this.mListener = listener;
    }

    public ToggleButton(@NonNull Context context) {
        super(context);
        isToggled = false;
        mButton.setBackgroundResource(R.color.colorPrimary);
        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isToggled){
                    if (mListener != null){
                        mListener.onToggle(v);
                    }
                }
            }
        });
    }

    public ToggleButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ToggleButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isToggled() {
        return isToggled;
    }

    public void setToggled(boolean toggled) {
        isToggled = toggled;

        if (toggled) {
            mButton.setBackgroundColor(Color.BLUE);
        } else {
            mButton.setBackgroundResource(R.color.colorPrimary);
        }
    }
}
