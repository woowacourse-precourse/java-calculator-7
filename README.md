# java-calculator-precourse

# Calculator class

- Calculator class has below Large functions
    1. process input ( internal function)
    2. sum all element (internal funtion)
    3. interface for calculating

    - By using interface, User can use calculator and calculator do tasks processing input and sum all elements

# Application

- check input string functions
    - check empty or not before send input to Calculator
- import Console from camp.nextstep.edu.missionutils.Console

# Apply MVC pattern

## View

### AppView

- provide view logic printing guide and result Message

## Controller

### AppMainController

- provide interface to user
- manage all sub-controller which has specific task responsibility
- validate input string whether input satisfies basic format.

### ParsingController

- sub-controller
- provide logic for parsing input into number

### IntegerMathController

- sub-controller
- provide interface to MathModel

## Model

### MathModel

- provide service logic related to math

