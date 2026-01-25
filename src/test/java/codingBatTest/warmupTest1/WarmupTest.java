package codingBatTest.warmupTest1;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WarmupTest extends BaseWarmupTest {

    @Test
    void sleepIn(){
        assertTrue(warmup1.sleepIn(false,false));
        assertFalse(warmup1.sleepIn(true,false));
        assertTrue(warmup1.sleepIn(false,true));
        assertTrue(warmup1.sleepIn(true,true));
    }

    @Test
    void sumDouble(){
        assertEquals(warmup1.sumDouble(2,2),8);
        assertEquals(warmup1.sumDouble(1,2),3);
        assertEquals(warmup1.sumDouble(3,3),12);
    }

    @Test
void diff21(){
        assertEquals(warmup1.diff21(19),2);
        assertEquals(warmup1.diff21(23),4);
    }

    @Test
    void parrotTrouble(){
        assertTrue(warmup1.parrotTrouble(true,6));
        assertFalse(warmup1.parrotTrouble(false,8));
        assertTrue(warmup1.parrotTrouble(true,7));
        assertFalse(warmup1.parrotTrouble(false,23));
    }

    @Test
    void makes10(){
        assertTrue(warmup1.makes10(9,10));
        assertFalse(warmup1.makes10(99,99));
        assertTrue(warmup1.makes10(3,7));
        assertFalse(warmup1.makes10(2,12));
    }

    @Test
    void posNeg(){
        assertTrue(warmup1.posNeg(1,-1,false));
        assertTrue(warmup1.posNeg(-2,-1,true));
        assertFalse(warmup1.posNeg(1,-1,true));
    }

    @Test
    void notString(){
        assertEquals(warmup1.notString("candy"),"not candy");
        assertEquals(warmup1.notString("x"),"not x");
        assertEquals(warmup1.notString("not"),"not not");
        assertEquals(warmup1.notString("no"),"not no");
    }


   @Test
    void nearHundred(){
        assertTrue(warmup1.nearHundred(93));
        assertTrue(warmup1.nearHundred(110));
        assertFalse(warmup1.nearHundred(111));
        assertFalse(warmup1.nearHundred(121));
   }
    @Test
    void missingChar(){
        assertEquals(warmup1.missingChar("kitten",1),"ktten");
        assertEquals(warmup1.missingChar("kitten",0),"itten");
        assertEquals(warmup1.missingChar("kitten",4),"kittn");
        assertEquals(warmup1.missingChar("Hi",0),"i");
        assertEquals(warmup1.missingChar("code",0),"ode");
    }

    @Test
    void frontBack(){
        assertEquals(warmup1.frontBack("code"),"eodc");
        assertEquals(warmup1.frontBack("a"),"a");
        assertEquals(warmup1.frontBack("ab"),"ba");
        assertEquals(warmup1.frontBack(""),"");
        assertEquals(warmup1.frontBack("Chocolate"),"ehocolatC");
        assertEquals(warmup1.frontBack("hello"),"oellh");
    }
}
