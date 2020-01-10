package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import static ru.stqa.sandbox.MyFirstProgram.LogicHW;

public class UnitTests {

    @Test
    public void test0(){
        String s = "Hallo, Welt";
        Assert.assertTrue(LogicHW(s));
    }
    @Test
    public void NegativeDotX(){
        PointStart x = new PointStart(-1,-1);
        Assert.assertEquals(x.x2x1(),0);
    }
}
