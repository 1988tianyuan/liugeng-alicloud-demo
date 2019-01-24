package com.liugeng.liugengaliclouddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class UnitTest {

	@Test
	public void test1() throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("thread: " + Thread.currentThread().getName() + " start");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread: " + Thread.currentThread().getName() + " stop");
			}
		};
		for (int i = 0; i < 5; i++) {
			executorService.submit(runnable);
		}
		executorService.shutdown();
		System.out.println("try to shutdown threadPool");
		while (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
			System.out.println("threadPool is not terminated");
		}
		System.out.println("threadPool is terminated");
	}
}
