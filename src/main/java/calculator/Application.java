package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	 System.out.println("덧셈할 문자열을 입력해 주세요.");
    	 String in = Console.readLine();

    	  try {
          	int result = add(in);
          	System.out.println("결과 : " + result);
          } catch(IllegalArgumentException e) {
          	System.out.println(e.getMessage());
          }

    }
    public static int add(String in) {

    	if(in == null || in.isEmpty()) {
    		return 0;
    	}

    	 String cus = ",|:";
    	 String[] tokens = in.split(cus);
   	     int sum = 0;

   	     for(String token : tokens) {
	    	try {
	    		sum += Integer.parseInt(token);
				if(sum < 0 ){
					throw new IllegalArgumentException("음수는 계산할 수 없습니다." );
				}
	    	} catch (NumberFormatException e) {
	    		throw new IllegalArgumentException("IllegalArgumentException");
	    	}
	    }

	    return sum;

    }

}
