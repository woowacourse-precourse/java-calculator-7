package calculator.parser;

import java.util.regex.Pattern;

public class BasicDelimiterParser implements DelimiterParser{
  @Override
  public String[] parse(String input){
    String delimiter = ",|:";
    if(input.startsWith("//")){
      char customDelimiter = input.charAt(2);
      input = input.substring(5);
      delimiter = delimiter + "|" + Pattern.quote(String.valueOf(customDelimiter));
    }

    return input.split(delimiter);
  }
}
