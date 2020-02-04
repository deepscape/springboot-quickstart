package com.rubypaper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BinaryTest {

    @Test
    public void test() {

        int width = 44;
        byte [] data = new byte [2];

        data[0] = (byte) ((width >> 8) & 0xFF);
        data[1] = (byte) (width & 0xFF);

        for(int b = 0; b < 2; b++) {
            System.out.println("printing byte " + b);
            for(int i = 7; i >= 0; i--) {
                System.out.print(data[b] & 1);
                data[b] = (byte) (data[b] >> 1);
            }
        }

    }
}
