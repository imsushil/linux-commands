package io.linux.exceptions;

public class InvalidPath extends RuntimeException {
	private static final long serialVersionUID = 1511268317422319301L;

	public InvalidPath(String msg){
		super(msg);
	}
}
