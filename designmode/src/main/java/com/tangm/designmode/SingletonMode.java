package com.tangm.designmode;

/**
 * 单例模式
 * @author tony
 * @date 2019/3/6
 */
public class SingletonMode {
    public static void main(String[] args){

    }
    static class Holder {
        static final SingletonMode INSTANCE = new SingletonMode();
    }

    public static SingletonMode getInstance() {
        return Holder.INSTANCE;
    }
}
