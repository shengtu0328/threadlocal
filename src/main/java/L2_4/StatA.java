package L2_4;

/**
 * @Author: rqxiao
 * @Date: 2020-3-18 17:12
 * @Description: 线程不安全 统计出错
 */
public class StatA {


    static Integer c = 0;

    public Integer stat() {
        return c;
    }
    public  Integer add() throws InterruptedException {
        Thread.sleep(100);
        c++;
        return 1;
    }


    public static void main(String[] args) throws InterruptedException {




        StatA stat=new StatA();
        for (int i = 0; i <100 ; i++) {

            ThreadA a = new ThreadA(stat);
            a.start();

        }
        Thread.sleep(25000);

        System.out.println(stat.stat());


    }



}
