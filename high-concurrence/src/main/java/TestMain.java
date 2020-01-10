import lombok.extern.slf4j.Slf4j;import java.util.concurrent.ExecutorService;import java.util.concurrent.Executors;import java.util.concurrent.Semaphore;/** * @author * @description * @date 2020/1/10 */@Slf4jpublic class TestMain {    public static int count = 0;    public static void main(String[] args) {        ExecutorService executorService = Executors.newCachedThreadPool();        final Semaphore semaphore = new Semaphore(200);        for (int i = 0; i < 5000; i++) {            executorService.execute(() -> {                try {                    semaphore.acquire();                    add();                    semaphore.release();                } catch (InterruptedException e) {                    e.printStackTrace();                }            });        }        executorService.shutdown();        log.info("{}", count);    }    public static void add() {        count++;    }}