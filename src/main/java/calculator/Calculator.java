package calculator;

public class Calculator extends RegexCheck{

  Calculator(String input) {
    super(input);
  }

  public Calculator allPositiveNumber(int[] numbers) throws IllegalArgumentException{
    for(int number : numbers){
      if(number < 0){
        throw new IllegalArgumentException("음수가 있습니다.");
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


