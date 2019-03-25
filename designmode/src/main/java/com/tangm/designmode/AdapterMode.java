package com.tangm.designmode;

/**
 * 适配器模式
 *
 * @author tony
 * @date 2019/3/7
 */
public class AdapterMode {
    public static void main(String[] args) {
        //类适配器模式
        Ps2 ps2 = new Adapter();
        ps2.ps2();

        //接口适配器模式
        B b = new AdapterB();
        b.a();
    }

    public static interface Usb {
        void usb();
    }

    public static interface Ps2 {
        void ps2();
    }

    public static class User implements Usb {

        @Override
        public void usb() {

        }
    }

    public static class Adapter extends User implements Ps2 {

        @Override
        public void ps2() {
            usb();
        }
    }

    public static interface A {
        void a();

        void b();

        void c();
    }

    public static abstract class B implements A {

        @Override
        public void a() {

        }

        @Override
        public void b() {

        }

        @Override
        public void c() {

        }
    }

    public static class AdapterB extends B {
        @Override
        public void a() {
            super.a();
        }
    }
}
