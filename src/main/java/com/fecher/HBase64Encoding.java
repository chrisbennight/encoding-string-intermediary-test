package com.fecher;

import org.apache.hadoop.hbase.util.Base64;

public class HBase64Encoding implements
BinaryEncoding
{

	public HBase64Encoding() {}

	@Override
	public String encode(
			final byte[] binary ) {
		return Base64.encodeBytes(
				binary,
				Base64.ORDERED);
	}

	@Override
	public byte[] decode(
			final String str ) {
		return Base64.decode(
				str,
				Base64.ORDERED);
	}

	@Override
	public String getEncodingName() {
		return "HBase Base 64";
	}

}
