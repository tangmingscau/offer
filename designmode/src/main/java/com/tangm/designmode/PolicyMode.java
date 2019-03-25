package com.tangm.designmode;

/**
 * 策略模式
 *
 * @author tony
 * @date 2019/3/6
 */
public class PolicyMode {
    public static void main(String[] args) {
        Environment environment = new Environment(new Add());
        environment.calulate(1, 2);
    }

    public static class Environment {
        private Calu calu;

        public Environment(Calu calu) {
            this.calu = calu;
        }

        public int calulate(int a, int b) {
            return calu.calu(a, b);
        }
    }

    public interface Calu {
        public int calu(int a, int b);
    }

    public static class Add implements Calu {

        @Override
        public int calu(int a, int b) {
            return a + b;
        }
    }

    public static class Minus implements Calu {

        @Override
        public int calu(int a, int b) {
            return a - b;
        }
    }

}
