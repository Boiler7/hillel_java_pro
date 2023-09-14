package HW17_Advanced_Multithreading;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<T>{

    private final List<T> list;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public ThreadSafeList(List<T> list) {
        this.list = list;
    }

    public void add(T value) {
        lock.writeLock().lock();
        try {
            list.add(value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T remove(int index) {
        lock.writeLock().lock();
        try{
            return list.remove(index);
        }finally {
            lock.writeLock().unlock();
        }
    }

    public T get(int index) {
        lock.writeLock().lock();
        try{
            return list.get(index);
        } finally {
          lock.writeLock().unlock();
        }
    }

    protected List<T> getList(){
        return this.list;
    }
    public int size(){
        return list.size();
    }
}
