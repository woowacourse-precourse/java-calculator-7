# 문자열 덧셈 계산기
- 입력한 문자열에서 숫자를 추출하여 더하는 계산기 구현


## 1. 기능 요구 사항
- 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
    - 쉼표(`,`) 또는 콜론(`:`)을 구분자로 가지는 문자열을 전달하는 경우, 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
        - 예: `"" => 0`, `"1,2" => 3`, `"1,2,3" => 6`, `"1,2:3" => 6`
    - 기본 구분자 외에 **커스텀 구분자**를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 `"//"`와 `"\n"` 사이에 위치하는 문자를 사용한다.
        - 예: `"//;\n1;2;3"` → 커스텀 구분자가 `;`일 경우 결과 값은 `6`이 반환되어야 한다.
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료해야 한다.

  ### 입력
    - 구분자와 양수로 구성된 문자열

  ### 출력
    - 덧셈 결과

## 2. 프로그래밍 요구 사항
- **버전**: Java 21
- ...


## 3. 패키지 목록
- (추가 예정)

## 4. 기능 목록
1) **입력**
    - 문자열 입력 메세지 출력 [o]
    - 문자열 입력 [o]
    - 공백 또는 구분자만 있는 경우 0 반환


2) **문자열 판별**
    - 커스텀 구분자 있는 경우
        - '//'로 시작하고 '\n'으로 끝나는 5자리 문자열이 있는지 확인 [o]
        - 커스텀 구분자 추출 [o]
    - 구분자(',' 및 ':' 및 커스텀 구분자)로 문자열 구분 [o]

3) **덧셈**
    - 분리된 문자열을 숫자로 변환 [o]
    - 숫자들 덧셈

4) **출력**
    - 문자열 출력 메세지 출력
    - 숫자들의 합 출력

## 5. 예외 처리
- 사용자가 잘못된 값을 입력한 경우 `IllegalArgumentException` 발생
    - 커스텀 구분자 입력이 잘못된 경우 → "//(커스텀 구분자)\n"이 아닐 때 [o]
    - 커스텀 구분자가 기본 구분자(',' 및 ':')인 경우 [o]
    - 구분자가 연속된 경우 (예: `,,` 또는 `:::` 등) → 커스텀 구분자 포함
    - 구분된 문자 중 숫자가 아닌 문자가 있는 경우 → 기본, 커스텀 구분자가 아닐 때
    - 변환된 숫자 중 0 또는 음수가 있는 경우

## 6. 사용 예제
- (추가 예정)

