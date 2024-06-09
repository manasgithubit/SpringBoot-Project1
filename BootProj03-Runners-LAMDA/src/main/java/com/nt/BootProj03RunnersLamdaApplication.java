package com.nt;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class BootProj03RunnersLamdaApplication {

	@Bean
	@Order(1)
	public CommandLineRunner createCLRunner()
	{
		//LAMDA Impl for functional Interface
//		CommandLineRunner clr = (String...args)->
//		{
//			System.out.println("From CommandLineRunner:"+Arrays.toString(args));
//		};
//		return clr;
		
		//LAMDA Impl for functional Interface(improvision)
//		CommandLineRunner clr1 = (args)->System.out.println("From CommandLineRunner:"+Arrays.toString(args));
//	    return clr1;
		
		//LAMDA Impl of functional Interface(improvision)
//		CommandLineRunner clr2=args->System.out.println("From CommandLineRunner:"+Arrays.toString(args));
//		return clr2;
		
		//LAMDA Impl of functional Interface with for each/enhance for loop 
//		CommandLineRunner clr3=args->
//		{
//			System.out.println("CommandLineRunner");
//			for(String arg:args)
//			{
//				System.out.println(arg);
//			}	
//		};
//		return clr3;
		
		//LAMDA Impl of functional Interface + Stream API + static method reference
		CommandLineRunner clr4=args->
		{
			System.out.println("CommandLineRunner");
			Stream.of(args).forEach(System.out::println);
		};
		return clr4;
		
		//LAMDA Impl of functional Interface + Stream API + static method reference(improvisation)
//		CommandLineRunner clr5 = args->Stream.of(args).forEach(System.out::println);
//		return clr5;
		
		//LAMDA Impl of functional Interface + Stream API + static method reference(improvision)
		//return args->Stream.of(args).forEach(System.out::println);
	}
	
	@Bean
	@Order(10)
	public ApplicationRunner createAppRunner()
	{
		return aargs->
		{
			System.out.println("application runner");
			System.out.println("non option arg value:" + aargs.getNonOptionArgs());
			System.out.println("option arg name values");
			Set<String> optionArgs = aargs.getOptionNames();
			optionArgs.forEach(name->{System.out.println(name);
			System.out.println(aargs.getOptionValues(name));
			});
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootProj03RunnersLamdaApplication.class, args);
	}

}
