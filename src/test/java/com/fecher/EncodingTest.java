package com.fecher;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

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
	};

	private static class Stats
	{
		private long totalBytes = 0;
		private long totalEncodings = 0;
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
					'\n').append(
					"Total Encodings: ").append(
					totalEncodings).append(
					'\n').append(
					"Total Bytes: ").append(
					totalBytes).append(
					'\n').append(
					"Average Bytes: ").append(
					(double) totalBytes / (double) totalEncodings).append(
					'\n').append(
					"Successes: ").append(
					totalSuccesses).append(
					'\n').append(
					"Success Rate: ").append(
					(double) totalSuccesses / (double) totalEncodings).append(
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
		final Byte[] bytesArray = new Byte[((Byte.MAX_VALUE - Byte.MIN_VALUE) + 1)/8];
		int i = 0;
		for (int b = Byte.MIN_VALUE; b <= Byte.MAX_VALUE; b+=8) {
			bytesArray[i++] = (byte) b;
		}

		final ICombinatoricsVector<Byte> bytesVector = Factory.createVector(bytesArray);

		for (int k = 4; k <=4; k++) {
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
					stats.totalBytes += utf8Encoding.length;
					stats.totalEncodings++;
				}
			}
		}
		for (final Stats stats : TEST_ENCODING) {
			System.out.println(stats.toString());
		}
	}
}
