package com.rogernadal.caronnas.model;

import com.rogernadal.caronnas.lib.Model;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

public class User extends Model
{
    private String name;

    public User(){};

    public User(String name){this.name = name;};

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }
}
