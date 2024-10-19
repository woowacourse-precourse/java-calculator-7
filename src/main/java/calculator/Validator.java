package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
  public static boolean checkDefaultDelimterFormat(String inputString) {
    String rex = "^[0-9]+([,:]\\d+)*$";
    Pattern pattern = Pattern.compile(rex);
    Matcher matcher = pattern.matcher(inputString);

    return matcher.find();
  }
  public static boolean checkCustomDelimiterFormat(String inputString) {
    String rex =  "^//[\\D ]\\\\n.*$";
    Pattern p = Pattern.compile(rex);
    Matcher matcher = p.matcher(inputString);

    return matcher.find();
  }
}
