package ru.netology;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CashbackHackServiceTest {

    @Test
    void amountEqualLimit() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1000;
        int expected = 0;
        int actual = service.remain(amount);
        assertEquals(actual, expected);
    }

    @Test
    void AmountLessAccrualLimit() {
        CashbackHackService service = new CashbackHackService();
        int amount = 999;
        int expected = 1;
        int actual = service.remain(amount);
        assertEquals(actual, expected);
    }

    @Test
    void AmountGreaterAccrualLimit() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1001;
        int expected = 999;
        int actual = service.remain(amount);
        assertEquals(actual, expected);
    }

    @Test
    void AmountAndOverLimit() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1_000_000;
        int expected = 0;
        int actual = service.remain(amount);
        assertEquals(actual, expected);
    }

    @Test
    void AmountAndUnderLimit() {
        CashbackHackService service = new CashbackHackService();
        int amount = 300;
        int expected = 700;
        int actual = service.remain(amount);
        assertEquals(actual, expected);
    }
}
