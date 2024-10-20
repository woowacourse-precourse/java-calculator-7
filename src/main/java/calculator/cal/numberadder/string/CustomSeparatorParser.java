package calculator.cal.numberadder.string;

public class CustomSeparatorParser {

    public String[] parseSeparator(String inputString) {
        //입력이 있는지 판단
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("문자열을 입력하지 않았습니다.");
        } else {
            inputString = inputString.trim();
        }

        //첫번째 인덱스는 커스텀 구분자, 두번째 인덱스는 계산식
        String[] separatorAndInputString = new String[]{",|:", inputString};

        //커스텀 구분자가 있는지 판단
        if (inputString.startsWith("//")) {

            //\n의 인덱스 찾은 후 없으면 빈 문자열 반환
            int endIndex = inputString.indexOf("\\n");
            if (endIndex == -1) {
                return separatorAndInputString;
            }

            //커스텀 구분자 추출
            String separator = inputString.substring(2, endIndex);
            StringBuilder separatorRegex = replaceSeparatorWithRegex(separator);

            //추출한 커스텀 구분자와 계산식 분리
            separatorAndInputString[0] = separatorRegex.toString();
            separatorAndInputString[1] = inputString.substring(endIndex + 2);

        }

        return separatorAndInputString;
    }

    private StringBuilder replaceSeparatorWithRegex(String separator) {
        StringBuilder separatorRegex = new StringBuilder(",|:|");

        for (int i = 0; i < separator.length(); i++) {
            char currentChar = separator.charAt(i);

            //이미 해당 커스텀 구분자가 존재하는 경우 continue
            if (separatorRegex.indexOf(String.valueOf(currentChar)) != -1 && currentChar != '|'
                    && currentChar != '\\') {
                continue;
            }

            //특수 문자 이스케이프
            switch (currentChar) {
                case '|':
                    separatorRegex.append((separatorRegex.indexOf("\\||") != -1) ? "" : "\\||");
                    continue;
                case '\\':
                    separatorRegex.append((separatorRegex.indexOf("\\\\|") != -1) ? "" : "\\\\|");
                    continue;
                case '.':
                    separatorRegex.append("\\.");
                    break;
                case '[':
                    separatorRegex.append("\\[");
                    break;
                case ']':
                    separatorRegex.append("\\]");
                    break;
                case '(':
                    separatorRegex.append("\\(");
                    break;
                case ')':
                    separatorRegex.append("\\)");
                    break;
                case '{':
                    separatorRegex.append("\\{");
                    break;
                case '}':
                    separatorRegex.append("\\}");
                    break;
                case '?':
                    separatorRegex.append("\\?");
                    break;
                case '+':
                    separatorRegex.append("\\+");
                    break;
                case '*':
                    separatorRegex.append("\\*");
                    break;
                case '^':
                    separatorRegex.append("\\^");
                    break;
                case '$':
                    separatorRegex.append("\\$");
                    break;
                case '-':
                    throw new IllegalArgumentException("'-' 또는 숫자는 커스텀 구분자로 사용할 수 없습니다.");
                default:
                    if (Character.isDigit(currentChar)) {
                        throw new IllegalArgumentException("'-' 또는 숫자는 커스텀 구분자로 사용할 수 없습니다.");
                    }
                    separatorRegex.append(currentChar);
                    break;
            }

            //구분자 사이사이에 '|' 삽입
            separatorRegex.append("|");
        }
        separatorRegex.deleteCharAt(separatorRegex.length() - 1);

        return separatorRegex;
    }

}
