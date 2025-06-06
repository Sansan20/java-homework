package edu.phystech.hw2;

import java.util.Objects;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

class IntHolder {

    private int value;

    public IntHolder(int value) {
        this.value = value; // тут нужно this из-за конфликта имён
    }

    public static IntHolder valueOf(int x) {
        return new IntHolder(x);
    }

    public int getValue() {
        return value;
    }

    public void swap(IntHolder other) {
        int temp = value;
        value = other.value;
        other.value = temp;
    }

    public IntHolder plus(IntHolder rhv) {
        return new IntHolder(value + rhv.value);
    }

    public IntHolder minus(IntHolder rhv) {
        return new IntHolder(value - rhv.value);
    }

    public IntHolder times(IntHolder rhv) {
        return new IntHolder(value * rhv.value);
    }

    public IntHolder div(IntHolder rhv) {
        return new IntHolder(value / rhv.value);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IntHolder ih) {
            return value == ih.value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}

public class IntHolderTest {

    @Test
    public void swapWorks() {
        IntHolder left = IntHolder.valueOf(10);
        IntHolder right = IntHolder.valueOf(12);

        left.swap(right);

        Assertions.assertEquals(12, left.getValue());
        Assertions.assertEquals(10, right.getValue());

        left.swap(right);

        Assertions.assertEquals(10, left.getValue());
        Assertions.assertEquals(12, right.getValue());

    }

    @Test
    public void equalsAndHashcodeAreConsistent() {
        IntHolder left = IntHolder.valueOf(10);
        IntHolder right = new IntHolder(10);

        Assertions.assertEquals(left, right);
        Assertions.assertEquals(left.hashCode(), right.hashCode());
    }

    @Test
    public void operatorsWork() {
        IntHolder left = IntHolder.valueOf(10);
        IntHolder right = IntHolder.valueOf(2);
        Assertions.assertEquals(10, left.getValue());
        Assertions.assertEquals(2, right.getValue());

        Assertions.assertEquals(12, left.plus(right).getValue());
        Assertions.assertEquals(8, left.minus(right).getValue());
        Assertions.assertEquals(40, left.times(right).times(right).getValue());
        Assertions.assertEquals(5, left.div(right).getValue());

    }

}
