package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
    	 System.out.println("덧셈할 문자열을 입력해 주세요.");
    	 String in = Console.readLine();

		/*try {
          	int result = add(in);
          	System.out.println("결과 : " + result);
          } catch(IllegalArgumentException e) {
          	System.out.println(e.getMessage());
          }*/
		int result = add(in);
		System.out.println("결과 : " + result);


    }
    public static int add(String in) {

    	if(in == null || in.isEmpty()) {
    		return 0;
    	}

    	 String cus = ",|:";

		if(in.startsWith("//")) {
			int custom = in.indexOf("\\n");
			if(custom == -1) {
				throw new IllegalArgumentException("구분자가 잘못되었습니다.");
			}

			String wr = in.substring(2, custom);
			cus = wr;
			in = in.substring(custom + 2);
		}

    	 String[] tokens = in.split(cus);
   	     int sum = 0;

   	     for(String token : tokens) {
	    	try {
	    		int num = Integer.parseInt(token);
				if(num < 0 ){
					throw new IllegalArgumentException("음수는 계산할 수 없습니다." );
				}
				sum += num;
	    	} catch (NumberFormatException e) {
	    		throw new IllegalArgumentException("숫자가 아닙니다: " + token);
	    	}
	    }

	    return sum;
    }

}
