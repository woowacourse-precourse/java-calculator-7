package input;

import camp.nextstep.edu.missionutils.Console;
import choose.Choose;
import choose.ChooseImpl;
import divide.Divide;

public class InputImpl implements Input {
	private Choose choose = new ChooseImpl();
	private Divide divide;

	@Override
	public int input() {
		String str = Console.readLine();
		
		if (!checkValidation(str)) {
			throw new IllegalArgumentException("올바른 값을 입력해주세요.");
		}
		
		divide = choose.choose(str);
		divide.divide(str);
		
		return 1;	// 답 리턴
	}
	
	private boolean checkValidation(String str) {
		if (str.equals("")) {
			return true;
		}
		
		if (str.contains("-")) {
			return false;
		}
		
		if (!str.contains(",") && !str.contains(":") 
			&& !str.contains("//") && !str.contains("\n")) {
			return false;
		}
		
		return true;
	}
}
