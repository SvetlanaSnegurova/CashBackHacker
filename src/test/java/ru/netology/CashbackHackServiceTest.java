package ru.netology;

import org.junit.Test;

import static org.junit.Assert.*;

public class CashbackHackServiceTest {

    @Test
    public void amountEqualLimit() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1000;
        int expected = 0;
        int actual = service.remain(amount);
        assertEquals(expected, actual);
    }

    @Test
    public void AmountLessAccrualLimit() {
        CashbackHackService service = new CashbackHackService();
        int amount = 999;
        int expected = 1;
        int actual = service.remain(amount);
        assertEquals(expected, actual);
    }

    @Test
    public void AmountGreaterAccrualLimit() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1001;
        int expected = 999;
        int actual = service.remain(amount);
        assertEquals(expected, actual);
    }

    @Test
    public void AmountAndOverLimit() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1_000_000;
        int expected = 0;
        int actual = service.remain(amount);
        assertEquals(expected, actual);
    }

    @Test
    public void AmountAndUnderLimit() {
        CashbackHackService service = new CashbackHackService();
        int amount = 300;
        int expected = 700;
        int actual = service.remain(amount);
        assertEquals(expected, actual);
    }
}