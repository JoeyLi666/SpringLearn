package cn.lsc.springboot_mybatis_plus;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        byte[] b = {-26, -127, -81};
//        byte[] b = {-28, -65, -95};
//
//        String s = new String(b);
//
//        System.out.println(s);

        String[] items = {"中", "信", "息", "技", "术", "部", "卡", "心"};
        for (String item : items) {
            byte[] bytes = item.getBytes(StandardCharsets.UTF_8);
            System.out.println(item + ":" + Arrays.toString(bytes));
        }

    }
}
