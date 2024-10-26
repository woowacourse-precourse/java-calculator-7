package input;

import choose.ChooseImpl;
import validate.ValidateImpl;

public class InputFactory {
	// 정적 팩터리 메서드
	public static Input newInput() {
		return new InputImpl(new ValidateImpl(), new ChooseImpl());
	}
}
