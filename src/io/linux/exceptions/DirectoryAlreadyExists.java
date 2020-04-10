package io.linux.exceptions;

public class DirectoryAlreadyExists extends RuntimeException {
	private static final long serialVersionUID = -2965462065638729402L;

	public DirectoryAlreadyExists(String msg){
		super(msg);
	}
}