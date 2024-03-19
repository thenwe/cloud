package cn.itcast.order.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class util {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList();
        Stream.of("占山-22", "李四-24", "王五-22", "利尔-24", "周三-22").forEach(t -> aList.add(t));
        System.out.println(aList);
        aList.stream().map(s -> Integer.parseInt(s.split("-")[1])).forEach(s -> System.out.println(s));
        System.out.println(aList);
        String[] str = aList.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(str));
        List<String> collect = aList.stream().filter(s -> Integer.parseInt(s.split("-")[1]) > 22).collect(Collectors.toList());
        System.out.println(collect);
        //收集到map
        Map<String, String> collect1 = aList.stream().filter(s -> Integer.parseInt(s.split("-")[1]) > 22)
                .collect(Collectors.toMap(s -> s.split("-")[0], s -> s.split("-")[1]));
        System.out.println(collect1);
        aList.stream().map(String::hashCode);
    }
}
