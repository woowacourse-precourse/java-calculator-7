# java-calculator-precourse

# 구현할 기능 목록

- 문자열 값 입력
    - camp.nextstep.edu.missionutils.Console의 readLine()을 사용해 문자열 값을 입력받는다.
- 문자열 파싱 (커스텀 구분자 확인)
    - 커스텀 구분자가 존재하면 (//*\n) 구분자 목록(set)에 추가한다. (str[0], str[1], str[3]을 확인)
    - 커스텀 구분자가 존재하면 커스텀 구분자를 제외한 문자열을 추출한다.
    - 커스텀 구분자가 문자열로 존재하면(문자가 2개 이상) `IllegalArgumentException`을 발생시킨다.
    - 커스텀 구분자가 존재하지 않고 (//\n)만 존재하면  `IllegalArgumentException`을 발생시킨다.
    - "//"으로 시작하지만 \n 기호가 없으면 `IllegalArgumentException`을 발생시킨다.
    - 커스텀 구분자가 숫자이면 `IllegalArgumentException`을 발생시킨다.
- 문자열 파싱 (숫자 추출)
    - 문자열을 순회하며 숫자가 나오면 임시 문자열 변수에 추가한다.
    - 문자열을 순회하며 구분자가 나오면 숫자 목록(list)에 추가하고, 임시 문자열 변수를 비운다.
    - 문자열을 순회하며 숫자, 구분자가 아닌 문자가 나오면 `IllegalArgumentException`을 발생시킨다.
    - 문자열 순회가 종료되었을 때 임시 문자열 변수가 비어있다면 `IllegalArgumentException`을 발생시킨다. (1,2,3, 과 같이 마지막이 구분자로 끝나는 경우)
- 추출한 숫자 계산
    - 숫자 목록을 순회하며 숫자를 정수형으로 변환하고 더하여 결과를 구한다.
- 입출력
    - 다음 양식으로 입출력한다.
    - ```
      덧셈할 문자열을 입력해 주세요.
      1,2:3
      결과 : 6
      ```
    