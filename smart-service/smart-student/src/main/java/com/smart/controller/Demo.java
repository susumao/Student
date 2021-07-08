package com.smart.controller;

import com.szxysoft.commons.utils.MsConvertPdfUtils;
import com.szxysoft.commons.utils.PDFUtils;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    /**
     * 定义一个对象，这里使用了lombok的注解
     */
    @Data
    @Accessors(chain = true)
    static class Good {
        private String name;
        private Integer total;
    }

    public static class Test4 {
        public static void main(String[] args) {
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put("1","2");
            objectObjectHashMap.put("1","3");
            System.out.println(objectObjectHashMap.get("1"));

            List<Good> list = new ArrayList<>();
            // 创建几个对象放在list集合中
            list.add(new Good().setName("xiaomi").setTotal(2));
            list.add(new Good().setName("huawei").setTotal(2));
            list.add(new Good().setName("apple").setTotal(2));
            list.add(new Good().setName("xiaomi").setTotal(2));


            Collection<List<Good>> collect1 = list.stream()
                    // 根据name进行分组
                    .collect(Collectors.groupingBy(Good::getName)).values();
                    /*.entrySet()
                    .stream()
                    .map(entry -> {
                        String key = entry.getKey();
                        List<Good> value = entry.getValue();
                        Integer sum = value.stream().mapToInt(Good::getTotal).sum();
                        return new Good().setName(key).setTotal(sum);
                    })*/
                    // 根据total倒序排序
//                    .sorted(Comparator.comparing(Good::getTotal).reversed())
//                    .collect(Collectors.toList());
            System.out.println(collect1.toString());
            System.out.println(sum(100L));
            Random random = new Random();
            List<Integer> lists = new ArrayList<>();
            for (int i = 0; i < lists.size(); i++) {

            }
            for (int i = 0; i < 100; i++) {
                int j = random.nextInt(100);
                if (!lists.contains(j)){
                    for (int k = 0; k < lists.size(); k++) {
                        lists.add(j);
                    }
                }
            }
            System.out.println(lists.toString());
        }

        public static Long sum(Long i){
            if (i == 0){
                return 1L;
            }else {
                return i+sum(i-1);
            }
        }

    }


}
