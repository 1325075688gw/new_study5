package com.biggw.join.fight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author gw
 * @date 2019/12/12 0012 下午 12:35
 */
public class FightQueryTask extends Thread implements FightQuery{
    private final String origin;
    private final String destination;
    private final List<String> fightList = new ArrayList<>();

    public FightQueryTask(String origin, String destination,String airLine) {
        super("["+airLine+"]");
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.printf(" %s: 出发地：%s ----终点：%s ",getName(),this.origin,this.destination);
        int random = ThreadLocalRandom.current().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(random);
            this.fightList.add(getName()+"-"+random);
            System.out.println(getName() + "航班信息查询完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<String> get(Thread thread) {
        return this.fightList;
    }
}
