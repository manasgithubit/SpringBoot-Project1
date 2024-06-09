package com.nt.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(20)
public class _ApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args)throws Exception {
		System.out.println("_ApplicationRunner.run()");
	}
}
