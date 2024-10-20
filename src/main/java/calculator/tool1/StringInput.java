package calculator.tool1;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringInput {

  private String delimiterRegex;

  private String nums;

  public String getDelimiterRegex() {
    return delimiterRegex;
  }

  public String getNums() {
    return nums;
  }

  public StringInput() {

    //입력을 \n 문자열 기준으로 받음
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    String stringInput = Console.readLine();

    stringInput = stringInput.replace("\\n", "\n");

    delimiterRegex = ":|,";

    Matcher m = Pattern.compile("//(.*?)\\n(.*)", Pattern.DOTALL).matcher(stringInput);

    if (m.find()) {
      String customDelimiter = m.group(1); //구분자 부분

      this.nums = m.group(2);       // 숫자 부분

      this.delimiterRegex += "|" + Pattern.quote(customDelimiter);

    } else{
      this.nums = stringInput;
    }

  }

}
