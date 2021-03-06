package ru.cource.lesson;

/**
 * Главный класс.
 * Класс реализует операции вычисления.
 * Содержит результат вычисления выражения.
 */
public class Calculator {
    /**
     * Результат вычисления.
     */
    private int result;

    /**
     * Сохранен ли результат.
     */
    private boolean isSaveResult = false;

    /**
     * Суммируем аргументы.
     *
     * @param params Аргументы суммирования.
     */
    public void add(int... params) {
        for (Integer param : params) {
            this.result += param;
        }
    }

    /**
     * Разность аргументов.
     *
     * @param params Аргументы суммирования.
     */
    public void difference(int... params) {
        if (isSaveResult) {                  //Если результат сохранён
            for (Integer param : params) {       //то вычитаем из результата
                this.result -= param;
            }
        } else {                                        // иначе вычитаем из первого аргумента
            int tempResult = params[0];
            for (int i = 1; i < params.length; i++) {
                tempResult -= params[i];
            }
            this.result = tempResult;
        }
    }

    /**
     * Умножение аргументов.
     *
     * @param params Аргументы умножения.
     */
    public void multiply(int... params) {
        if (isSaveResult) {
            this.result = 1;
        }
        for (Integer param : params) {
            this.result *= param;
        }
    }

    /**
     * Деление аргументов.
     *
     * @param params Аргументы умножения.
     * @throws ArithmeticException ловит исключение деления на нуль.
     */
    public void div(int... params) {
        try {
            if (this.result != 0) {
                for (Integer param : params) {
                    this.result /= param;
                }
            } else {
                int tempResult = params[0];
                for (int i = 1; i < params.length; i++) {
                    tempResult /= params[i];
                }
                this.result = tempResult;
            }
        } catch (ArithmeticException exp) {
            System.out.println("Деление на нуль запрещено! / Divide by zero!" + exp);
            cleanResult();
        }
    }

    /**
     * Получить результат вычисления.
     *
     * @return результат вычисления.
     */
    public int getResult() {
        return this.result;
    }

    /**
     * Сохранить/задать результат вычисления.
     */
    public void setResult(int userResult) {
        this.result = userResult;
    }

    /**
     * Очистить результат вычисления.
     */
    public void cleanResult() {
        this.result = 0;
        isSaveResult = false;
    }

    /**
     * Выполнение вычисления
     */
    public void calculating(int firstNum, int secondNum, String operation) {
        switch (operation) {
            case "+":
                add(firstNum, secondNum);
                break;
            case "-":
                difference(firstNum, secondNum);
                break;
            case "*":
                multiply(firstNum, secondNum);
                break;
            case "/":
                div(firstNum, secondNum);
                break;
            default:
                System.out.println("Повторите ввод");
                //валид метод
                break;
        }
    }

}