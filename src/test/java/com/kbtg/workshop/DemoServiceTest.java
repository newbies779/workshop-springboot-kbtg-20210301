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
        DemoService demoService = new DemoService();

//      Assert True
        demoService.setRandom(new Random5());
        String actual = demoService.generateData(this.myName);
        assertEquals(actual, this.myName+5);
    }

    @Test
    @DisplayName("แรนด้อมต้อง Throws")
    public void random_1() {

        DemoService demoService = new DemoService();

//      Assert Throws
        demoService.setRandom(new Random1());
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

