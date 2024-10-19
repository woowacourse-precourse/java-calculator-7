package calculator;

import java.util.Arrays;

public class Calculator extends RegexCheck{
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

  public Calculator allPositiveNumber() throws IllegalArgumentException{
    for(int i=0; i< getStringNumbers().length; i++){
      if(numbers[i] < 0){
        throw new IllegalArgumentException("음수가 있습니다. 양수만 입력해 주세요.");
      }else {
        numbers[i] = parseInt(getStringNumbers()[i] );
      }
    }
    return this;
  }

  public int add(int[] numbers){
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return sum;
  }


}


