package com.kbtg.workshop.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserControllerSpringBootTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getUserById() {
        // Call API
        UserResponse response = restTemplate.getForObject("/user/1", UserResponse.class);

        // Assert
        assertEquals(1,response.getId());
        assertEquals("test",response.getName());
        assertEquals(30,response.getAge());

        UserResponse expected = new UserResponse(1, "test", 30);
        assertEquals(expected, response);
    }
}