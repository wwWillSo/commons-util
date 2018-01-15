package com.szw.util;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Component;


@Component
public class OrderNoGenerator {

	private Lock lock = new ReentrantLock();

	public String getOrderNo(String prefix, String suffix) {
		lock.lock();
		try {
			return prefix + System.currentTimeMillis() + new Random().nextInt(10) + suffix.substring(suffix.length() - 4);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return null;
	}

	public static void main(String args[]) {

		for (int i = 0; i < 100; i++) {
			String str = "ST" + System.currentTimeMillis() + new Random().nextInt(10) + "13531897648".substring("13531897648".length() - 4);

			System.out.println(str);
		}
	}
}
