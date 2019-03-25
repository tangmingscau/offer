package com.tangm.designmode;

/**
 * 装饰着模式
 * 适合有主体，附加值。
 * 比如说烧饼是主体，鸡蛋，火腿肠之类是是佐料附加值
 * @author tony
 * @date 2019/3/7
 */
public class DeckerMode {
    public static void main(String[] args) {
        Pancake roujiamo=new Roujiamo();
        roujiamo=new FiredEgg(roujiamo);
        roujiamo=new Ham(roujiamo);
        System.out.println(String.format("%s ￥%s", roujiamo.getDesc(), roujiamo.price()));
    }

    public static abstract class Pancake {

        public String desc = "我不是一个具体的煎饼";

        public String getDesc() {
            return desc;
        }

        public abstract double price();
    }

    public static class Roujiamo extends Pancake {

        public Roujiamo() {
            desc = "肉夹馍";
        }

        @Override
        public double price() {
            return 6;
        }

    }

    public static abstract class Condiment extends Pancake {
        @Override
        public abstract String getDesc();

    }

    public static class FiredEgg extends Condiment {
        private Pancake pancake;

        public FiredEgg(Pancake pancake) {
            this.pancake = pancake;
        }

        @Override
        public String getDesc() {
            return pancake.getDesc() + ", 煎蛋";
        }

        @Override
        public double price() {
            return pancake.price() + 2;
        }

    }

    public static class Ham extends Condiment {
        private Pancake pancake;

        public Ham(Pancake pancake) {
            this.pancake = pancake;
        }

        @Override
        public String getDesc() {
            return pancake.getDesc() + ", 火腿片";
        }

        @Override
        public double price() {
            return pancake.price() + 1.5;
        }

    }
}
