package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexCheck {
  private static final String SORT = "^//([^0-9\\\\n])\\\\n([^\\\\n]+)$";
  protected String input;
  private String strNumber;
  private String delimiter = ",:";
  protected int[] numbers;

  RegexCheck(String input) {
    this.input = input;
  }


  public void setDelimiter(String delimiter) {
    this.delimiter = delimiter;
  }

  public String getStrNumber() {
    return strNumber;
  }

  private String getRegex() {
    return "^[" + delimiter + "]?[1-9][0-9]*([" + delimiter + "][1-9][0-9]*)*$";
  }

  public Boolean isSort() {
    return input.matches(SORT);
  }

  public Boolean isBasic() {
    return input.matches(getRegex());
  }

  public void division(String input) {
    Pattern pattern = Pattern.compile(SORT);
    Matcher matcher = pattern.matcher(input);
    if(matcher.matches()) {
      delimiter = matcher.group(1);
      strNumber = matcher.group(2);
    }
    System.out.println(Pattern.quote(delimiter));
    System.out.println(delimiter);
    System.out.println(strNumber);
  }

  public void check(){

  }

  public void intChange(String[] args) {
    numbers = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      numbers[i] = Integer.parseInt(args[i]);
    }
  }

}
