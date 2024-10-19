# java-calculator-precourse - minhyuk2

## 개요
    문자열이 들어왔을 때 구분자를 이용하여 계산을 해주는 계산기 프로그램입니다.
    기본적으로 , 과 : 을 구분자로 사용하고, // \n 사이에 들어오는 문자를 구분자로 추가합니다.
    결과를 출력하고 잘못된 입력값이 입력된 경우 IllegalArgumentException 을 발생시킵니다.

## 기능 구현
    Dto         ->  결과 DTO와 입력 DTO를 생성 
    
    Service     ->  1. 특수한 구분자가 들어오지 않은 경우에 대한 계산 처리
                    2. 특수한 구분자가 들어온 경우에 대한 계산 처리
    
    Controller  ->  계산기 기능을 하여 결과를 출력함

## 기능 목록
    docs 태그
    0.  docs: README.md 파일 수정

    feat 태그
    1.  domain 디렉토리 생성 -> 생성된 디렉토리와 파일들을 포함, dto 디렉토리 생성 -> 계층간의 이동이 필요하기에 DTO를 사용함
    2.  ResultDTO 생성
    3.  InputDTO 생성
    4.  service 디렉토리 생성
    5.  NormalCalculator 인터페이스 생성 -> 일반적인 구분자만 들어온 경우
    6.  SpecialCalculator 인터페이스 생성 -> // 로 시작하여 특수한 구분자를 입력받게 될 경우
    7.  CalculateService 생성 -> 문자열의 첫 시작이 //인지로 분기하여 override 하여 구현한 
        NormalCalculator와 SpecialCalculator를 각각 사용함.
    8.  controller 디렉토리 생성
    9.  CalculatorController 생성 -> 문자열을 입력으로 받으면 해당 문자열을 구분자로 분석해서 덧셈 결과를 리턴

    test 태그
    10. testcase 추가
