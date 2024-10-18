package calculator.utility;

import java.util.regex.Pattern;

public class StringUtility
{
    public static boolean isNumber(String input)
    {
        try
        {
            Integer.parseInt(input);
            return true;
        }

        catch (Exception e)
        {
            return false;
        }
    }
}
