package demo;

import org.testng.annotations.Test;

public class TestingRegex {

    @Test(groups = "smoke")
    public void test_001UI(){
        System.out.println("A");
    }

    @Test
    public void test_002UI(){
        System.out.println("B");
    }

    @Test
    public void test_003API(){
        System.out.println("C");
    }

    @Test(groups = "smoke")
    public void test_004API(){
        System.out.println("D");
    }

}
