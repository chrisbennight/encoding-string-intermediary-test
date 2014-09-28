package com.bennight;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.primitives.Longs;

public class sertest {

	public static void main(String[] args) throws Exception {
		
		
		int numVals = 100;
		
		
		sertest s = new sertest();
		
		List<byte[]> vals = s.createValues(numVals);
		System.out.println("long direct:                " + s.sizeOfBytes(vals));
		
		vals = s.createValuesWithString(numVals);
		System.out.println("UTF-8 bytes of .toString(): " + s.sizeOfBytes(vals));
		
		for (int x = 16; x <= 128; x++){
			vals = s.createValuesN(numVals, x);
			System.out.println("UTF-8 bytes of Base:" + x  +":     " + s.sizeOfBytes(vals));
		}
		
	}
	
	private List<byte[]> createValues(int numValues){
		List<byte[]> bytes  = new ArrayList<byte[]>(numValues);
		for (long i = 0; i < numValues; i++){
			bytes.add(Longs.toByteArray(Long.MAX_VALUE -i));
		}
		return bytes;
	}
	
	private List<byte[]> createValuesWithString(int numValues){
		List<byte[]> bytes  = new ArrayList<byte[]>(numValues);
		for (long i = 0; i < numValues; i++){
			bytes.add(String.valueOf(Long.MAX_VALUE - i).getBytes());
		}
		return bytes;
	}
	
	private List<byte[]> createValuesN(int numValues, int base) throws Exception{
		List<byte[]> bytes  = new ArrayList<byte[]>(numValues);
		BaseNEncoder nenc = new BaseNEncoder(base);
		
		for (long i = 0; i < numValues; i++){
			bytes.add(nenc.encode(BigInteger.valueOf(Long.MAX_VALUE - i)).getBytes());
		}
		return bytes;
	}
	
		
	private long sizeOfBytes(Collection<byte[]> bytes){
		long size = 0;
		
		for (byte[] b : bytes){
			size += b.length;
		}
		
		return size;
	}
	
	
	

}
