package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

  private static final IOHandler ioHandler = new IOHandler();

  public static void run() {

    String userInput = ioHandler.getUserInput();

    long sum = 0;
    if (userInput.contains(",") || userInput.contains(":")) {
      if (userInput.contains(",")) {
        String[] nums = userInput.trim().split("[,:]");
        for (String num : nums) {
          if (Long.parseLong(num) < 0) {
            throw new IllegalArgumentException("구분자와 양수로 구성된 문자열을 입력해 주세요.");
          }
          sum += Long.parseLong(num);
        }
      }
    } else if (userInput.contains("//") && userInput.contains("\\n")) {
      String separator = userInput.substring(userInput.indexOf("//") + 2,
          userInput.indexOf("\\n"));
      String[] nums = userInput.substring(userInput.indexOf("\\n") + 2).split(separator);
      for (String num : nums) {
        if (Long.parseLong(num) < 0) {
          throw new IllegalArgumentException("구분자와 양수로 구성된 문자열을 입력해 주세요.");
        }
        sum += Long.parseLong(num);
      }
    } else {
      throw new IllegalArgumentException("구분자와 양수로 구성된 문자열을 입력해 주세요.");
    }

    ioHandler.printCalculatedOutput(sum);
    Console.close();

  }
}
