package com.wxb.mp.test;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CopyTest2 {
    public String outerName;
    public CopyTest2.InnerClass innerClass;
    public List<CopyTest2.InnerClass> classList;

    @Data
    @ToString
    public static class InnerClass {
        public String innerName;
    }
}