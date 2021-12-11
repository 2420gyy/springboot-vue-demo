package com.chen.managesystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootManageSystemApplicationTests {

    @Test
    void contextLoads() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,null);
        map.put(3,"c");
        System.out.println(map.get(2));
        System.out.println("----");
        // 若key对应的value为空，会将第二个参数的返回值存入并返回
        System.out.println("]"+map.computeIfAbsent(2,k-> new String("222"))+"[");
        System.out.println("===");
        System.out.println(map.get(2));
        System.out.println(map.get(3));
    }

}
