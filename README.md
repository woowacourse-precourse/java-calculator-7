# 문자열 덧셈 계산기

## 프로젝트 설명

문자열 입력에서 숫자를 추출하고, 이를 합산하여 결과를 반환하는 계산기를 구현

## 추가된 기능

1. `camp.nextstep.edu.missionutils.Console.readLine()`를 사용하여 입력값을 받음

2. 쉼표(,) 또는 콜론(:) 및 커스텀 구분자(//[구분자]\n)를 지정하여 숫자를 분리하여 합산

- 예: `1,2,3` => 6
- 예: `1,2:3` => 6

3. 잘못된 값을 입력받을 시 `IllegalArgumentException` 발생시킨 후 프로그램 종료

- 예: `2,-3:4` => `IllegalArgumentException`
- 예: `2:ab,5` => `IllegalArgumentException`
