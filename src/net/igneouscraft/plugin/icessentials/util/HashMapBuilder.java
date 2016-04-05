package net.igneouscraft.plugin.icessentials.util;

import java.util.HashMap;

/**
 * Utility to easily create and populate HashMaps
 * @author bl4ckscor3
 */
public class HashMapBuilder<K,V>
{
	private HashMap<K,V> map = new HashMap<K,V>();
	
	/**
	 * Adds a key and value to the HashMap
	 * @param k The key to add
	 * @param v The value to add
	 * @return The modified instance of this class to easily add more keys with values
	 */
	public HashMapBuilder<K,V> add(K k, V v)
	{
		map.put(k, v);
		return this;
	}
	
	/**
	 * @return The HashMap that got populated with the values beforehand
	 */
	public HashMap<K,V> build()
	{
		return map;
	}
}
