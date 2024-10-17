package calculator.numberExtractor;

import java.util.List;

public interface NumberExtractor {
	
	List<Integer> extract(String str, List<Character> separators);
}
