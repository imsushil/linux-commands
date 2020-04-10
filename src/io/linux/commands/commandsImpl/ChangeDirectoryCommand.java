package io.linux.commands.commandsImpl;

import io.linux.commands.Command;
import io.linux.exceptions.InvalidCommand;
import io.linux.exceptions.InvalidDirectory;
import io.linux.pojo.Directory;
import io.linux.pojo.PresentWorkingDirectory;

public class ChangeDirectoryCommand implements Command {
	private static final String DELIMITER = "/";

	@Override
	public String execute(String[] commandParam) {
		if (commandParam.length == 1) {
			throw new InvalidCommand("PROVIDE SOME PATH TO CHANGE DIRECTORY");
		}
		String pathToDir = commandParam[1];
		String dirs[] = pathToDir.split(DELIMITER);

		Directory currDir = PresentWorkingDirectory.getPresentDirectory();

		// If dirs.length is 0 or dirs[0] is empty, then it is an absolute path
		int start = 0;
		if (dirs.length == 0 || dirs[0].isEmpty()) {
			currDir = PresentWorkingDirectory.goToRootDir();
			start = 1;
		}

		for (int i = start; i < dirs.length; ++i) {
			if (!currDir.isDirectoryPresent(dirs[i])) {
				throw new InvalidDirectory("DIRECTORY: " + dirs[i] + " DOES NOT EXIST UNDER DIRECTORY: " + currDir.getName());
			}
			currDir = PresentWorkingDirectory.goToDir(dirs[i]);
		}
		return "SUCC: REACHED.";
	}

}
