package L2_5;

/**
 * @Author: rqxiao
 * @Date: 2020-3-18 17:26
 * @Description:
 */
public class ThreadB extends Thread{

    private StatB stat;
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

    public ThreadB(StatB stat) {
        this.stat = stat;
    }
}
