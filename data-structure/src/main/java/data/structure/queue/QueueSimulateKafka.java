package data.structure.queue;

import data.structure.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 队列模仿kafka
 * Created by nice on 2018/5/28.
 */
@Slf4j
@Service
public class QueueSimulateKafka {
    private BlockingQueue<String> basket = new ArrayBlockingQueue<String>(20);

    public BlockingQueue<String> getBasket() {
        return basket;
    }

    public void setBasket(BlockingQueue<String> basket) {
        this.basket = basket;
    }

    @Scheduled(cron = "0/2 * * * * *")
    public void addApple() {
        String apple = "An apple   " + DateUtil.formatDate(new Date(), DateUtil.YEAR_MONTH_DAY_HH_MM_SS);
        boolean add = basket.add(apple);
        if (add) {
            log.info("放入         ---"+apple);
        } else {
            new Exception("批量添加失败");
        }
    }

    @Scheduled(cron = "0/3 * * * * *")
    public void takeTest() {
        try {
            String apple = basket.take();
            log.info("取出    🍎  " + apple);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
