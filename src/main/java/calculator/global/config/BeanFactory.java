package calculator.global.config;

import calculator.domain.Number;
import calculator.domain.Separator;
import calculator.global.api.CalculatorAPI;
import calculator.global.api.JudgmentAPI;
import calculator.global.api.SeparateAPI;

public class BeanFactory {
	public static Number number() {
		return Number.getInstance();
	}

	public static Separator separator() {
		return Separator.getInstance();
	}

	public static CalculatorAPI calculator() {
		return CalculatorAPI.getInstance();
	}

	public static JudgmentAPI judgement() {
		return JudgmentAPI.getInstance();
	}

	public static SeparateAPI separate() {
		return SeparateAPI.getInstance();
	}

}
