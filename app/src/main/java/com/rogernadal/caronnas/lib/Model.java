package com.rogernadal.caronnas.lib;

import android.app.Application;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

public abstract class Model extends Application
{
    private int id;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public boolean isNew(){ return (id==0); }
}
