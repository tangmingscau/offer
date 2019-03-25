package com.tangm.designmode;

/**
 * @author tony
 * @date 2019/3/8
 */
public class FactoryMode {
    public static void main(String[] args) {
        CarFactory factory=new baoMaX1();
        factory.createEngine();
    }
    public static interface CarFactory{
        /**
         * 发送机
         */
        void createEngine();
    }
    public static class baoMaX1 implements CarFactory{

        @Override
        public void createEngine() {
            System.out.println("汽油发动机");
        }
    }
    public static class G3 implements CarFactory{

        @Override
        public void createEngine() {
            System.out.println("电动机");
        }
    }
}
