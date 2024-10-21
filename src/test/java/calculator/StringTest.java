package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
class StringTest {
	@Test
	void testSum() {
		String example = "//;\\n1";
		int startIndex = example.indexOf("\\n") + 2;
		String startChar = example.substring(startIndex, startIndex + 1);
		assertThat(startChar).isEqualTo("1");
	}
}
