package com.example.countclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncrementorTest {

    /**
     * Проверка значения возвращаемого числа
     * Начальное значение числа 0. После одного вызова метода incrementNumber()
     * число увеличивается на 1.
     */
    @Test
    public void getIncrementNumber() {
        Incrementor incrementor = new Incrementor();
        incrementor.incrementNumber();
        assertEquals(1, incrementor.getCurrentNumber());
    }

    /**
     * Проверка обнуления числа после достижения максимального значения
     * Начальное значение числа - 0, максимальное значение - 2147483647.
     * Задаем новое максимальноге значение 1 методом setMaximumValue(1),
     * инкрементируем число 2 раза.
     * Из-за превышения максимального значения числа, оно должно обнулиться.
     */
    @Test
    public void getNumberAfterMaximumValue() {
        Incrementor incrementor = new Incrementor();
        incrementor.setMaximumValue(1);
        incrementor.incrementNumber();
        incrementor.incrementNumber();
        assertEquals(0, incrementor.getCurrentNumber());
    }

    /**
     * Проверка задания максимального значения числа
     * Начальное максимальное значение - 2147483647.
     * Задаем новое максимальноге значение 456 методом setMaximumValue(456)
     */
    @Test
    public void setMaximumValue() {
        Incrementor incrementor = new Incrementor();
        incrementor.setMaximumValue(456);
        assertEquals(456, incrementor.getMaximumValue());
    }

    /**
     * Проверка возможности задания отрицательного максимального значения числа.
     * Начальное максимальное значение - 2147483647.
     * Если в методе setMaximumValue() задается отрицательное значение, то
     * максимальное значение числа не меняется.
     */
    @Test
    public void setNegativeMaximumValue() {
        Incrementor incrementor = new Incrementor();
        incrementor.setMaximumValue(-1);
        assertEquals(2147483647, incrementor.getMaximumValue());
    }

    /**
     * Проверка обнуления числа, если новое максимальное значение
     * оказывается меньше, чем число.
     * Начальное значение числа - 0, максимальное значение - 2147483647.
     * Число инкрементируется до 2 двумя вызовами метода incrementNumber(),
     * далее задается новое максимальное значение числа - 1 методом setMaximumValue(1)
     */
    @Test
    public void setMaximumValueMoreNumber() {
        Incrementor incrementor = new Incrementor();
        incrementor.incrementNumber();
        incrementor.incrementNumber();
        incrementor.setMaximumValue(1);
        assertEquals(0, incrementor.getCurrentNumber());
    }
}
