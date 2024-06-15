package com.cbsingh.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCode502_IPOTest {

    LeetCode502_IPO classUnderTest;

    @BeforeEach
    void setUp() {
        classUnderTest = new LeetCode502_IPO();
    }

    @Test
    void findMaximizedCapital() {
        //Test case1 k=2, w=0, profits={1,2,3}, capital={0,1,1}, should return 4
        var result = classUnderTest.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
        assertEquals(4, result);
    }
}