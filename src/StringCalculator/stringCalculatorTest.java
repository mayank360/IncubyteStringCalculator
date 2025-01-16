package StringCalculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class stringCalculatorTest {
    @Test
    public void addTest(){

        Assertions.assertEquals(add(""), 0);
        Assertions.assertEquals(add("1"), 1);
        Assertions.assertEquals(add("5"), 5);
    }

    private int add(String s) {
        if(s.isEmpty())
            return 0;
        return Integer.parseInt(s);
    }
}
