package calculator;

import java.util.Arrays;

public class Calculator extends RegexCheck {
  private int[] numbers;

  Calculator(String input) {
    super(input);
  }

  public int[] getNumbers() {
    return numbers;
  }

  private int parseInt(String strNumber) {
    return Integer.parseInt(strNumber);
  }

  public Calculator allPositiveNumber() throws IllegalArgumentException {
    numbers = new int[getStringNumbers().length];

    for (int i = 0; i < getStringNumbers().length; i++) {
      int number = parseInt(getStringNumbers()[i]);
      if (number < 0) {
        throw new IllegalArgumentException("음수가 있습니다. 양수만 입력해 주세요.");
      }
      numbers[i] = number;
    }

    return this;
  }

  public static int add(int[] numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return sum;
  }

}


