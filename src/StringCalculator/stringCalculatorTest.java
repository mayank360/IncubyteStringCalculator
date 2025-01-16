package StringCalculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class stringCalculatorTest {
    @Test
    public void addTest(){

        Assertions.assertEquals(add(""), 0);
        Assertions.assertEquals(add("1"), 1);
        Assertions.assertEquals(add("5"), 5);
        Assertions.assertEquals(add("1,2"), 3);
        Assertions.assertEquals(add("1,2,4,3"), 10);
        Assertions.assertEquals(add("1\n2,3,4"), 10);
        Assertions.assertEquals(add("1\n2,3\n4"), 10);
    }

    private int add(String s) {
        int sum = 0;
        if(!s.isEmpty()) {
            s = s.replace("\n", ",");
            String[] numbers = s.split(",");
            for (String num : numbers)
                sum += Integer.parseInt(num);
        }
        return sum;
    }
}
