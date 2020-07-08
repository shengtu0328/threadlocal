package L2_2;

/**
 * @Author: rqxiao
 * @Date: 2020-3-17 17:21
 * @Description:
 */
public class Test4 {

    // ThreadLocal<T>这个变量看上去是static  实际上是属于某一个线程的 ,不同线程去访问得到的值是不一样的
    public static ThreadLocal<Long> x = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            System.out.println("Initial Value run.." + Thread.currentThread().getId());
            return Thread.currentThread().getId();
        }
    };

    public static void main(String[] args) {
        //new Thread 线程
        new Thread() {
            @Override
            public void run() {
                System.out.println("new Thread：" + x.get());
            }
        }.start();

        //main方法线程
        x.set(107L);
        x.remove();
        System.out.println("main方法线程：" + x.get());

    }

}