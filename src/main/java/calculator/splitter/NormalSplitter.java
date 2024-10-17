package calculator.splitter;

public class NormalSplitter implements Splitter {

    public String[] split(String input) {
        String delimiter = ",|:";           // 기본 문자열 설정 todo->상수로 추출

        if (input.startsWith("//")) {       // 커스텀 문자열 설정했는지
            int idx = input.indexOf("\\n"); // '\n' 인덱스 찾기
            if (idx == -1) {                // 없으면 Exception
                throw new IllegalArgumentException();
            }

            String token = input.substring(2, idx); // 커스텀 구분자 추출
            delimiter += "|" + token;               // 커스텀 구분자를 구분자 문자열에 추가

            return input.substring(idx + 2).split(delimiter);//커스텀 구분자가 맞다면 '\n' 이후 문자열로부터 분리
        }
        return input.split(delimiter);                       //커스텀 구분자가 아니면 기본 구분자를 통해 분리
    }

}