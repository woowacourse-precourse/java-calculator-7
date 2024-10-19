package calculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexCheck {
  private final String input;
  private String numericString = "";
  private String delimiter = ",:";
  private String[] stringNumbers;
  protected int[] numbers;
  private Pattern pattern;
  private Matcher matcher;


  RegexCheck(String input) {
    this.input = input;
  }

  public String getNumericString() {
    return numericString;
  }

  private String getRegex() {
    return "([0-9]+[" + delimiter + "]*|" + delimiter + "+[0-9]*)+";
  }

  public Boolean isValidInput(String sort) {
    pattern = Pattern.compile(sort);
    matcher = pattern.matcher(input);

    return matcher.matches();
  }

  public Calculator splitValues() {
    if (matcher.group(2) != null) {
      delimiter = Pattern.quote(matcher.group(2));
    }

    if (matcher.group(3) != null) {
      numericString = matcher.group(3);
    }


    System.out.println("delimiter = " + delimiter);
    System.out.println("numericString = " + numericString);
    return (Calculator) this;
  }

  public Calculator matchesRegex() throws IllegalArgumentException {
    System.out.println("getRegex() = " + getRegex());
    pattern = Pattern.compile(getRegex());
    matcher = pattern.matcher(numericString);
    if (matcher.matches()) {
      stringNumbers = numericString.split(delimiter);
      System.out.println("stringNumbers = " + Arrays.toString(stringNumbers));
      return (Calculator) this;
    } else {
      throw new IllegalArgumentException("구분자를 확인해 주세요");
    }
  }

  public void parseInt(String[] args) {
    numbers = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      numbers[i] = Integer.parseInt(args[i]);
    }
  }

}
