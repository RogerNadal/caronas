package com.rogernadal.caronnas.lib.component;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

public abstract class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener
{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        return new TimePickerDialog(getActivity(), this, 0, 0, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onCancel(DialogInterface dialog)
    {
        super.onCancel(dialog);
        onCancelTime();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute)
    {
        String hour = (hourOfDay == 0)? "00" : (hourOfDay < 10)? "0" + hourOfDay : hourOfDay+"";
        String min  = (minute == 0)?    "00" : (minute < 10)?    "0" + minute    : minute+"";
        String time = hour+":"+min;
        onSelectTime(time);
    }

    public abstract void onSelectTime( String time );
    public abstract void onCancelTime();
}