package choose;

import static separate.Separator.*;

import divide.BasicDivide;
import divide.CustomDivide;
import divide.Divide;

public class ChooseImpl implements Choose {
	@Override
	public Divide chooseStrategy(final String str) {
		if (CUSTOM.hasAllSeparators(str)) {	// 커스텀 구분자 사용
			return new CustomDivide();
		} else {	// 기본 구분자 사용
			return new BasicDivide();
		}
	}
}
