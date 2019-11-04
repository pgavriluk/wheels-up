package com.api.demo;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private static final String ENDPOINT = "https://marketingapi.wheelsup.com/api/initial-data";
    private static final String TWITTER_JSON_PATH = "$.keys.twitter";
    private static final String INSTAGRAM_JSON_PATH = "$.keys.instagram";

    @Test
    public void ApiTesting() {

        String twitter = "https://twitter.com/WheelsUp";
        String instagram = "http://instagram.com/wheelsup8760";

        verifySocialAccounts(twitter, instagram);

    }

    private void verifySocialAccounts(String twitter, String instagram) {
        //Get response as an object
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response = restTemplate.exchange(ENDPOINT, HttpMethod.GET, null, Object.class);

        //Assert that response code is 200
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        //Get value from twitter field
        String twitterValue = JsonPath.read(response.getBody(), TWITTER_JSON_PATH);
        //Get value from instagram field
        String instagramValue = JsonPath.read(response.getBody(), INSTAGRAM_JSON_PATH);

        //Assert that twitter and instagram values are equal to the values from the response
        assertEquals(twitter, twitterValue);
        assertEquals(instagram, instagramValue);

    }

}
