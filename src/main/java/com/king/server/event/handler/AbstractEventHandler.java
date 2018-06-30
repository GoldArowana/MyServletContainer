package com.king.server.event.handler;

public abstract class AbstractEventHandler<T> implements EventHandler<T> {
    @Override
    public void handle(T obj) throws HandlerException {
        beforeHandle(obj);
        doHandle(obj);
        afterHandle(obj);
    }

    /**
     * 事件处理前置处理方法
     */
    protected void beforeHandle(T obj) {
    }

    /**
     * 事件处理方法
     */
    protected abstract void doHandle(T obj);

    /**
     * 事件处理后置处理方法
     */
    protected void afterHandle(T obj) {
    }
}
