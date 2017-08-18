package com.rogernadal.caronnas.controller;

import android.content.Context;

import com.rogernadal.caronnas.db.DBUser;
import com.rogernadal.caronnas.lib.Controller;
import com.rogernadal.caronnas.lib.DBController;
import com.rogernadal.caronnas.model.User;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

public class UserController  extends Controller<User, DBController<User>>
{
    private static UserController controller;
    private static Context          context;

    private UserController()
    {
        super( new DBUser( context ) );
    }

    public static UserController getInstance(Context c)
    {
        if( controller == null)
        {
            context = c;
            controller = new UserController();
        }

        return controller;
    }
}
