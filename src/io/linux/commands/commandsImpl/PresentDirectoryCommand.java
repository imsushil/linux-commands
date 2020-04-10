package io.linux.commands.commandsImpl;

import static io.linux.pojo.RootDirectory.ROOT;

import java.util.stream.Collectors;

import io.linux.commands.Command;
import io.linux.pojo.PresentWorkingDirectory;

public class PresentDirectoryCommand implements Command {
	
	private static final String DELIMITER = "/";
	
	@Override
	public String execute(String[] commandParam) {
		String path = PresentWorkingDirectory.getInstance()
									  .stream()
									  .filter(dir -> !ROOT.equals(dir.getName()))
									  .map(dir -> dir.getName())
									  .collect(Collectors.joining(DELIMITER));
		return "PATH: " + ROOT + path;
	}
}
