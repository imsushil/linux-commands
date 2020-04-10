package io.linux.exceptions;

public class InvalidCommand extends RuntimeException {
	private static final long serialVersionUID = -2892605461099178633L;

	public InvalidCommand(String msg) {
		super(msg);
	}
}