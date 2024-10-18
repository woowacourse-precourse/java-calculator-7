package calculator;

public class ConvertInt {
	public static int convertInt(String num)
	{
		long	result = 0;
		int		digit = 0;
		char	charNum = 0;
		
		if (num == null){
			throw new IllegalArgumentException("잘못된 숫자 입력");
		}
		if (num.charAt(0) == '-' || num.charAt(0) == '-'){
			throw new IllegalArgumentException("부호 입력");
		}
		for (int i = 0; i < num.length(); i++) {
			charNum = num.charAt(i);
			if (!Character.isDigit(charNum)){
				throw new IllegalArgumentException("잘못된 숫자 입력 포함");
			}
			digit = charNum - '0';
			if (result * 10 > Calculator.MAX_INT){
				throw new IllegalArgumentException("INT 초과 값");
			}
			result = result * 10 + (digit);
		}
		return (int)result;
	}
}
