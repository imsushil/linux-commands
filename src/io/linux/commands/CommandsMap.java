package io.linux.commands;

import java.util.HashMap;

import io.linux.commands.commandsImpl.ChangeDirectoryCommand;
import io.linux.commands.commandsImpl.ListCommand;
import io.linux.commands.commandsImpl.MakeDirectoryCommand;
import io.linux.commands.commandsImpl.PresentDirectoryCommand;
import io.linux.commands.commandsImpl.RemoveCommand;

public class CommandsMap {
	private static HashMap<String, Command> commandsMap = new HashMap<>();

	public static void init() {
		if (!commandsMap.isEmpty())
			return;

		commandsMap.put("ls", new ListCommand());
		commandsMap.put("mkdir", new MakeDirectoryCommand());
		commandsMap.put("pwd", new PresentDirectoryCommand());
		commandsMap.put("cd", new ChangeDirectoryCommand());
		commandsMap.put("rm", new RemoveCommand());
	}

	public static Command get(String commandName) {
		return commandsMap.get(commandName);
	}

	public static boolean contains(String commandName) {
		return commandsMap.containsKey(commandName);
	}
}
