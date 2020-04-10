package io.linux.exceptions;

public class InvalidDirectory extends RuntimeException {
	private static final long serialVersionUID = 9214245633172202500L;

	public InvalidDirectory(String msg){
		super(msg);
	}
}