package ru.stqa.sandbox;

public class MyFirstProgram
{
public static void main(String[] arg)
{
    String s = "Hi";
    String s1 = "Hallo";
    String s2 = "Hallo, Welt";
    System.out.println(LogicHW(s));
    System.out.println(LogicHW(s1));
    System.out.println(LogicHW(s2));
}
    public static boolean LogicHW(String a){
    if (a.equals("Hallo, Welt")){
        return true;
    } else
        return false;
    }
}