package ss.week5;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
	/**
	 * @ensures \result == (\forAll K x,y; map.containsKey(x) &&
	 *          map.containsKey(y) && x != y; map.get(x) != map.get(y));
	 * @pure
	 */

	/**
	 * Check if the map is injective For that we get both values and keys. Then
	 * we compare them if they´re equal In case a value has two keys, we return
	 * false
	 * 
	 */
	public static <K, V> boolean isOneOnOne(Map<K, V> map) {
		int count = 0;
		Set<K> set = map.keySet();
		Collection<V> setv = map.values();
		for (K set2 : set) {
			for (V v2 : setv) {
				if (v2 == map.get(set2)) {
					count++;
				}
				if (count > 1) {
					return false;
				}
			}
			count = 0;
		}

		return true;
	}

	/**
	 * @ensures \result == (\forAll V y; map.containsValue(y);
	 *          range.containsValue(y); (\exists K x; map.containsKey(x);
	 *          map.get(x) == y));
	 */
	/** @pure */
	public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
		for (V range2 : range) {
			if (!map.containsValue(range2)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @ensures \result == (\forAll K x; inverse(map) == x);
	 */
	/*
	 * 5.3 Result type has to be Map<V>, Set<K>> because keys are unique, there
	 * cannot be duplicates
	 */
	/*
	 * First we create a output map. Then we the get the keys and values from
	 * map. Then we treat the values from map as keys for output. If output
	 * contains the new key we get the value and add it to output (Keys are
	 * unique). else we add the values as keys and the old keysSet we use as
	 * values
	 * 
	 */
	public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
		Map<V, Set<K>> output = new HashMap<V, Set<K>>();
		Set<K> set = map.keySet();
		for (K set2 : set) {
			V val = map.get(set2);
			if (output.containsKey(val)) {
				Set<K> val2 = output.get(val);
				val2.add(set2);
				output.put(val, val2);
			} else {
				output.put(val, new HashSet<K>(Arrays.asList(set2)));

			}
		}
		return output;
	}

	/**
	 * @ensures \result == (\forAll K x; map.inverseBijection(map) == x);
	 */
	/*
	 * Basically the same as the inverse method except, we check if the map is
	 * injective and surjective on a certain range first. if both conditions are
	 * met , we apply the method.
	 * 
	 */
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Map<V, K> output = new HashMap<V, K>();
		Set<K> set = map.keySet();
		Collection<V> setValues = map.values();
		if (!(isOneOnOne(map) && isSurjectiveOnRange(map, new HashSet<V>(setValues)))) {
			return null;
		}
		for (K set2 : set) {
			V val = map.get(set2);
			output.put(val, set2);
		}
		return output;
	}

	/**
	 * @ensures \result == (\forAll K x; (\exists V y; f.get(x) == y &&
	 *          g.values().contains(y)));
	 */
	/** @pure */
	/*
	 * Checks if all values of f are in the keySet of g
	 */
	public static <K, W, V> boolean compatible(Map<K, V> f, Map<V, W> g) {
		Collection<V> values = f.values();
		for (V valuesF : values) {
			if (!g.containsKey(valuesF)) {
				return false;

			}
		}
		return true;
	}

	/**
	 * @ensures \result == (\forAll K x; (\forAll V y; f.get(x) == y;
	 * 
	 */
	/**
	 * If both maps are compatible we compose them We get both map´s setkeys.
	 * Map f we use as keys and g keys`as values for output If both sets are
	 * equal, we assign them to output
	 * 
	 */
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		if (!compatible(f, g)) {
			return null;
		}
		Map<K, W> output = new HashMap<K, W>();
		Set<K> set = f.keySet();
		Set<V> setValues = g.keySet();
		for (K set2 : set) {
			for (V setValues2 : setValues) {
				if (setValues2 == f.get(set2)) {
					output.put(set2, g.get(setValues2));

				}
			}
		}
		return output;
	}
}