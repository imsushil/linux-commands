package io.linux.exceptions;

public class UnrecognizedInput extends RuntimeException {
	private static final long serialVersionUID = 2893716810437074475L;

	public UnrecognizedInput(String msg){
		super(msg);
	}
}
