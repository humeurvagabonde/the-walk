package org.walk.functor.compose;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.walk.functor.compose.ComposeFn.auCarre;
import static org.walk.functor.compose.ComposeFn.divisePar2;
import static org.walk.functor.compose.ComposeFn.divisePar5;
import static org.walk.functor.compose.ComposeFn.estPair;
import static org.walk.functor.compose.ComposeFn.plus4;
import static org.walk.functor.compose.ComposeFn.plus5;

import java.util.Optional;
import java.util.function.Function;

import org.junit.Test;

public class ComposeFnTest {

    // P.E un exemple de lambada non pure : i.e accedant a une variable final externe au scope
    
	@Test
	public void testCompositionSimple() {
		Function<Integer, Integer> opeComplexe = auCarre.compose(plus4);
		assertEquals(Integer.valueOf(49), opeComplexe.apply(3));
	}

	@Test
	public void testCompositionAvecTypeDifferent() {
		Function<Integer, Boolean> nvlleFn = estPair.compose(plus5);
		assertTrue(nvlleFn.apply(1));
	}

	@Test
	public void testCompositionAvecOptionalImbrique() {
		Function<Integer, Optional<Integer>> nvlleFn = plus5.andThen(divisePar2);
		Optional<Optional<Integer>> result = nvlleFn.apply(3).map(divisePar2);
		assertEquals(Integer.valueOf(2), result.get().get());
		// --> difficile de composer plusieurs fonctions ayant pour signature a -> Optional<a> 
	}
	
	@Test
	public void testCompositionAvecOptionalPlat() {
		Function<Integer, Optional<Integer>> nvlleFn = plus5.andThen(divisePar2);
		Optional<Integer> result = nvlleFn.apply(3).flatMap(divisePar2);
		assertEquals(Integer.valueOf(2), result.get());
	}
	
	@Test
	public void testCompositionAvecOptionalPlatMultiple() {
		Function<Integer, Optional<Integer>> nvlleFn = plus5.andThen(divisePar2);
		Optional<Integer> result = nvlleFn.apply(3).flatMap(divisePar2).flatMap(divisePar5);
		assertFalse(result.isPresent());
	}

}
