package com.example.bmi_calc;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.Math;

public class ExampleUnitTest {

    MainActivity bmi_calc;

    @Before
    public void executedBeforeEach() {
        bmi_calc = new MainActivity();
    }

    @Test
    public void mainActivityNotNull() {
        assertNotNull(bmi_calc);
    }

    @Test
    public void calculateCountHappyPath() {
        assertEquals((int) (Math.round(bmi_calc.calculateCount(80, 180))), 25);
    }

    @Test
    public void calculateGroupUnderweightLow() {
        assertEquals(bmi_calc.calculateGroup(15.01), "underweight");
    }

    @Test
    public void calculateGroupUnderweightMax() {
        assertEquals(bmi_calc.calculateGroup(18.49), "underweight");
    }

    @Test
    public void calculateGroupOptimumLow() {
        assertEquals(bmi_calc.calculateGroup(18.50), "optimum");
    }

    @Test
    public void calculateGroupOptimumMax() {
        assertEquals(bmi_calc.calculateGroup(24.49), "optimum");
    }

    @Test
    public void calculateGroupOverweightLow() {
        assertEquals(bmi_calc.calculateGroup(24.50), "overweight");
    }

    @Test
    public void calculateGroupOverweightMax() {
        assertEquals(bmi_calc.calculateGroup(29.99), "overweight");
    }

    @Test
    public void calculateGroupObesityLow() {
        assertEquals(bmi_calc.calculateGroup(30.00), "obesity");
    }

    @Test
    public void calculateGroupObesityMax() {
        assertEquals(bmi_calc.calculateGroup(40.00), "obesity");
    }
}