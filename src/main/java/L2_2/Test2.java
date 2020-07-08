package L2_2;

/**
 * @Author: rqxiao
 * @Date: 2020-7-6 13:35
 * @Description:
 */
public class Test2 {


    public static ThreadLocal<Long> x = new ThreadLocal<Long>() {

        @Override
        protected Long initialValue() {
            System.out.println("Initial Value run..");
            return 100L;
        }

    };


    public static void main(String[] args) {

        System.out.println("没get前");

        System.out.println(x.get());

        System.out.println(x.get());

        x.set(200L);

        System.out.println(x.get());

    }


}
