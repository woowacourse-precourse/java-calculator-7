# 문자열 덧셈 계산기 - minhyuk2

## 개요
    문자열이 들어왔을 때 구분자를 이용하여 계산을 해주는 계산기 프로그램입니다.
    기본적으로 , 과 : 을 구분자로 사용하고, //과 \n 사이에 들어오는 문자를 구분자로 추가합니다.
    결과를 출력하고 잘못된 입력값이 입력된 경우 IllegalArgumentException 을 발생시킵니다.

## 기능 구현
    Dto         ->  결과 DTO와 입력 DTO를 생성 
    
    Service     ->  1. 특수한 구분자가 들어오지 않은 경우에 대한 계산 처리
                    2. 특수한 구분자가 들어온 경우에 대한 계산 처리
    
    Controller  ->  사용자에게 입력을 받고, 계산기 기능을 하여 결과를 출력함

## 기능 목록
    ##docs 태그
    0.  docs: README.md 파일 수정

    ##feat 태그
    ####   데이터를 계층별로 이동시키고 관리하기 위한 DTO를 생성
    1.  domain 디렉토리 생성 -> 생성된 디렉토리와 파일들을 포함, dto 디렉토리 생성 -> 계층간의 이동이 필요하기에 DTO를 사용함
    2.  ResultDTO 생성
    3.  InputDTO 생성

    ####  일반적인 구분자에 대한 계산과 커스텀 구분자가 들어간 계산을 하는 경우로 나눔
    4.  service 디렉토리 생성
    5.  일반적인 구분자에 대한 계산을 위한 인터페이스 생성 -> NormalCalculator 인터페이스 생성
    6.  커스텀 구분자가 들어간 계산을 위한 인터페이스 생성 -> SpecialCalculator 인터페이스 생성 -> // 로 시작하고 \n으로 끝나며 특수한 구분자를 입력받게 될 경우
    7.  일반적인 구분자로 인한 계산과 커스텀 구분자를 추가하여 계산하는 기능 구현 -> NormalCalculatorImpl 과 SpecialCalculatorImpl을 통해
        인터페이스 내용을 구현함. 
    8.  구분자에 따라 분기하여 계산 기능을 수 있는 service 구현 -> CalculatorService 생성 -> 문자열의 첫 시작이 //인지로 분기하여 override 하여 구현한 
        NormalCalculator와 SpecialCalculator를 각각 사용함.
    9.  값을 입력 받아 계산하기 위한 controller 구현 -> controller 디렉토리 생성 + CalculatorController 생성 
        -> 사용자에게 값을 입력받아 계산을 할 수 있도록 service에게 input값을 넘김.
