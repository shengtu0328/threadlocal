package L2_4;

/**
 * @Author: rqxiao
 * @Date: 2020-3-18 17:26
 * @Description:
 */
public class ThreadA extends Thread{

    private StatA stat;
    //省略构造方法
    @Override
    public void run() {
        super.run();
        try {
            stat.add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ThreadA( StatA stat) {
        this.stat = stat;
    }
}
