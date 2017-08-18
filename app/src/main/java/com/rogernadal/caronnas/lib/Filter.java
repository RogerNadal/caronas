package com.rogernadal.caronnas.lib;

import android.text.TextUtils;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import com.rogernadal.caronnas.lib.enums.Operator;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

public class Filter
{
    private String       column;
    private Operator     operator;
    private String       value;
    private List<String> values;

    public Filter(String column, Operator operator, String value)
    {
        this.column   = column;
        this.value    = value;
        this.operator = operator;
    }

    public Filter(String column, Operator operator, Integer value)
    {
        this.column   = column;
        this.value    = String.valueOf(value);
        this.operator = operator;
    }

    public Filter(String column, Operator operator, Timestamp value)
    {
        this.column   = column;
        this.value    = String.valueOf(value);
        this.operator = operator;
    }

    public Filter(String column, Operator operator, List<String> values)
    {
        if( operator == Operator.IN )
        {
            this.column   = column;
            this.values   = values;
            this.operator = operator;
        }
    }

    public Filter(String column, Operator operator)
    {
        this.column   = column;
        this.operator = operator;
    }

    public List<String> getValues()
    {
        return values;
    }

    public String getStatement()
    {
        if(operator == Operator.IN)
        {
            return column + getOperatorString() + "("+TextUtils.join(",", Collections.nCopies(values.size(), "?"))+")";
        }
        else if( operator == Operator.ILIKE)
        {
            return "UPPER("+column+")" + getOperatorString() + "UPPER(?)";
        }
        else if( operator == Operator.IS_NOT_NULL || operator == Operator.IS_NULL )
        {
            return column + getOperatorString();
        }
        else
        {
            return column + getOperatorString() + "?";
        }
    }

    public Operator getOperator()
    {
     return operator;
    }

    public String getValue()
    {
        if(operator == Operator.ILIKE ||  operator == Operator.LIKE )
        {
            return  "%"+value+"%";
        }
        else
        {
            return value;
        }
    }

    private String getOperatorString()
    {
        if (operator == Operator.DIFFERENT)
        {
            return " <> ";
        }
        else if(operator == Operator.IN)
        {
            return " IN ";
        }
        else if(operator == Operator.ILIKE || operator == Operator.LIKE)
        {
            return " LIKE ";
        }
        else if(operator == Operator.BIGGER_EQUALS)
        {
            return " >= ";
        }
        else if(operator == Operator.LESS_EQUALS)
        {
            return " <= ";
        }
        else if( operator == Operator.IS_NULL)
        {
            return  " IS NULL ";
        }
        else if( operator == Operator.IS_NOT_NULL)
        {
            return  " IS NOT NULL ";
        }
        else
        {
            return " = ";
        }
    }


}
