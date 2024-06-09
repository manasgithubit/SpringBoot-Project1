package com.nt.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-20)
public class ApplicationBTest1Runner implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ApplicationBTest1Runner.run()");
		System.out.println("Non-Option args name::" + args.getNonOptionArgs());
		
		for(String name:args.getOptionNames())
		{
			System.out.println(name + "->"+args.getOptionValues(name));
		}
	}
}
