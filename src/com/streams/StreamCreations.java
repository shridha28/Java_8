package com.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import com.beans.Patient;

public class StreamCreations {

	public static void main (String args[]) throws IOException {
		
		//Different ways to create streams
		//1) For Collections
	 
		List<String> strs = new ArrayList();
		strs.add("Shridha");
		strs.add("Neeraja");
		strs.add("Priyanka");
		
		strs = strs.stream().map((s)->s.toUpperCase()).collect(Collectors.toList());
		
		strs.forEach(System.out::println);
		
		//2) For arrays
		Integer [] arr = new Integer[] {2,4,5,7,8};
		Stream<Integer> streamIn = Arrays.stream(arr);
		
		streamIn.filter((var)->(var>3)).forEach(System.out::println);
		
		//3) Using Stream.of
		Stream<String> streams = Stream.of("Suraj","Shridha","Shreya");
		System.out.println(streams.findFirst().toString().toUpperCase());
		
		//4) Stream for map -
		//For this you need to first get the entry set and then go for any further operations:
		Map<String,Integer> studMap = new HashMap<>();
		studMap.put("Dora", 78);
		studMap.put("Shri", 8);
		studMap.put("Shrai", 7);
		studMap.put("Nadeem", 99);
		
		System.out.println(studMap.entrySet().stream().filter(es->es.getValue()<98).count());
		
		//5) Reading from a file and printing it. Using stream for reading the file.
		Stream<String> str = Files.lines(Paths.get("./resources/sample.txt"));
		str.forEach(System.out::println);
		
		// 6) Streams for Primitive values
		DoubleStream streamDouble = DoubleStream.of(4.9,45.9,990.90);
		streamDouble.forEach(System.out::println);
		
		
		
		//Using map-filter-reduce
		
		System.out.println("****************************************************");
		List<Patient> list = new ArrayList<Patient>();
		list.add(new Patient("Nagesh",38.6f));
		list.add(new Patient("Naresh",36.6f));
		list.add(new Patient("Nishant",39.6f));
		
		OptionalDouble average = list.stream()
				.mapToDouble(patient->patient.getTemperature())
				.filter(v->v>37)
				.average();
		
		ArrayList<Patient> listOfPatients = (ArrayList<Patient>) list
				.stream()
				.map((patient)->
				{patient.setTemperature(0.0f);
				               return patient;})
				.collect(Collectors.toList());
		
		if(average.isPresent())
		  System.out.println(average.getAsDouble());
		System.out.println(listOfPatients);
		
		System.out.println("****************************************************");
		//Creating your own reduce method
		
		Stream<Double> reduceExample = Stream.of(1.6,677.8,89.90,78.9);
		
		Optional<Double> opt = reduceExample.reduce((v,v2)->v+v2);
		
		opt.ifPresent(System.out::println);
		
		System.out.println("**********empty Optional example*******");
		//empty Optional example
		
		OptionalDouble optD = OptionalDouble.empty();
		streamDouble = DoubleStream.of(4.9,45.9,990.90);
		optD = streamDouble.findAny();
		
		optD.ifPresent(System.out::println);
	 
		Optional<Patient> patient = Optional.empty();
		
		patient = listOfPatients.stream().findFirst();
		
		patient.ifPresent(System.out::println);
		
		System.out.println("**********orElse Optional example*******");
		
		Optional<Patient> emptyPatient = Optional.empty();
		Patient elseP = emptyPatient.orElse(new Patient("gaurav",67.8f));
		System.out.println(elseP);
	}
	
}
