package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class splitNums {
    // arrayList 사용
    // 사용 안하는 경우 기능분리 측면에서 이상해질 우려가 있음
    public static ArrayList<String> splitNums(String str, String custom) {

        int stardIdx = str.indexOf("//");
        int endIdx = str.indexOf("\n", stardIdx);

        if (stardIdx != -1 || endIdx != -1) {
            str = str.substring(0, stardIdx) + str.substring(endIdx + 1);
        }

        if (custom == "") {
            // custom 문자열이 없는 경우
            String regex = "[,:]";

            String[] splitArray = str.split(regex);
            return new ArrayList<>(Arrays.asList(splitArray));
        } else {
            // custom을 포함한 정규표현식 작성
            String regex = "[" + custom + ",:]";

            String[] splitArray = str.split(regex);
            return new ArrayList<>(Arrays.asList(splitArray));
        }

        // 정규 표현식이 불가능한 경우는 테스트 실패시 고려
        // (문자열을 누적시키고 구분자 별로 나누는 방식)
    }
}
