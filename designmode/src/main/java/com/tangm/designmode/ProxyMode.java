package com.tangm.designmode;

/**
 * @author tony
 * @date 2019/3/7
 */
public class ProxyMode {

    public static void main(String[] args) {
        ProxyObject proxyObject = new ProxyObject(new RealObject());
        proxyObject.operation();
    }
    public static abstract class AbstractObject {
        abstract void operation();
    }

    public static class RealObject extends AbstractObject {

        @Override
        void operation() {
            System.out.println("RealObject");
        }
    }

    public static class ProxyObject extends AbstractObject {
        AbstractObject mAbstractObject;

        public ProxyObject(AbstractObject abstractObject) {
            mAbstractObject = abstractObject;
        }

        @Override
        void operation() {
            if (mAbstractObject != null) {
                mAbstractObject.operation();
            }
        }
    }

}
