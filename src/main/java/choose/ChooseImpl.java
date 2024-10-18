package choose;

import divide.BasicDivide;
import divide.CustomDivide;
import divide.Divide;

public class ChooseImpl implements Choose {
	@Override
	public Divide choose(final String str) {
		if (str.equals("") || str.contains(",") || str.contains(":")) {
			return new BasicDivide();
		} else {
			return new CustomDivide();
		}
	}
}
