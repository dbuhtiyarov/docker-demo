package com.example.demo.services;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionServiceTests {
    @Test
    public void createThreadsTest() {
        assertEquals(1, ActionService.createThread(1));
        assertEquals(100, ActionService.createThread(100));
        assertEquals(250, ActionService.createThread(250));
    }

    @Test
    public void runGCTest() {
        assertEquals(0, ActionService.gc());
    }

    @Test
    public void runRamTest() {
        assertArrayEquals(new byte[1024 * 1024 * 100], ActionService.loadRam(100));
        assertArrayEquals(new byte[1024 * 1024 * 1024], ActionService.loadRam(1024));
    }

    @Test
    public void runCpuTest() {
        assertEquals(0, ActionService.loadCpu(5));
    }
}
