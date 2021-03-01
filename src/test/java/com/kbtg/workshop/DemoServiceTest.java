package com.kbtg.workshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DemoServiceTest {
    @Test
    @DisplayName("แรนด้อมต้องได้ค่า 5")
    public void random_5() {
        String myName = "Kanor";
        Random random = new Random5();
        DemoService demoService = new DemoService();

//      Assert True
        demoService.setRandom(random);
        String actual = demoService.generateData(myName);
        assertEquals(actual, myName+5);

//      Assert Throws
        random = new Random1();
        demoService.setRandom(random);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            String actualResult = demoService.generateData(myName);
        });
    }
}

class Random5 extends Random {
    @Override
    public int nextInt(int bound) {
        return 5;
    }
}


class Random1 extends Random {
    @Override
    public int nextInt(int bound) {
        return 1;
    }
}

