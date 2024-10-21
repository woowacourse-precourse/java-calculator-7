# java-calculator-precourse 

## 👀 문제 확인하기  
- 우아한테크코스 7기 1주차 과제의 구현 기능과 구현 로직을 담은 문서입니다.
---

## 📝 구현 기능 목록  

### ⚙️ 커스텀 구분자 문자열이 있는지 판단하는 기능
- 문자열의 앞부분을 읽어 커스텀 구분 문자열이 있는지 확인한다.

### ⚙️ 커스텀 구분자 문자열과 숫자 문자열을 분리하는 기능
- 커스텀 구분자 문자열과 숫자 문자열을 분리하여 return
- 없을시 빈 문자열 return

### ⚙️ 입력값 검증 기능 ️

- **커스텀 구분자 문자열**에 대해서
  - **예외: "//"와 "\n" 사이에 여러 문자가 있다면 예외 발생**
  - **예외 : "//"와 "\n"의 형식에 맞지 않게 입력된다면 예외 발생**
  - **예외 : "//"와 "\n" 사이에 문자가 있지 않으면 예외 발생**
  
- **숫자 문자열**에 대해서
  - **예외 : 양수가 아닌 음수 혹은 0이 입력 되어있다면 예외 발생**
  - **예외 : 구분자 다음에 숫자가 아닌 다른게 입력 되어있다면 예외 발생**
  - **예외 : 커스텀 구분자를 포함하여 다른 문자가 구분자로 입력 되어있다면 예외 발생**

### ⚙️ 커스텀 구분자를 확인하고 구분자에 추가 하는 기능
- 읽은 커스텀 구분자를 확인하고 구분자에 추가한다.

### ⚙️ 숫자 문자열을 읽으면서 구분자를 기준으로 숫자를 가져오는 기능
- 문자열을 읽으며 구분자로 구분하면서 숫자만 읽어들인다.

### ⚙️ 가져왔던 숫자들을 전부 더하여 출력하는 기능.
- 읽어들인 숫자들을 더하여 출력한다.
---

## 💡 구현 로직
~~~
1. 입력받은 문자열에 대해서 커스텀 구분자 문자열이 있는지 확인한다.
 1-1. 있다면 커스텀 구분자 문자열을 검증한다.
 1-2. 없다면 숫자 문자열을 검증한다. 
 
2. 커스텀 구분자 문자열의 유무에 따라 검증한다.
 2-1. 예외 처리 : 검증에 실패해 예외(IllegalArgumentException)가 발생되면 어플리케이션을 종료한다.

3. 읽어들인 커스텀 구분자를 추출한다.

4. 숫자 문자열을 구분자로 구분하여 숫자들만 읽어들인다.  

5. 읽어들인 숫자들을 전부 더하여 출력한다.
~~~
