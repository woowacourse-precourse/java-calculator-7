package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexCheck {
  private final String INPUT;
  private String numericString;
  private String delimiter = "[,:]";
  private String[] stringNumbers;
  private Matcher matcher;


  RegexCheck(String input) {
    this.INPUT = input;

    String INPUT_REGEX = "(//([^0-9])\\\\n)?(([-]?[0-9]+[^0-9]+)*[-]?[0-9]*)$";
    matcher = Pattern.compile(INPUT_REGEX).matcher(input);
  }


  private String getRegex() {
    return "([-]?[0-9]+([" + delimiter + "]+[-]?[0-9]+)*)";
  }

  public String[] getStringNumbers() {
    return stringNumbers;
  }

  public Boolean inputValidator() {
    return matcher.matches();
  }

  public void matchesAndInsert() {

    if (matcher.matches()) {

      if (matcher.group(2) != null) {
        delimiter = matcher.group(2);
      }
      numericString = matcher.group(3);

//      System.out.println("delimiter = " + delimiter);
//      System.out.println("numericString = " + numericString);

      matchDelimiter();
//
//      System.out.println("matchDelimiter 후");
//      System.out.println("delimiter = " + delimiter);
//      System.out.println("stringNumbers = " + Arrays.toString(stringNumbers));

    } else {
      throw new IllegalArgumentException("입력 형식을 확인해 주세요");
    }

  }

  private void matchDelimiter() throws IllegalArgumentException {
    matcher = Pattern.compile(getRegex()).matcher(numericString);
//    System.out.println("getRegex() = " + getRegex());

    if (INPUT.isEmpty()) {
      stringNumbers = new String[0];
      return;
    }

    if (matcher.matches()) {
      stringNumbers = numericString.split(delimiter);
    } else {
      throw new IllegalArgumentException("구분자가 잘못되었습니다.");
    }
  }
}
