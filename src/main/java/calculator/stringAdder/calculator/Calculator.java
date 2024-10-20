package calculator.stringAdder.calculator;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 17.
 */
public class Calculator {


  public String sum(String[] numbers) {
    String sum = "0";
    for (String number : numbers){
      sum = addStrings(sum, number);
    }
    return sum;
  }

  private String addStrings(String num1, String num2) {
    StringBuffer result = new StringBuffer();
    int carry = 0;
    int i = num1.length() - 1;
    int j = num2.length() - 1;

    while (i>= 0 || j >= 0 || carry > 0){
      int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
      int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

      int sum = digit1 + digit2 + carry;
      carry = sum / 10;
      result.insert(0, sum % 10);

      i--;
      j--;
    }
    return result.toString();
  }
}
