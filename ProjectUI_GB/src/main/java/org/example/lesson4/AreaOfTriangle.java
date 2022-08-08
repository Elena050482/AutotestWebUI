package org.example.lesson4;



public class AreaOfTriangle {

    public static void main(String[] args) throws Exception {

       double s = triangleArea(1, 1, 6);
       System.out.println("Triangle's area is:" + s);


    }

    public static double triangleArea(int a, int b, int c ) throws Exception {
        if (a<=0 || b<=0 || c<=0) {
            throw new Exception ("Значения сторон меньше 1");
        }

        if ((a + b) > c & (b + c) > a & (c + a) > b)
        { System.out.println("Треугольник существует."); }
        else { System.out.println("Треугольник не существует."); }

        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}



