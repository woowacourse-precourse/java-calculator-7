package calculator.parser;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BasicNumberParser implements NumberParser{
  @Override
  public Number parseNumber(String token){
    if(!token.contains(".") && !token.contains("e") && !token.contains("E")){
      return tryParseLong(token);
    }
    else{
      return new BigDecimal(token);
    }
  }

  private Number tryParseLong(String token) {
    try{
      return Long.parseLong(token);
    } catch(NumberFormatException e){
      return new BigInteger(token);
    }
  }
}
