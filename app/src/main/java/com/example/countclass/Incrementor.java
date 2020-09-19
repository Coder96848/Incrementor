package com.example.countclass;

/**
 * Инкрементация числа до определенного максимального значения
 */
public class Incrementor {

    /**
     * Текущее значение числа
     */
    private volatile int mCurrentNumber = 0;

    /**
     * Максимальное значение числа
     */
    private int mMaximumValue = Integer.MAX_VALUE;

    /**
     * Получение текущего числа
     *
     * @return mCurrentNumber - текущее число
     */

    public int getCurrentNumber() {
        return mCurrentNumber;
    }

    /**
     * Получение максимального значения числа
     *
     * @return mMaximumValue - максимально значение числа
     */

    public int getMaximumValue() {
        return mMaximumValue;
    }

    /**
     * Увеличение текущего числа на единицу, если оно не превышает максимальное значение,
     * иначе происходит обнуление
     */

    public synchronized void incrementNumber() {
        if (mCurrentNumber < mMaximumValue) {
            mCurrentNumber++;
        } else {
            mCurrentNumber = 0;
        }
    }

    /**
     * Установление максимального значения для числа.
     * Если maximumValue меньше 0, то новое значение не устанавливается.
     * Если текущее число оказывается больше нового максимального значения, то оно обнуляется
     *
     * @param maximumValue - новое максимальное значение числа
     */
    public synchronized void setMaximumValue(int maximumValue) {
        if (maximumValue >= 0) mMaximumValue = maximumValue;
        if (mCurrentNumber > mMaximumValue) mCurrentNumber = 0;
        System.out.println("Set Max");
    }
}