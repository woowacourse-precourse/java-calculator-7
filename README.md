# java-calculator-precourse
## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다. 
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6 
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항
### 입력
- 구분자와 양수로 구성된 문자열
### 출력
- 덧셈 결과
````
결과 : 6
````
### 실행 결과 예시
````
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
````

## 기능 구현 목록
- isCustomDelimiter
  - 커스텀 구분자라면, 구분자와 입력을 재설정한다.
- splitDelimiter
  - 구분자를 기준으로 문자열을 잘라서 배열을 생성한다.
- isNumeric
  - 문자열이 숫자인지 확인한다.
- calculateNumber
  - 기존 계산 결과에 값을 더한다.
- getAnswer
  - 계산 결과를 출력한다.
- inputString
  - 문자열을 입력받는다.

## 로직
1. 기본 구분자를 설정한다.
2. 문자열을 입력받는다.
3. 커스텀 문자인지 확인한다.
   - 커스텀 문자일 경우, 구분자를 재설정하고 문자열을 `\n`를 기준으로 자른다.
4. 구분자를 기준으로 자른 문자열 배열을 생성한다.
5. 배열을 순회한다.
   - 값이 숫자일 경우, 기존 결과에 값을 더한다.
   - 값이 숫자가 아닐 경우, `IllegalArgumentException` 발생 후 종료한다.
6. 계산 결과를 출력 후, 종료한다.

## 순서도
<img width = "550" alt = "image" src="https://github.com/user-attachments/assets/0c43d57a-0eae-4708-a414-f7ddc88f4abc">