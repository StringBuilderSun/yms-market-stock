package com.market.stock.threadTasks;

import lombok.Getter;
import lombok.Setter;
import org.redisson.Redisson;

import java.util.concurrent.Callable;

/**
 * Created by lijinpeng on 2019/3/29.
 */
@Setter
@Getter
public class SpeedKillTask implements Callable<String> {
    /**
     * 用户id
     */
    private String uname;
    /**
     * 用户抢到结果
     */
    private String result;
    private Redisson redisson;

    public SpeedKillTask(String uname, Redisson redisson) {

        this.uname = uname;
        this.redisson = redisson;
    }

    public String call() throws Exception {
        GetSpeekGood speekGood = new GetSpeekGood();
        return uname + ":" + speekGood.getGoods("spell_count", redisson,uname);
    }
}
