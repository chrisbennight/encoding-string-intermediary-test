package com.fecher;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.ICombinatoricsVector;

import com.bennight.BaseNEncoder;

public class EncodingTest
{
	private final static Charset UTF_8 = Charset.forName("UTF-8");

	private static Stats[] TEST_ENCODING = new Stats[] {
		new Stats(
				new BaseNEncoder(
						2)),
		new Stats(
				new BaseNEncoder(
						4)),
		new Stats(
				new BaseNEncoder(
						8)),
		new Stats(
				new BaseNEncoder(
						16)),
		new Stats(
				new BaseNEncoder(
						32)),
		new Stats(
				new BaseNEncoder(
						64)),
		new Stats(
				new BaseNEncoder(
						85)),
		new Stats(
				new BaseNEncoder(
						128)),
		new Stats(
				new GuavaBaseNEncoding(
						16)),
		new Stats(
				new GuavaBaseNEncoding(
						32)),
		new Stats(
				new GuavaBaseNEncoding(
						64)),
		new Stats(
				new HBase64Encoding()),
		new Stats(
				new Base91()),
		new Stats(
				new Base128Encoding()),
	};

	private static class Stats
	{
		private final Map<Integer, Long> totalBytes = new HashMap<Integer, Long>();
		// private long totalEncodings = 0;
		private final Map<Integer, Long> totalEncodings = new HashMap<Integer, Long>();
		private final BinaryEncoding encoding;
		private long totalSuccesses = 0;
		private final StopWatch encodeTimer = new StopWatch();
		private final StopWatch decodeTimer = new StopWatch();

		public Stats(
				final BinaryEncoding encoding ) {
			this.encoding = encoding;
			encodeTimer.start();
			encodeTimer.suspend();

			decodeTimer.start();
			decodeTimer.suspend();
		}

		@Override
		public String toString() {
			final StringBuilder str = new StringBuilder();
			str.append(
					"Encoding: ").append(
					encoding.getEncodingName()).append(
					'\n');
			long total = 0;
			for (final Entry<Integer, Long> e : totalEncodings.entrySet()) {
				str.append(
						// "Total Encodings (").append(
						// e.getKey()).append(
						// " original bytes): ").append(
						// e.getValue()).append(
						// '\n').append(
						// "Total Encoded Bytes (").append(
						// e.getKey()).append(
						// " original bytes): ").append(
						// totalBytes.get(e.getKey())).append(
						// '\n').append(
						"Average Encoded Bytes (").append(
						e.getKey()).append(
						" original bytes): ").append(
						(double) totalBytes.get(e.getKey()) / (double) e.getValue()).append(
						'\n');
				total += e.getValue();
			}
			str.append(
					"Total Successes: ").append(
					totalSuccesses).append(
					'\n').append(
					"Success Rate: ").append(
					(double) totalSuccesses / (double) total).append(
					'\n').append(
					"Time in encode: ").append(
					encodeTimer.toString()).append(
					'\n').append(
					"Time in decode: ").append(
					decodeTimer.toString()).append(
					'\n').append(
					"***************************\n\n");
			return str.toString();
		}
	}

	public static void main(
			final String[] args ) {
		new EncodingTest().test();
	}

	@Test
	public void test() {

		for (int k = 2; k <= 8; k++) {
			for (final Stats stats : TEST_ENCODING) {
				stats.totalBytes.put(
						k,
						0L);
				stats.totalEncodings.put(
						k,
						0L);
			}
			final int divisor = (int) Math.pow(
					2,
					k - 1);
			final Byte[] bytesArray = new Byte[((Byte.MAX_VALUE - Byte.MIN_VALUE) + 1) / divisor];
			int i = 0;
			for (int b = Byte.MIN_VALUE; b <= Byte.MAX_VALUE; b += divisor) {
				bytesArray[i++] = (byte) b;
			}

			final ICombinatoricsVector<Byte> bytesVector = Factory.createVector(bytesArray);
			final Iterator<ICombinatoricsVector<Byte>> it = Factory.createPermutationWithRepetitionGenerator(
					bytesVector,
					k).iterator();

			while (it.hasNext()) {
				final ICombinatoricsVector<Byte> bytes = it.next();
				final byte[] bytesPrimitive = ArrayUtils.toPrimitive(bytes.getVector().toArray(
						new Byte[] {}));
				for (final Stats stats : TEST_ENCODING) {
					stats.encodeTimer.resume();
					final String str = stats.encoding.encode(bytesPrimitive);
					stats.encodeTimer.suspend();
					final byte[] utf8Encoding = str.getBytes(UTF_8);
					final String utfChars = new String(
							utf8Encoding,
							Charset.forName("UTF-8"));

					stats.decodeTimer.resume();
					final byte[] original = stats.encoding.decode(utfChars);
					stats.decodeTimer.suspend();
					if (Arrays.equals(
							bytesPrimitive,
							original)) {
						stats.totalSuccesses++;
					}
					stats.totalBytes.put(
							k,
							stats.totalBytes.get(k) + utf8Encoding.length);
					stats.totalEncodings.put(
							k,
							stats.totalEncodings.get(k) + 1);
				}
			}
		}
		for (final Stats stats : TEST_ENCODING) {
			System.out.println(stats.toString());
		}
	}
}
