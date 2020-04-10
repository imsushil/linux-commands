package io.linux.main;

import static io.linux.constants.Constants.INVALID_COMMAND;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import io.linux.commands.Command;
import io.linux.commands.CommandsMap;
import io.linux.exceptions.CannotDeleteDirectory;
import io.linux.exceptions.DirectoryAlreadyExists;
import io.linux.exceptions.InvalidCommand;
import io.linux.exceptions.InvalidDirectory;
import io.linux.exceptions.InvalidPath;
import io.linux.exceptions.UnrecognizedInput;
import io.linux.pojo.PresentWorkingDirectory;

public class Application {

	/**
	 * Initializes the directory stack to root directory
	 */
	private static void init() {
		PresentWorkingDirectory.getInstance();
		CommandsMap.init();
	}

	/*
	 * Main method starts
	 */
	public static void main(String[] args) {
		init();
		String commandName, commandInput[];
		System.out.println("Starting application...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("$>");
			try {
				String input = br.readLine();
				commandInput = input.split(" ");
				commandName = commandInput[0];
				if (!CommandsMap.contains(commandName)) {
					throw new InvalidCommand(INVALID_COMMAND);
				}
				Command command = CommandsMap.get(commandName);
				String result = command.execute(commandInput);
				System.out.println(result);
			} catch (UnrecognizedInput ui) {
				System.out.println("ERR: " + ui.getMessage());
			} catch (InvalidPath ip) {
				System.out.println("ERR: " + ip.getMessage());
			} catch (DirectoryAlreadyExists dae) {
				System.out.println("ERR: " + dae.getMessage());
			} catch (InvalidCommand ic) {
				System.out.println("INFO: " + ic.getMessage());
			} catch (InvalidDirectory id) {
				System.out.println("ERR: " + id.getMessage());
			} catch (CannotDeleteDirectory cdf) {
				System.out.println("ERR: " + cdf.getMessage());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
