package com.newgen.sessions.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leetcode")
public class LeetCode {


    @GetMapping("/p1")
    public int getP1(@RequestParam Integer nums[], @RequestParam Integer val) {

        if (nums.length <= 0) return 0;
        int ar[] = new int[nums.length];

        int ind = 0;
        for (int i : nums) {
            if (i != val) {
                ar[ind++] = i;
            }
        }
        for (int i = 0; i < ind; i++) {
            nums[i] = ar[i];

        }
        return ind;
    }
}
