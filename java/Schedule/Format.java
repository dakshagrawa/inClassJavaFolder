public class Format
{

    public Format()
    {
    }

    public static String center(double d, int i, int j)
    {
        String s = decimalPlaces(d, j);
        if(i < s.length())
            return s;
        else
            return pad(' ', ((i - s.length()) + 1) / 2) + s + 
            pad(' ', (i - s.length()) / 2);
    }

    public static String centerSigFigs(double d, int i, int j)
    {
        String s = sigFigFix(d, j);
        if(i < s.length())
            return s;
        else
            return pad(' ', ((i - s.length()) + 1) / 2) + s + 
            pad(' ', (i - s.length()) / 2);
    }

    public static String center(long l, int i)
    {
        String s = convert(l);
        if(i < s.length())
            return s;
        else
            return pad(' ', ((i - s.length()) + 1) / 2) + s + 
            pad(' ', (i - s.length()) / 2);
    }

    public static String center(String s, int i)
    {
        if(i < s.length())
            return s;
        else
            return pad(' ', ((i - s.length()) + 1) / 2) + s + 
            pad(' ', (i - s.length()) / 2);
    }

    public static String left(double d, int i, int j)
    {
        String s = decimalPlaces(d, j);
        if(i < s.length())
            return s;
        else
            return s + pad(' ', i - s.length());
    }

    public static String leftSigFigs(double d, int i, int j)
    {
        String s = sigFigFix(d, j);
        if(i < s.length())
            return s;
        else
            return s + pad(' ', i - s.length());
    }

    public static String left(long l, int i)
    {
        String s = convert(l);
        if(i < s.length())
            return s;
        else
            return s + pad(' ', i - s.length());
    }

    public static String left(String s, int i)
    {
        if(i < s.length())
            return s;
        else
            return s + pad(' ', i - s.length());
    }

    public static String right(double d, int i, int j)
    {
        String s = decimalPlaces(d, j);
        if(i < s.length())
            return s;
        else
            return pad(' ', i - s.length()) + s;
    }

    public static String rightSigFigs(double d, int i, int j)
    {
        String s = sigFigFix(d, j);
        if(i < s.length())
            return s;
        else
            return pad(' ', i - s.length()) + s;
    }

    public static String right(long l, int i)
    {
        String s = convert(l);
        if(i <= s.length())
            return s;
        else
            return pad(' ', i - s.length()) + s;
    }

    public static String right(String s, int i)
    {
        if(i < s.length())
            return s;
        else
            return pad(' ', i - s.length()) + s;
    }

    public static String decimalPlaces(double d, int i)
    {
        double d1 = d * Math.pow(10D, i);
        d1 = Math.round(d1);
        d1 /= Math.pow(10D, i);
        return convert(d1, i);
    }

    public static String sigFigFix(double d, int i)
    {
        String s = Double.toString(d);
        String s1;
        String s2;
        if(s.startsWith("-") || s.startsWith("+"))
        {
            s1 = s.substring(0, 1);
            s2 = s.substring(1);
        } else
        {
            s1 = "";
            s2 = s;
        }
        int j = s2.indexOf(101);
        if(j == -1)
            j = s2.indexOf(69);
        String s3;
        String s4;
        if(j == -1)
        {
            s3 = s2;
            s4 = "";
        } else
        {
            s3 = s2.substring(0, j);
            s4 = s2.substring(j);
        }
        int k = s3.indexOf(46);
        StringBuffer stringbuffer;
        StringBuffer stringbuffer1;
        if(k == -1)
        {
            stringbuffer = new StringBuffer(s3);
            stringbuffer1 = new StringBuffer("");
        } else
        {
            stringbuffer = new StringBuffer(s3.substring(0, k));
            stringbuffer1 = new StringBuffer(s3.substring(k + 1));
        }
        int l = stringbuffer.length();
        int i1 = stringbuffer1.length();
        if((l == 0 || stringbuffer.equals("0")) && i1 > 0)
        {
            l = 0;
            for(int j1 = 0; j1 < stringbuffer1.length(); j1++)
            {
                if(stringbuffer1.charAt(j1) != '0')
                    break;
                i1--;
            }

        }
        int k1 = l + i1;
        if(i > k1)
        {
            for(int l1 = k1; l1 < i; l1++)
                stringbuffer1.append('0');

        } else
        if(i < k1 && i >= l)
            stringbuffer1.setLength(
            stringbuffer1.length() - (i1 - (i - l)));
        else
        if(i < l)
        {
            stringbuffer1.setLength(0);
            for(int i2 = i; i2 < l; i2++)
                stringbuffer.setCharAt(i2, '0');

        }
        if(stringbuffer1.length() == 0)
            return s1 + stringbuffer + s4;
        else
            return s1 + stringbuffer + "." + stringbuffer1 + s4;
    }

    private static String convert(double d, int i)
    {
        int j = 0;
        StringBuffer stringbuffer = new StringBuffer("" + d);
        int k;
        for(k = stringbuffer.length(); j < k && 
        stringbuffer.charAt(j) != '.'; j++);
        int l;
        if(j == k)
        {
            stringbuffer.append(".");
            l = i;
        } else
        {
            int i1 = k - j - 1;
            l = i - i1;
        }
        for(int j1 = 0; j1 < l; j1++)
            stringbuffer.append("0");

        return stringbuffer.toString();
    }

    private static String convert(long l)
    {
        return "" + l;
    }

    private static String pad(char c, int i)
    {
        StringBuffer stringbuffer = new StringBuffer("");
        if(i < 1)
            return "";
        for(int j = 0; j < i; j++)
            stringbuffer.append(c);

        return stringbuffer.toString();
    }
}
