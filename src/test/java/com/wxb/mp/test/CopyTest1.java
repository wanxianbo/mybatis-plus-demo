package com.wxb.mp.test;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@ToString
public class CopyTest1 {
    public String outerName;
    public CopyTest1.InnerClass innerClass;
    public List<CopyTest1.InnerClass> classList;

    @Data
    @ToString
    public static class InnerClass {
        public String innerName;
    }

    public static void main(String[] args) {
        CopyTest1 copyTest1 = new CopyTest1();
        copyTest1.setOuterName("hahaha");
        CopyTest1.InnerClass innerClass = new CopyTest1.InnerClass();
        innerClass.setInnerName("hohoho");
        copyTest1.setInnerClass(innerClass);
        System.out.println(copyTest1);

        CopyTest2 copyTest2 = new CopyTest2();
        copyTest2.innerClass = new CopyTest2.InnerClass();
        BeanUtils.copyProperties(copyTest1.innerClass,copyTest2.innerClass);
        BeanUtils.copyProperties(copyTest1, copyTest2);
        System.out.println(copyTest2);

    }
}
