package com.biggw.join.fight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author gw
 * @date 2019/12/12 0012 下午 13:27
 */
public class FightQueryExample {
    private static List<String> fightCompany = Arrays.asList("重庆航空","天津航空","四川航空");

    public static void main(String[] args) {
        List<String> results = search("重庆", "上海");
        System.out.println("============= results ============");
        results.forEach(System.out::println);
    }

    private static List<String> search(String origin, String dest){
        final List<String> results = new ArrayList<>();

        List<Thread> tasks = fightCompany.stream().map(airline -> createSearchTask(origin, dest, airline)).collect(toList());
        // todo 非静态方法
        tasks.forEach(Thread::start);
        for (Thread task : tasks) {
            try {
                task.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        tasks.stream().map(FightQuery::get).forEach(results::addAll);
        return results;
    }

    private static FightQueryTask createSearchTask(String origin, String dest, String airline){
        return new FightQueryTask(origin, dest, airline);
    }
}
