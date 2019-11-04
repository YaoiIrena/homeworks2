package ru.stqa.sandbox;

public class MyFirstProgram
{
public static void main(String[] arg)
{
    System.out.println("Hello, word!");
}
    PointStart pointStart = new PointStart(2,3);
    PointEnd pointEnd = new PointEnd(3,4);

        System.out.println("Расстояние от точки " + pointStart.x1 + " " + pointEnd.y1 + " и " + pointStart.x2 + " " + pointEnd.y2 + " = " + Math.sqrt((pointStart.x2x1() + pointEnd.y2y1())));

}