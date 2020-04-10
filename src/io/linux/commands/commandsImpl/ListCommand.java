package io.linux.commands.commandsImpl;

import java.util.stream.Collectors;

import io.linux.commands.Command;
import io.linux.pojo.Directory;
import io.linux.pojo.PresentWorkingDirectory;

public class ListCommand implements Command {

	@Override
	public String execute(String[] commandParam) {
		Directory currDir = PresentWorkingDirectory.getPresentDirectory();
		String dirs = currDir.getAllDirectories().stream().collect(Collectors.joining(" "));
		return "DIRS: " + dirs; 
	}
}
