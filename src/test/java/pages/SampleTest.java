package pages;

import org.junit.Test;


public class SampleTest {

    @Test
    public void  main() {
        System.out.println("Hello");
        AbstractTest test = new AbstractTest();
        test.createDriver();
        test.openBrowser();
    }
}
