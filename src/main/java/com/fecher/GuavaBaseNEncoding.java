package com.fecher;

import com.google.common.io.BaseEncoding;

public class GuavaBaseNEncoding implements
BinaryEncoding
{
	private BaseEncoding guavaEncoding;
	private final int n;

	public GuavaBaseNEncoding(
			final int n ) {
		switch (n) {
			case 16:
				guavaEncoding = BaseEncoding.base16();
				break;
			case 32:
				guavaEncoding = BaseEncoding.base32();
				break;
			case 64:
				guavaEncoding = BaseEncoding.base64();
				break;
		}
		this.n = n;
	}

	@Override
	public String encode(
			final byte[] binary ) {
		return guavaEncoding.encode(binary);
	}

	@Override
	public byte[] decode(
			final String str ) {
		return guavaEncoding.decode(str);
	}

	@Override
	public String getEncodingName() {
		return "Guava Base " + n;
	}

}
