package codingBatTest.warmupTest1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WarmupTest extends BaseWarmupTest {

    @Test
    void sleepIn(){
        Assertions.assertTrue(warmup1.sleepIn(false,false));
        Assertions.assertFalse(warmup1.sleepIn(true,false));
        Assertions.assertTrue(warmup1.sleepIn(false,true));
        Assertions.assertTrue(warmup1.sleepIn(true,true));
    }

    @Test
    void sumDouble(){
        Assertions.assertEquals(warmup1.sumDouble(2,2),8);
        Assertions.assertEquals(warmup1.sumDouble(1,2),3);
        Assertions.assertEquals(warmup1.sumDouble(3,3),12);
    }

    @Test
void diff21(){
        Assertions.assertEquals(warmup1.diff21(19),2);
        Assertions.assertEquals(warmup1.diff21(23),4);
    }

    @Test
    void parrotTrouble(){
        Assertions.assertTrue(warmup1.parrotTrouble(true,6));
        Assertions.assertFalse(warmup1.parrotTrouble(false,8));
        Assertions.assertTrue(warmup1.parrotTrouble(true,7));
        Assertions.assertFalse(warmup1.parrotTrouble(false,23));
    }
}
