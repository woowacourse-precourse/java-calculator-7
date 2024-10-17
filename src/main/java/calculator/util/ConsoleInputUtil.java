package calculator.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleInputUtil {
	private static final Logger logger = LoggerFactory.getLogger(ConsoleInputUtil.class);

	public String readInput() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("덧셈할 문자열을 입력해 주세요.");
			return reader.readLine();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "입력을 읽는 중 오류 발생", e);
			return null;
		}
	}
}