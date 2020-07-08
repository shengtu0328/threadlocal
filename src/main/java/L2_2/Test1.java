package L2_2;

/**
 * @Author: rqxiao
 * @Date: 2020-7-6 13:35
 * @Description:
 */
public class Test1 {


    public static ThreadLocal<Long> x = new ThreadLocal<Long>();


    public static void main(String[] args) {
        System.out.println(x.get());
    }


}
