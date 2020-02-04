package com.rubypaper;

import com.rubypaper.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardControllerTest2 {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHello() throws Exception {
        String result = restTemplate.getForObject("/hello?name=thomas", String.class);
        assertEquals("Hello : thomas", result);
    }

    @Test
    public void testGetBoard() throws Exception {
        BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
        assertEquals("테스터", board.getWriter());
    }
}
