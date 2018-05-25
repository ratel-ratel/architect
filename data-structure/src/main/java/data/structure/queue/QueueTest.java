package data.structure.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by nice on 2018/5/25.
 */
@Slf4j
@Service
@EnableScheduling
public class QueueTest {
    BlockingQueue<String> basket = new ArrayBlockingQueue<String>(20);

    /**
     *
     *
     *基本上，一个队列就是一个先入先出（FIFO）的数据结构
     * 任务模拟 kafka 实现一个队列
     *
     */
    @Scheduled(cron = "0 8 17 * * *")
    public void addTest() {
        for (int i = 0; i < 10; i++) {
            this.addApple();
            try {
               Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("成功放入所有🍎");
    }

    public void addApple() {
        boolean add = basket.add("An apple   "+System.currentTimeMillis());
        if (add) {
            log.info("成功放入一个🍎-------");
        }else {
            new Exception("批量添加失败");
        }
    }

    @Scheduled(cron = "0 9 17 * * *")
    public void takeTest() {
        // get方法取出一个苹果，若basket为空，等到basket有苹果为止
        for (int i = 0; i < 10; i++) {
            try {
                String apple = basket.take();
                log.info("成功取出    🍎  "+apple);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
