package ims.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IssueControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void form(){
        ResponseEntity<String> responseEntity = template.getForEntity("/Issue", String.class);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }

}
