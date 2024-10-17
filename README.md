# java-calculator-precourse

---

## 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
### 입출력 요구 사항
#### 입력
- 구분자와 양수로 구성된 문자열
#### 출력
- 덧셈 결과
```ada
결과 : 6
```
#### 실행 결과 예시
```ada
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```
---
## 추가로 구현할 기능 목록 및 테스트 목록
    - 구분자를 입력하지 않는 경우 : 입력한 숫자 출력
    - 아무것도 입력하지 않는 경우 : 0 출력
    - 잘못된 값을 입력하는 경우
        -  커스텀 구분자가 숫자인 경우 : 오류
        -  새로운 커스텀 구분자의 길이가 한 글자 이상인 경우 : 오류
        -  커스텀 구분자를 만든 후 숫자와 커스텀 구분자 외 다른 문자가 오는 경우 : 오류
        -  커스텀 구분자를 만드는 규칙이 잘못된 경우 : 오류
        -  커스텀 구분자만 연속으로 입력되는 경우 : 오류

---


    