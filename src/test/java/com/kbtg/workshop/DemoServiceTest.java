package com.kbtg.workshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DemoServiceTest {
    private String myName = "Hello";

    @Test
    @DisplayName("แรนด้อมต้องได้ค่า 5")
    public void random_5() {
        Random random = new Random5();
        DemoService demoService = new DemoService();

//      Assert True
        demoService.setRandom(random);
        String actual = demoService.generateData(this.myName);
        assertEquals(actual, this.myName+5);

//      Assert Throws
        random = new Random1();
        demoService.setRandom(random);

        assertThrows(RuntimeException.class, () -> {
            demoService.generateData(this.myName);
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

