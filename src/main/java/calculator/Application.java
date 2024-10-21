package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Application {
    static int sum(List<Integer> numbers) {
        return numbers
            .stream()
            .reduce(Integer::sum)
            .orElse(0);
    }

    static List<Integer> parseNumberWithDelimiters(CharacterBuffer buffer, List<Character> delimiters) {
        List<Integer> parsedNumbers = new ArrayList<>();
        int acc = -1;
        while (buffer.hasNext()) {
            char current = buffer.next();
            if (delimiters.contains(current)) {
                parsedNumbers.add(acc == -1 ? 0 : acc);
                acc = -1;
            } else if ('0' <= current && current <= '9') {
                if (current == '0' && acc == 0) {
                    throw new IllegalArgumentException("맨 앞 0은 한번밖에 올 수 없습니다.");
                }
                if (acc == -1) {
                    acc = 0;
                }
                acc = acc * 10 + (current - '0');
            } else {
                throw new IllegalArgumentException("숫자와 정해진 구분자외 다른 문자는 올 수 없습니다.");
            }
        }
        return parsedNumbers;
    }

    static boolean parseDelimiterStart(CharacterBuffer buffer) {
        int slashCount = 0;
        while (buffer.hasNext() && slashCount < 2) {
            char current = buffer.next();
            if (current != '/') {
                if (slashCount == 0) {
                    buffer.prev();
                    return false;
                } else {
                    throw new IllegalArgumentException("/다음에 /이 와야 합니다.");
                }
            }
            slashCount += 1;
        }
        return true;
    }

    static void gatherDelimiter(Stack<Character> stk, List<Character> delimiters) {
        if (stk.isEmpty() || stk.pop() != 'n') {
            throw new IllegalArgumentException("커스텀 구분자는 n으로 끝나야 합니다.");
        }
        if (stk.isEmpty() || stk.pop() != '\\') {
            throw new IllegalArgumentException("커스텀 구분자는 \\n으로 끝나야 합니다.");
        }
        while (!stk.isEmpty()) {
            char top = stk.pop();
            if (top == ';' || top == ',') {
                throw new IllegalArgumentException("기본 구분자는 포함할 수 없습니다.");
            }
            delimiters.add(top);
        }
    }

    static List<Character> parseDelimiters(CharacterBuffer buffer) {
        Stack<Character> stk = new Stack<>();
        List<Character> delimiters = new ArrayList<>();
        delimiters.add(';');
        delimiters.add(',');

        boolean isStarted = parseDelimiterStart(buffer);
        if (!isStarted) {
            return delimiters;
        }
        while (buffer.hasNext()) {
            char current = buffer.next();
            if (current == 'n' && !stk.isEmpty() && stk.peek() == '\\') {
                stk.push(current);
                break;
            }
            stk.push(current);
        }
        gatherDelimiter(stk, delimiters);
        return delimiters;
    }

    public static void main(String[] args) {

    }
}
