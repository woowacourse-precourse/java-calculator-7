# java-calculator-precourse

# How to solve?

## 1.입력받기
문자열을 입력받아 저장하자

## 2. 추가 구분자가 있는지 확인하기
글자수가 4글자 이하면 숫자만 있는것이므로 추가 구분자가 없으니 패스하고
그 문자열의 첫번째 글자와 두번째 글자가 /인지 확인하고 뒤에 n이 나왔나 확인후 n 이 나왔다면 그 앞이\인지 확인하자 그리고 있다면 그 앞까지의 추가 구분자를 모두 구분자 집합안에 저장하자

## 3.문자열을 순회하면서 문자열의 숫자를 BigInteger 배열에 파싱한다.(2000자가 넘으면 에러가 뜨게하자 (처리시간이 너무 길어질 수 있음))
문자열을 순회하면서 구분자가 오기전까지 문자열을 순회하며 문자열인 숫자를 저장하다가 구분자가 오거나 배열의 끝에 도달하게 되면 숫자를 빅인티져 형태로 배열에 저장한다.
그외에 다른것이 나오면 에러 처리를 해준다.

## 4.BigInteger배열에 있는 BigInter들을 모두 더하는 연산을 진행한다

## 5.출력한다.


#설계 방식
![우테코 1주차 설계](https://github.com/user-attachments/assets/e97f622f-8ec6-4ca8-b622-08280ce53b55)


이러한 방식으로 설계해보겠다.


### 나의 코드는 의존성주입을 이용하여 설계되었다 DIP와 OCP원칙을 지키며 좋은 추상화를 하기위해(구현과 명세(인터페이스)를 구분하기 위해) 인터페이스를 설계하고 Config라는 클래스에서 의존성 주입을 해줬다.
책임을 분배하기위해 총 계산을 한 것을 사용자에게 반환해주는 페키지(calculator), 덧셈을 담당하는 패키지(add), 추가 구분자를 찾고 저장해주는 패키지(delimiterstorage) 그리고 숫자를 파싱해서 저장해주는 패키지(parsing)으로 나누었고 그 패키지 안에 각각 인터페이스와 구현체들을 설계해주었다.

DelimiterStorageService부터 보면 구분자들을 모아놓은 집합을 가지고 올 수 있는 gfetDelimiters()라는 함수와 문자열 s를 파라미터로 받아 추가 구분자를 저장해주는 delimeterStore(String s)라는 함수를
기능으로 갖는다고 명세 해주었다.
그리고 이를 DelimiterStorageServieimpl에서 구현 해 주었다. DelimiterStorageServieimpl의 멤버로는 구분자들을 저장해놓은 집합인 dilimters가 있다.

ParsingNumberService는 parsingNumber(String s, Hashset<Character> delimiters)라는 함수가 있는데 이 함수는 문자열에서 숫자를 파싱해주는 역할을 하는 함수고 getNumber은 파싱한 숫자들을 모아놓은ArrayList의 주소를 반환하는 기능을 갖는다고 함수라고 명세해주었다.
그리고 이를 ParsingNumberServiceInpl에서 구현 해 주었다. ParsingNumberServiceImpl의 멤버는 파싱한 숫자들을 저장해 놓는 배열인 numbers이다.

AddService는 파싱된 숫자 배열들을 받아서 모두 더 해주는 add라는 함수와 결과값을 반환해주는 getAddResult 라는 함수를 명세해주었다.
그리고 이를 AddServiceImple에서 구현 해 주었다. AddServiceImpl의 멤버는 덧셈의 결과값을 저장해놓는 addResult이다.

이제 이 모든것을 이용하여 서비스를 하는 CalculatorService의 명세는 사실 계산값을 반환하는 함수인 calculate() 밖에 없다.
DIP와 OCP를 지키기위해 오로지 인터페이스에만 의존했고 다른 구현체에 의존하지 않았다.
생성자를 통해 멤버의 값들을 받았고 이는 후에 Config가 생성자를 통해 멤버에 의존성을 주입해준다.
calculate()라는 함수는 위에 Addservice에서 받은 getResult를 반환하는것이다.
위에 정의한 인터페이스와 입력받은 스트링 s만으로 멤버 변수들을 구성하였다.
그리고 이 멤버 변수들은 모두 Config에서 의존성을 주입받게끔 만들어줬다.

마지막으로 Config는 생성자 주입을 통해 calculatorService 라는 객체에 의존성을 주입해주었다.

이렇게 함으로서 좋은 객체 지향설계가 되었다고 생각한다.








