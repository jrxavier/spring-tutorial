package guru.springframework.springtutorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTutorialApplicationTests {

    @Test
    public void contextLoads() {

        System.out.printf("Vanessa e legal!!!");
    }

}