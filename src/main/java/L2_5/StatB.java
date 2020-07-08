package L2_5;

import java.util.HashSet;

/**
 * @Author: rqxiao
 * @Date: 2020-3-18 17:12
 * @Description:
 */
public class StatB {



    //不能用Integer 的value, 因为 在init中如果存放的 Integer 但是后来累加的时候 ThreadLocal里的Integer值不会变,本质原因是 Integer是 final修饰 ，当然int也不行
    static HashSet<Val<Integer>> set = new HashSet<Val<Integer>>();

    synchronized static  void addSet(Val<Integer> val){
        set.add(val);
    }

    static ThreadLocal<Val<Integer>> c = new ThreadLocal<Val<Integer>>() {
        @Override
        protected Val<Integer> initialValue() {
            Val<Integer> val = new Val<Integer>();
            val.setV(0);
//            set.add(val);
            addSet(val);
            return val;
        }
    };

    public void add() throws InterruptedException {
        Val<Integer> val = c.get();
        val.setV(val.getV() + 1);
    }


    public static void main(String[] args) throws InterruptedException {


        StatB stat = new StatB();
        for (int i = 0; i <9900; i++) {
            ThreadB a = new ThreadB(stat);
            a.start();
        }


        Thread.sleep(4000);
        System.out.println(set.size());

        System.out.println(set.stream().map(x -> x.getV()).reduce((sum, a) -> sum + a).get());


    }


}
