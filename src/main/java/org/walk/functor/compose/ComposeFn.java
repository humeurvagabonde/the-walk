package org.walk.functor.compose;

import java.util.Optional;
import java.util.function.Function;

public class ComposeFn {

	// Presenter le Function.compose
	// puis presenter les Functor
	
	public static Function<Integer, Integer> auCarre = a -> a * a;  
	public static Function<Integer, Integer> plus4 = a -> a + 4;
	public static Function<Integer, Integer> plus5 = a -> a + 5;
	public static Function<Integer, Boolean> estPair = a -> a % 2 == 0;
	
	public static Function<Integer, Optional<Integer>> divisePar2 = a -> a % 2 == 0 ? Optional.of(a / 2) : Optional.empty();
	public static Function<Integer, Optional<Integer>> divisePar5 = a -> a % 5 == 0 ? Optional.of(a / 5) : Optional.empty();

}

