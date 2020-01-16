package com.study.repository.high.concurrence.aqs;import lombok.extern.slf4j.Slf4j;import java.util.concurrent.*;/** * @author * @description * @date 2020/1/16 */@Slf4jpublic class FutureTest {    static class MyCallable implements Callable<String> {        @Override        public String call() throws Exception {            log.info("开始处理");            Thread.sleep(2000);            return "成功";        }    }    public static void main(String[] args) throws ExecutionException, InterruptedException {        //启动线程        ExecutorService executorService = Executors.newCachedThreadPool();        Future<String> future = executorService.submit(new MyCallable());        log.info("等待线程处理结果");        String result = future.get();        log.info("result {}", result);        executorService.shutdown();    }}