package calculator;

public class findCustomSpliter {
    public String customSpliter(String str) {
        String startMark = "//";
        String endMark = "\n";

        if (!str.startsWith(startMark)) {
            return "";
        }

        int startIndex = startMark.length();
        int endIndex = str.indexOf(endMark, startIndex);

        if (endIndex == -1) { // 수정된 부분: \n이 존재하지 않을 경우를 대비해 예외 처리
            throw new IllegalArgumentException("잘못된 문자열 형식입니다. \n이 필요합니다.");
        }

        return str.substring(startIndex, endIndex);
    }
}
