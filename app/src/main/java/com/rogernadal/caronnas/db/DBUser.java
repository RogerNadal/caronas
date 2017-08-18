package com.rogernadal.caronnas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.rogernadal.caronnas.lib.DBController;
import com.rogernadal.caronnas.model.User;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

public class DBUser extends DBController<User>
{
    public DBUser(Context context)
    {
        super(context);
        COLUMNS = new String[] {"id","name"};
        TABELA  = "user";
    }


    @Override
    protected User convert(Cursor c) throws Exception
    {
        User user = new User(c.getString( c.getColumnIndex("name") ));
        return user;
    }

    @Override
    protected ContentValues getContentValues(User user) throws Exception
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put("id",   user.getId() );
        contentValues.put("name", user.getName() );

        return contentValues;
    }
}
