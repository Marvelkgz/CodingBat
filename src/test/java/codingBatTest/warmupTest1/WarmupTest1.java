package codingBatTest.warmupTest1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WarmupTest1 extends BaseTest {

    @Test
    void sleepIn(){
        Assertions.assertTrue(warmup1.sleepIn(false,false));
        Assertions.assertFalse(warmup1.sleepIn(true,false));
        Assertions.assertTrue(warmup1.sleepIn(false,true));
        Assertions.assertTrue(warmup1.sleepIn(true,true));

    }
}
