package com.tangm.designmode;

/**
 * 模板模式
 * 实现方式：
 * <p>
 * a)     父类模板类（规定要执行的方法和顺序，只关心方法的定义及顺序，不关心方法实现）
 * <p>
 * b)     子类实现类（实现a规定要执行的方法，只关心方法实现，不关心调用顺序）
 *
 * @author tony
 * @date 2019/3/8
 */
public class TempletMode {

    public static void main(String[] args) {
        HouseTemplate houseTemplate = new HouseOne();
        houseTemplate.buildHouse();
        houseTemplate = new HouseTwo();
        houseTemplate.buildHouse();
    }

    public static abstract class HouseTemplate {
        abstract void window();

        abstract void door();

        abstract void stair();

        public void buildHouse() {
            window();
            door();
            stair();
        }
    }

    public static class HouseOne extends HouseTemplate {

        @Override
        void window() {
            System.out.println("透明窗");
        }

        @Override
        void door() {
            System.out.println("木门");
        }

        @Override
        void stair() {
            System.out.println("木楼梯");
        }
    }

    public static class HouseTwo extends HouseTemplate {

        @Override
        void window() {
            System.out.println("透明窗");
        }

        @Override
        void door() {
            System.out.println("铁门");
        }

        @Override
        void stair() {
            System.out.println("瓷砖楼梯");
        }
    }

}
