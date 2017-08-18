package com.rogernadal.caronnas.lib.component;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rogernadal.caronnas.R;

import static android.view.View.inflate;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

public class Message
{
    public static void info(Context context, int message)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void info(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void confirm(Context context, String title, String msg, final Action action)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                action.onPositiveButton();
            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                action.onNegativeButton();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void confirm(Context context, int title, int msg, final Action action)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                action.onPositiveButton();
            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                action.onNegativeButton();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static abstract class Action
    {
        public abstract void onPositiveButton();
        public abstract void onNegativeButton();
    }

    public static abstract class ActionPrompt
    {
        public abstract void onPositiveButton(String input);
        public abstract void onNegativeButton();
    }
}
