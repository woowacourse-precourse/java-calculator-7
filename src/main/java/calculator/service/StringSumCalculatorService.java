package calculator.service;

import calculator.parser.DelimiterParser;
import calculator.parser.NumberParser;
import calculator.validator.NumberValidator;
import java.math.BigDecimal;
import java.math.BigInteger;

public class StringSumCalculatorService implements SumCalculatorService{
  private final DelimiterParser delimiterParser;
  private final NumberParser numberParser;
  private final NumberValidator numberValidator;

  public StringSumCalculatorService(DelimiterParser delimiterParser, NumberParser numberParser,
      NumberValidator numberValidator) {
    this.delimiterParser = delimiterParser;
    this.numberParser = numberParser;
    this.numberValidator = numberValidator;
  }
  @Override
  public String calculate(String input){
    if(input.isEmpty()) return "0";

    String[] tokens = delimiterParser.parse(input);

    long lsum = 0;
    BigInteger biSum = null;
    BigDecimal bdSum = null;

    for (String token : tokens) {
      numberValidator.validateNumber(token);
      Number number = numberParser.parseNumber(token);

      if(number instanceof Long){
        long lValue = (Long)number;
        if(bdSum != null){
          bdSum = bdSum.add(BigDecimal.valueOf(lValue));
        }
        else {
          if(biSum == null){
            if (isOverFlow(lsum, lValue)) {
              biSum = BigInteger.valueOf(lsum).add(BigInteger.valueOf(lValue));
            }
            else{
              lsum += lValue;
            }
          }
          else{
            biSum = biSum.add(BigInteger.valueOf(lValue));
          }
        }
      }
      else if (number instanceof BigInteger) {
        if(bdSum != null){
          bdSum = bdSum.add(new BigDecimal((BigInteger) number));
        }
        else {
          if(biSum == null){
            biSum = BigInteger.valueOf(lsum).add((BigInteger) number);
          }
          else{
            biSum = biSum.add((BigInteger)number);
          }
        }
      }
      else if (number instanceof BigDecimal) {
        bdSum = createBigDecimalSum(bdSum, lsum, biSum);
        bdSum = bdSum.add((BigDecimal) number);
      }
    }

    if(bdSum!= null){
      if(biSum != null){
        bdSum = bdSum.add(new BigDecimal(biSum));
      }
      if(lsum != 0){
        bdSum = bdSum.add(BigDecimal.valueOf(lsum));
      }
      return bdSum.stripTrailingZeros().toPlainString();
    }
    if(biSum != null){
      return biSum.toString();
    }
    return Long.toString(lsum);
  }


  private boolean isOverFlow(long lsum, long lValue) {
    if (lsum > Long.MAX_VALUE - lValue) {
      return true;
    }
    return false;
  }

  private BigDecimal createBigDecimalSum(BigDecimal bdSum, long lsum, BigInteger biSum) {
    if(bdSum == null){
      if(biSum != null){
        bdSum = new BigDecimal(biSum);
      }
      else{
        bdSum = new BigDecimal(lsum);
      }
    }
    return bdSum;
  }
}
