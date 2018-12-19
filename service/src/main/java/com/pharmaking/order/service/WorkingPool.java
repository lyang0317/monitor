package com.pharmaking.order.service;

import java.util.concurrent.LinkedBlockingDeque;

public class WorkingPool {

    private static LinkedBlockingDeque workingQueue = new LinkedBlockingDeque();

    public static LinkedBlockingDeque getWorkingQueue() {
        return workingQueue;
    }

}
