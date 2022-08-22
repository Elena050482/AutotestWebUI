package org.example.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static java.lang.Double.NaN;
import static org.example.lesson4.AreaOfTriangle.triangleArea;

public class AreaOfTriangleTest {
    @Test
    @DisplayName("Проверка с валидными данными")
    void TrianglePositiveTest() throws Exception {
        double result = triangleArea(5,5,5);
        Assertions.assertEquals(result, 10.825317547305483);
    }

    @Test
    @DisplayName("Проверка при невалидных значениях стороны: отрицательное и нулевое значение")
    void TriangleNegativeTest11 (){
        Assertions.assertThrows(Exception.class, () -> AreaOfTriangle.triangleArea(-1,5,5));
    }



    @Test
    @DisplayName("Проверка на существование треугольника")
    void TriangleNegativeTest3() {
        double result = 0;
        try {
            result = triangleArea(1,1,6);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(result, NaN);

    }
}


