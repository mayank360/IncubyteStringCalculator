package StringCalculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class stringCalculatorTest {
    @Test
    public void addTest(){
        try {
            Assertions.assertEquals(add(""), 0);
            Assertions.assertEquals(add("1"), 1);
            Assertions.assertEquals(add("5"), 5);
            Assertions.assertEquals(add("1,2"), 3);
            Assertions.assertEquals(add("1,2,4,3"), 10);
            Assertions.assertEquals(add("1\n2,3,4000"), 6);
            Assertions.assertEquals(add("1\n2,3\n4"), 10);
            Assertions.assertEquals(add("//[;]\n1;2;3;4"), 10);
            Assertions.assertEquals(add("//[;]\n1\n2;3\n4000"), 6);
            Assertions.assertEquals(add("//[***]\n1***2***3***4"), 10);
            Assertions.assertEquals(add("//[***]\n1\n2***3\n4000"), 6);
            Assertions.assertEquals(add("//[*][%]\n1*2%3"), 6);
            Assertions.assertEquals(add("//[**][%%%][@#]\n1**2%%%3@#4"), 10);

            Assertions.assertEquals(add("//[;]\n1\n2;3\n-40;-6"), "exception");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private int add(String s) {
        int sum = 0;
        if(!s.isEmpty()) {

            if(s.contains("["))
                s = getModifiedString(s);

            else
                s = s.replace(",", "\n");

            String[] numbers = s.split("\n");
            List negatives = new ArrayList();

            for (String num : numbers) {
                int n = Integer.parseInt(num);
                if (n < 0)
                    negatives.add(num);
                if(n<=1000)
                    sum += n;
            }
            if(!negatives.isEmpty())
                throw new RuntimeException("negatives not allowed : " + negatives);
        }
        return sum;
    }

    private static String getModifiedString(String s) {
        String[] parts = s.substring(0, s.indexOf("\n")).split("]");
        s = s.substring(s.indexOf("\n") + 1);

        for(String part:parts) {
            String delim = part.substring(part.indexOf("[") + 1);
            s = s.replace(delim,"\n");
        }
        return s;
    }
}
