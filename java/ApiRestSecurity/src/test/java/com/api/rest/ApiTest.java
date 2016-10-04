package com.api.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    private TestRestTemplate restTemplate;

    @Test
    public void test(){

        String answer = restTemplate.getForEntity("/user",String.class,"sfr").toString();

        System.out.println("respuesta : "+answer);

    }
}
