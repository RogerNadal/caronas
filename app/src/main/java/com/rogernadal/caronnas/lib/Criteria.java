package com.rogernadal.caronnas.lib;

import java.util.ArrayList;
import java.util.List;

import com.rogernadal.caronnas.lib.enums.Expression;
import com.rogernadal.caronnas.lib.enums.Operator;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

public class Criteria
{
    private String       query;
    private List<String> args;
    private String       order;
    private String       having;
    private String       limit;
    private String       group;

    public Criteria()
    {
        // default
        query  = "";
        order  = "";
        limit  = "";
        having = "";
        group  = "";
        args   = new ArrayList();
    }

    public void add( Filter filter )
    {
        add( filter, Expression.AND );
    }

    public void add( Filter filter, Expression e )
    {
        String expression = (args.isEmpty())? "" : getExpression(e);
        query += expression + filter.getStatement();
        if( filter.getOperator() == Operator.IN )
        {
            for (String value : filter.getValues() )
            {
                args.add( value );
            }
        }
        else
        {
            if( filter.getValue() != null )
                args.add( filter.getValue() );
        }
    }

    public String getOrder()
    {
        return (!order.equalsIgnoreCase(""))?order:"id asc";
    }

    public void setOrder(String order,String type) {
        this.order = order + " " + type;
    }

    public void setOrder(String order) {
        setOrder(order,"asc");
    }

    public String getHaving() {
        return having;
    }

    public void setHaving(String having) {
        this.having = having;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = String.valueOf(limit);
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getQuery()
    {
        return query;
    }

    public String[] getArgs()
    {
        return args.toArray(new String[]{});
    }

    private String getExpression( Expression e )
    {
        if( e == Expression.AND )
        {
            return " AND ";
        }
        else
        {
            return " OR ";
        }
    }
}
