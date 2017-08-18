package com.rogernadal.caronnas.lib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

public class Internet
{

    public Internet() {}

    public static boolean isConnect(Context context)
    {
        boolean connect = false;

        connect = isConnectWifi(context);
        if (!connect)
        {
            connect = isConnectMobile(context);
        }

        return connect;
    }

    public static boolean isConnectWifi(Context context)
    {
        boolean connect = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null)
        {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
            {
                connect = true;
            }
        }

        return connect;
    }

    public static boolean isConnectMobile(Context context)
    {
        boolean connect = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null)
        {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
            {
                connect = true;
            }
        }

        return connect;
    }
}