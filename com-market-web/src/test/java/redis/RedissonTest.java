package redis;

import com.market.stock.redis.RedissionManagerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.Key;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lijinpeng on 2019/4/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/spring-context.xml"})
public class RedissonTest {
    @Autowired
    private RedissionManagerService redissionService;

    @Test
    public void getKeysTest() {
        String pattern = "bestpay-*";
        List<String> allKeys = redissionService.getAllKeys(pattern);
        int count = 0;
        for (String key : allKeys) {
            ++count;
            System.out.println("key:" + key + " value:" + redissionService.getValue(key));
        }
        System.out.println("发现key:" + count + "个");
    }

    @Test
    public void deleteKeys() {
        String pattern = "bestpay-*";
        boolean result = redissionService.deleteKeys(pattern);
        System.out.println("删除结果:" + result);
    }

    @Test
    public void getHmapDatatTest() {
//        RMap<String, > rMap = redissionService.getValue("person-001");
//        System.out.println(rMap.get("name"));
    }

}
