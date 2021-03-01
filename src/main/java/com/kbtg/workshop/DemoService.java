package com.kbtg.workshop;

import java.util.Random;

public class DemoService {
    private Random random;

    public void setRandom(Random random) {
        this.random = random;
    }

    public String generateData(String name) {
        int number = this.random.nextInt(10);

        if (number >= 5 && number <= 8) {
            return name + number;
        }
        throw new RuntimeException("Invalid number with " + number);
    }

//    public static void main(String[] args) {
//        DemoService demoService = new DemoService();
//        System.out.println(demoService.generateData("hello"));
//    }
}
