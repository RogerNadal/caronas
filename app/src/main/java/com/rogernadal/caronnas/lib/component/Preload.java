package com.rogernadal.caronnas.lib.component;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

import com.rogernadal.caronnas.R;

public class Preload extends Dialog
{
    public Preload(Context context)
    {
        super(context);
        setCancelable(false);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT) );
        setContentView(LayoutInflater.from(context).inflate(R.layout.preload, null));
    }
}