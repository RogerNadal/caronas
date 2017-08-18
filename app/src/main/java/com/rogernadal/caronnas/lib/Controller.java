package com.rogernadal.caronnas.lib;

import android.content.Context;

import java.util.List;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

public class Controller<M extends Model, T extends DBController<M>>
{
    public T db;
    private static Controller controller;
    private static Context    context;

    public Controller(T db)
    {
        this.db = db;
    }

    public List<M> list(Criteria criteria) throws Exception
    {
        return db.list(criteria);
    }

    public List<M> list() throws Exception
    {
        return db.list();
    }

    public M get(int id)  throws Exception
    {
        return db.get(id);
    }

    public boolean store(M obj)  throws Exception
    {
        return db.store(obj);
    }

    public void delete(int id)  throws Exception
    {
        db.delete(id);
    }

    public void deleteFilter(Criteria criteria) throws Exception
    {
        List<M> objects =  (criteria != null)? this.list(criteria):this.list();

        if(objects != null)
        {
            for (M object : objects)
            {
                this.delete(object.getId());
            }
        }
    }
}
