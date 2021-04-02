package ashutest;

import org.junit.Test;

import static org.junit.Assert.*;

public class LISTest {

    @Test
    public void lengthOfLIS() {
        LIS lis = new LIS();
        lis.lengthOfLIS(new int [] { 10,9,2,5,3,7,101,18});
    }
}