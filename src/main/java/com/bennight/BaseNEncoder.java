package com.bennight;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import com.fecher.BinaryEncoding;

public class BaseNEncoder implements
		BinaryEncoding
{

	private final char[] _dictionary;
	private final Map<Character, Integer> _reverseDictionary;
	private final BigInteger _base;

	public BaseNEncoder(
			final char[] dictionary ) {
		_dictionary = dictionary;
		_base = BigInteger.valueOf(dictionary.length);
		_reverseDictionary = reverseDictionary(dictionary);
	}

	public BaseNEncoder(
			final int base ) {
		// if (base > 128) {
		// throw new Exception(
		// "Only handles mapping to ASCII char set, base must be <= 128");
		// }
		_dictionary = new char[base];
		for (int x = 0; x < base; x++) {
			_dictionary[x] = (char) x;
		}

		_base = BigInteger.valueOf(base);
		_reverseDictionary = reverseDictionary(_dictionary);
	}

	private static Map<Character, Integer> reverseDictionary(
			final char[] dictionary ) {
		final Map<Character, Integer> reverse = new HashMap<Character, Integer>();
		for (int i = 0; i < dictionary.length; i++) {
			reverse.put(
					dictionary[i],
					i);
		}
		return reverse;
	}

	public String encode(
			final BigInteger value ) {
		final StringBuilder s = new StringBuilder();
		BigInteger[] parts = {
			value,
			BigInteger.ZERO
		};
		while (parts[0].compareTo(_base) >= 0) {
			parts = parts[0].divideAndRemainder(_base);
			s.append(_dictionary[parts[1].intValue()]);
		}
		s.append(_dictionary[parts[0].intValue()]);
		return s.reverse().toString();
	}

	public BigInteger decodeInt(
			final String encoded ) {
		BigInteger result = BigInteger.ZERO;
		final int len = encoded.length();
		for (int i = 0; i < len; i++) {
			final BigInteger digit = BigInteger.valueOf(_reverseDictionary.get(encoded.charAt(i)));
			result = result.add(digit.multiply(_base.pow((len - i) - 1)));
		}
		return new BigInteger(
				result.toByteArray());
	}

	@Override
	public String encode(
			final byte[] binary ) {
		return encode(new BigInteger(
				ArrayUtils.addAll(
						new byte[] {
							1
						},
						binary)));
	}

	@Override
	public byte[] decode(
			final String str ) {
		final byte[] paddedArray = decodeInt(
				str).toByteArray();
		return ArrayUtils.subarray(
				paddedArray,
				1,
				paddedArray.length);
	}

	@Override
	public String getEncodingName() {
		return "Bennight Base " + _base;
	}
}
