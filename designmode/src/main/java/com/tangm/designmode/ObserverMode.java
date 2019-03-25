package com.tangm.designmode;

import java.util.ArrayList;

/**
 * 观察者模式
 *
 * @author tony
 * @date 2019/3/7
 */
public class ObserverMode {
    public static void main(String[] args) {
        RealObservable observable=new RealObservable();
        observable.register(new AObserver());
        observable.register(new BObserver());
        observable.notifyObserver();
    }
    public static class RealObservable extends Observable{
        ArrayList<Observer> mObservers=new ArrayList<>();
        @Override
        void register(Observer observer) {
            mObservers.add(observer);
        }

        @Override
        void unregister(Observer observer) {
            mObservers.remove(observer);
        }

        @Override
        void notifyObserver() {
            for (Observer observer:mObservers){
                observer.read("notify");
            }
        }
    }
    public static class AObserver extends Observer{

        @Override
        void read(String message) {
            System.out.println("AObserver read "+message);
        }
    }
    public static class BObserver extends Observer{

        @Override
        void read(String message) {
            System.out.println("BObserver read "+message);
        }
    }

    /**
     * 被观察者
     */
    public static abstract class Observable {
        abstract void register(Observer observer);

        abstract void unregister(Observer observer);

        abstract void notifyObserver();
    }

    /**
     * 订阅者
     */
    public static abstract class Observer {
        abstract void read(String message);
    }

}
