package com;

import com.view.Main;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void test() {
        System.out.println("TEST");
    }

    @Test
    public void Variable() {
        assertNotNull(Main.DEBUG);
    }
}