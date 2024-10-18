# 🧮 java-calculator-precourse

## ⭐️ 미션에서 지키려고 노력한 것
1. 과제 진행 요구사항, 기능 요구 사항, 프로그래밍 요구 사항 모두 만족
2. 기능 구현 전, 프로그램 진행 순서, 기능 목록, 테스트 목록 작성
3. 커밋 메시지 양식을 지켜 기능 단위 커밋
4. 기능 요구 사항 이외에 판단할 수 있는 요구 사항 확인
5. class, method의 역할을 명확히 구분
6. Java Code Convention을 지키며 구현

## 🧬 디렉토리 구조
```bash

```

## 💻 프로그램 진행 순서
1. 덧셈할 문자열을 입력 받는다.
2. 커스텀 구분자가 지정되어 있는지 확인한다.
   1. 지정되어 있다면 커스텀 구분자로 숫자를 나눈다.
      1. 커스텀 구분자 이외의 문자를 입력했다면 예외처리한다.
   2. 지정되어 있지 않다면 기본 구분자(쉼표, 콜론)로 숫자를 나눈다.
      1. 기본 구분자 이외의 문자를 입력했다면 예외처리한다.
3. 나누어진 숫자들이 모두 양수인지 확인한다.
   1. 양수가 아닌 수(음수)가 포함되어 있다면 예외처리한다.
4. 나누어진 숫자들을 모두 더한다.
5. 결과로 출력한다.
6. 실행 결과 예시
   ```
   덧셈할 문자열을 입력해 주세요.
   1,2:3
   결과 : 6
   ```

## 🧮 기능 목록
### 사용자 입력 [ ]
1. 입력값 확인 [✔]
   * 사용자가 입력한 값이 공백인지 확인한다.
   * 사용자가 입력한 값이 숫자만으로 구성되어 있는지 확인한다.
2. 커스텀 구분자 확인 [ ]
   * 입력한 문자열의 앞부분에 ``//``와 ``\n`` 사이에 커스텀 구분자가 있는지 확인한다.
   * 커스텀 구분자의 유효성을 검증한다.
3. 기본 구분자 확인 [ ]
   * 커스텀 구분자가 없다면 기본 구분자(``,``와 ``:``)가 있는지 확인한다.
   * 기본 구분자의 유효성을 검증한다.
4. 숫자 나누기 [ ]
   * 커스텀 구분자 혹은 기본 구분자로 숫자를 나눈다.
5. 숫자 양수 여부 확인 [ ] 
   * 구분된 숫자들이 양수인지 확인한다.
### 덧셈 [ ]
* 구분된 숫자들을 더한다. [ ]
### 출력 [ ]
* 덧셈 결과를 아래와 같은 양식으로 출력한다. [ ]
    ```
   결과 : 6
    ```

## ✅ 테스트 목록
### 사용자 입력 [ ]
1. 입력값 확인 [✔]
   * 입력한 문자열이 공백인지 확인한다. [✔]
   * 입력한 문자열이 숫자만으로 구성되어 있는지 확인한다. [✔]
     * 입력한 문자열이 숫자만으로 구성되지 않았다면 ``IllegalArgumentException`` 발생하는지 확인한다. [✔]
     * 입력한 문자열이 음수로 구성되어 있다면 ``IllegalArgumentException`` 발생하는지 확인한다. [✔]
2. 커스텀 구분자 확인 [ ]
    * 입력한 문자열이 ``//(구분자)\n``의 형식인지 확인한다. [ ]
    * 위 조건 이외의 경우라면 ``IllegalArgumentException`` 발생하는지 확인한다. [ ]
3. 기본 구분자 확인 [ ]
    * 입력한 문자열이 ``,`` 또는 ``:``을 포함하는지 확인한다. [ ]
    * 그렇지 않다면 ``IllegalArgumentException`` 발생하는지 확인한다. [ ]
4. 숫자 나누기 [ ]
    * 커스텀 구분자 혹은 기본 구분자로 구분한 숫자의 개수가 정확한지 확인한다. [ ]
5. 숫자 양수 여부 확인 [ ]
    * 구분된 숫자가 모두 양수인지 확인한다. [ ]
### 덧셈 [ ]
* 구분된 숫자들의 덧셈이 올바르게 되었는지 확인한다. [ ]
### 출력 [ ]
* 덧셈 결과가 올바른 양식으로 출력되는지 확인한다. [ ]