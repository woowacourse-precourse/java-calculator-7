# 🔹 우테코 1주차 과제


## 요구사항
***
> ### 🔽 기능 요구사항
>
>
>    - 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
       >     1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
       >       - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
       >     2. 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
       >        - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
       >     3. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
> 
> 
> ### 🔽 입출력 요구사항
> 
> 
> - #### 입력
>   - 구분자와 양수로 구성된 문자열
>
>
> - #### 출력
>   - 덧셈결과
>
>         결과 : 6
> - #### 실행결과 예시
>
> ````
> 덧셈할 문자열을 입력해 주세요.
> 1,2:3
> 결과 : 6
> ````

## 기능 명세서

***


|      **기능**       |       **이름**       |                  **설명**                   |            **매개변수**            |
|:-----------------:|:------------------:|:-----------------------------------------:|:------------------------------:|
|  calculator 생성자   |    Calculator()    |              calculator 생성자               |          String input          |
|     result 반환     |    getResult()     |             최종 덧셈 계산 결과값을 반환              |               -                |
| 새로운 calculator 생성 |       init()       |             calculator 생성자 생성             |               -                |
|   calculate 시작    |  getCalculrate()   |    사용자에게서 입력 받아 separatorLocator() 실행     |               -                |
|       덧셈 계산       | calculateNumber()  |           입력받은 문자열과 구분자로 덧셈 구현            | String input, String seperator |
|   구분자에 따른 계산방법    | separatorLocator() |     기본 구분자로 계산하는지 커스텀 구분자로 계산하는지 결정함      |          String input          
|      기본 구분자       | defaultSeparator() |        기본 구분자인 ","와 ":"를 이용할 때 사용         |          String input          |
|      커스텀 구분자      | customSeparator()  | "//"와 "\n"사이에 문자나 문자열을 넣어 구분자를 새로 만들 때 사용 |          String input         |



