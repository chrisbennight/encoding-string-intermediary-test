package com.fecher;

public interface BinaryEncoding
{
	public String encode(
			byte[] binary );

	public byte[] decode(
			String str );

	public String getEncodingName();
}
