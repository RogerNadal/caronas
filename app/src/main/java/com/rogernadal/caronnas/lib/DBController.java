package com.rogernadal.caronnas.lib;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

public abstract class DBController<T extends Model> extends DataBase
{
    protected String  TABELA;
    protected String  COLUMNS[];
    protected Context context;

    public DBController(Context context)
    {
        super(context);
        this.context = context;
    }

    private boolean insert(T object) throws Exception
    {
        ContentValues values = getContentValues(object);
        values.remove("id");
        Long id = getWritableDatabase().insert(TABELA,null,values);
        object.setId( id.intValue() );
        return ( id != -1);
    }

    private boolean update(T object) throws Exception
    {
        String param[] = {String.valueOf(object.getId())};
        return (getWritableDatabase().update(TABELA,getContentValues(object),"id=?", param) != 0 );
    }

    public boolean store(T object ) throws Exception
    {
        boolean state;

        try
        {
            if(object.isNew())
                state = insert(object);
            else
                state = update(object);
        }
        catch(Exception e)
        {
            throw new Exception(e);
        }

        return state;
    }

    public List<T> list(Criteria criteria) throws Exception
    {
        List<T> list = new ArrayList();

        Cursor c = getWritableDatabase().query( TABELA, COLUMNS,criteria.getQuery(),criteria.getArgs(),criteria.getGroup(),criteria.getHaving(),criteria.getOrder(),criteria.getLimit());

        while( c.moveToNext() )
        {
            list.add(convert(c));
        }

        return list;
    }

    public List<T> list() throws Exception
    {
        List<T> list = new ArrayList();

        Cursor c = getWritableDatabase().query( TABELA, COLUMNS,null,null,null,null,null);

        while( c.moveToNext() )
        {
            list.add(convert(c));
        }

        return list;
    }

    public T get(int id) throws Exception
    {
        String param[] = {String.valueOf(id)};
        Cursor c = getWritableDatabase().query( TABELA, COLUMNS,"id=?",param,null,null,null,null);
        c.moveToFirst();
        return convert(c);
    }

    public void delete(int id) throws Exception
    {
        String param[] = {String.valueOf(id)};
        getWritableDatabase().delete(TABELA, "id=?", param);
    }

    protected abstract T convert(Cursor c) throws Exception;
    protected abstract ContentValues getContentValues(T obj) throws Exception;
}
