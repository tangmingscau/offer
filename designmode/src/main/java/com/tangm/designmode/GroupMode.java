package com.tangm.designmode;

import java.util.ArrayList;

/**
 * 组合模式
 * 组合模式：组合多个对象形成树形结构以表示有整体-部分关系层次结构，
 * 组合模式可以让客户端统一对待单个对象和组合对象
 *
 * @author tony
 * @date 2019/3/8
 */
public class GroupMode {
    public static void main(String[] args) {
        AbstractFile abstractFile=new Folder();
        abstractFile.add(new File());
        abstractFile.add(new File());
        abstractFile.add(new File());
        abstractFile.kill();
    }

    public static abstract class AbstractFile {
        abstract void add(AbstractFile message);

        abstract void remove(AbstractFile message);

        abstract void kill();
    }

    public static class Folder extends AbstractFile {
        ArrayList<AbstractFile> mAbstractFiles = new ArrayList<>();

        @Override
        void add(AbstractFile message) {
            mAbstractFiles.add(message);
            System.out.println("添加文件");
        }

        @Override
        void remove(AbstractFile message) {
            mAbstractFiles.remove(message);
            System.out.println("删除文件");
        }

        @Override
        void kill() {
            for (AbstractFile file : mAbstractFiles) {
                file.kill();
            }
            System.out.println("删除病毒文件");
        }
    }

    public static class File extends AbstractFile {

        @Override
        void add(AbstractFile message) {
            System.out.println("不支持");
        }

        @Override
        void remove(AbstractFile message) {
            System.out.println("不支持");
        }

        @Override
        void kill() {
            System.out.println("已删除病毒文件");
        }
    }
}
