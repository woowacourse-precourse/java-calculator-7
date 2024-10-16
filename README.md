# 🔢 문자열 덧셈 계산기

-----
## 🛠️ 작동 순서
### 1. `InputView`에서 입력을 받아 `CalculateController`로 전달한다.
### 2. `CalculateController`는 이를 `StringParser로` 넘겨 숫자를 추출한다.
### 3. 추출된 숫자들을 `CalculateService`로 전달해 덧셈 결과를 얻는다.
### 4. 결과를 다시 `OutputView`로 전달해 사용자에게 출력한다.

-----

## 🧮 Model

&emsp;▪️ `StringParser`을 통해 문자열을 구분자에 맞게 분리하고, 분리한 숫자들을 `List<Integer>`로 반환한다.

&emsp; 🚫 다음 경우에 `IllegalArgumentException`
```
1. 구분자가 없는 문자열을 입력했을 때
2. 커스텀 구분자가 문자열의 앞부분에 위치하지 않을 때
3. 구분자로 분리한 문자열에서 양의 정수가 아닌 것이 추출되었을 때
```

## 🖥️ View

&emsp;▪️ `InputView`클래스를 통해 사용자에게 문자열을 입력 받은 후, `CalculateController`로 전달한다.

&emsp;▪️ `OutputView`클래스를 통해 계산 결과를 출력한다.


## 🕹️ Controller

&emsp;▪️ `InputView`에서 입력을 받아 `StringParser`로 전달한다.

&emsp;▪️ `StringParser`에서 반환한 정수들을 `CalculateService`로 전달한다.

&emsp;▪️ `CalculateService`에서 반환한 결과를 `OutputView`로 전달한다.



