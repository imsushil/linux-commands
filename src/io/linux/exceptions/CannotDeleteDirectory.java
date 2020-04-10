package io.linux.exceptions;

public class CannotDeleteDirectory extends RuntimeException {
	private static final long serialVersionUID = -1451682697100866322L;

	public CannotDeleteDirectory(String msg) {
		super(msg);
	}
}