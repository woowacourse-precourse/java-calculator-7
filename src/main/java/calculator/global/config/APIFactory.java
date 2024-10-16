package calculator.global.config;

import calculator.global.api.CalculatorAPI;
import calculator.global.api.JudgmentAPI;
import calculator.global.api.SeparateAPI;

public class APIFactory {
	private static final APIFactory INSTANCE = new APIFactory();

	private APIFactory() {}

	public final CalculatorAPI calculator() {
		return new CalculatorAPI();
	}

	public final JudgmentAPI judgement() {
		return new JudgmentAPI();
	}

	public final SeparateAPI separate() {
		return new SeparateAPI();
	}

	public static APIFactory getInstance() {
		return INSTANCE;
	}
}
