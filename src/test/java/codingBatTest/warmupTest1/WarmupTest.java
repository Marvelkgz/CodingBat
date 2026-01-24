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
    void monkeyTrouble(){
        Assertions.assertTrue(warmup1.monkeyTrouble(false,true));
        Assertions.assertTrue(warmup1.monkeyTrouble(false,false));
        Assertions.assertFalse(warmup1.monkeyTrouble(true,false));
        Assertions.assertFalse(warmup1.monkeyTrouble(false,true));
    }
}
