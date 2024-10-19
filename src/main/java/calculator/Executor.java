package calculator;

public class Executor {
	private IOController ioController;
	private Parser parser;
	private Calculator calculator;

	/**
	 * 생성자
	 *
	 * @param ioController : 입출력 기능
	 * @param parser       : 문자열 파싱 기능
	 * @param calculator   : 계산 기능
	 */
	Executor(IOController ioController, Parser parser, Calculator calculator) {
		this.ioController = ioController;
		this.parser = parser;
		this.calculator = calculator;
	}

}
