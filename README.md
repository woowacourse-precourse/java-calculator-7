# java-calculator-precourse


# 문자열 계산기 (String Calculator)

## 개요
이 프로그램은 주어진 문자열에서 구분자를 이용해 숫자를 분리하고, 그 숫자들의 합을 계산하는 문자열 계산기입니다. 기본 구분자는 쉼표(,)와 콜론(:)이며, 사용자가 커스텀 구분자를 지정할 수도 있습니다.

## 기능 목록
1. **빈 문자열 입력 시 0을 반환**
    - 입력 값이 빈 문자열(`""`)인 경우 0을 반환합니다.
    - 예시: `"" => 0`

2. **쉼표(,)와 콜론(:)을 기본 구분자로 사용하여 숫자를 더함**
    - 입력 값에 쉼표(,) 또는 콜론(:)이 포함된 경우 구분자를 기준으로 숫자를 분리하여 합을 계산합니다.
    - 예시: `"1,2" => 3`, `"1,2:3" => 6`

3. **커스텀 구분자를 지원**
    - 커스텀 구분자는 `//`와 `\n` 사이에 위치합니다. 커스텀 구분자를 지정하면 해당 구분자를 사용하여 숫자를 분리합니다.
    - 예시: `"//;\n1;2;3" => 6` (세미콜론(;)을 구분자로 사용)
    - `//\n`만 입력되었을 경우 IllegalArgumentException를 발생시키며 "커스텀 구분자를 지정하지 않았습니다."를 출력합니다.

4. **숫자가 아닌 값 처리**
    - 숫자가 아닌 값이 구분자 사이에 입력되었을 경우 IllegalArgumentException 예외를 발생시키며 "숫자가 아닙니다."를 출력합니다.
