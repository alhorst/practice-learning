package com.techelevator;
import org.junit.*;

import java.math.BigDecimal;

public class PCTest {

    @Test
    public void test_price_for_configuration_nitel_8_eonrad() {
        PC pc1 = new PC("NITEL", "8", "EONRAD");

        BigDecimal expected = new BigDecimal("1850");

        BigDecimal actual = pc1.getPrice();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_offerDiscount_saversClub_true_return_150_off() {
        PC pc2 = new PC("DAM", "16", "FORCEG");

        boolean expected = true;

        boolean actual = pc2.offerDiscount(pc2, true);

        Assert.assertEquals(expected, actual);

    }

}
