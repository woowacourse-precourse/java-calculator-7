package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexCheck {
  protected String input;
  private String strNumber;
  private String delimiter=",:";
  protected int[] numbers;
  Pattern pattern;
  Matcher matcher;

  RegexCheck() {
    this("");
  }

  RegexCheck(String input) {
    this.input = input;
  }


  public String getStrNumber() {
    return strNumber;
  }

  private String getRegex() {
    return "([0-9]+[" + delimiter + "]*|" + delimiter + "+[0-9]*)+";
  }

  public Boolean isCorrect(String sort) {
    pattern = Pattern.compile(sort);
    matcher = pattern.matcher(input);
    return matcher.matches();
  }

  public void division() {
    if (matcher.group(2) != null) {
      delimiter = Pattern.quote(matcher.group(2));
    }
    strNumber = matcher.group(3);
    System.out.println("delimiter = " + delimiter);
    System.out.println("strNumber = " + strNumber);
  }

  public String[] check() {
    System.out.println(getRegex());
    pattern = Pattern.compile(getRegex());
    matcher = pattern.matcher(strNumber);
    if (matcher.matches()) {
      return strNumber.split(delimiter);
    } else {
      throw new IllegalArgumentException("구분자를 확인해 주세요");
    }
  }

  public void intChange(String[] args) {
    numbers = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      numbers[i] = Integer.parseInt(args[i]);
    }
  }

}
