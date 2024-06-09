package com.nt.runner;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-10)
public class BCommandLineTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("BCommandLineTestRunner.run()");
		System.out.println("Runner to Test" + Arrays.toString(args));
	}	
}
