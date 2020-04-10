package io.linux.commands.commandsImpl;

import io.linux.commands.Command;
import io.linux.exceptions.CannotDeleteDirectory;
import io.linux.exceptions.InvalidCommand;
import io.linux.exceptions.InvalidDirectory;
import io.linux.pojo.Directory;
import io.linux.pojo.PresentWorkingDirectory;
import io.linux.pojo.RootDirectory;

public class RemoveCommand implements Command {

	private static final String DELIMITER = "/";

	private void validateDirectory(Directory currDir, String dirName) {
		if (!currDir.isDirectoryPresent(dirName)) {
			throw new InvalidDirectory("DIRECTORY: " + dirName + " DOES NOT EXIST.");
		}
		if (PresentWorkingDirectory.contains(dirName)) {
			throw new CannotDeleteDirectory("CANNOT DELETE DIR. EITHER IT IS THE PRESENT WORKING DIRECTORY OR PARENT OF THE PRESENT WORKING DIRECTORY");
		}
	}

	@Override
	public String execute(String[] commandParam) {
		if (commandParam.length != 2) {
			throw new InvalidCommand("COMMAND IS NOT VALID.");
		}

		String pathToDir = commandParam[1];
		String dirs[] = pathToDir.split(DELIMITER);

		if (dirs.length == 0) {
			throw new CannotDeleteDirectory("CANNOT DELETE ROOT DIRECTORY.");
		}

		Directory currDir = PresentWorkingDirectory.getPresentDirectory();

		// If dirs.length is 0 or dirs[0] is empty, then it is an absolute path
		int start = 0;
		if (dirs[0].isEmpty()) {
			currDir = RootDirectory.getRootDir();
			start = 1;
		}

		for (int j = start; j < dirs.length - 1; ++j) {
			if (!currDir.isDirectoryPresent(dirs[j])) {
				throw new InvalidDirectory("DIRECTORY: " + dirs[j] + " DOES NOT EXIST");
			}
			currDir = currDir.getDirectory(dirs[j]);
		}

		String dirToBeDeleted = dirs[dirs.length - 1];
		validateDirectory(currDir, dirToBeDeleted);
		currDir.removeDirectory(dirToBeDeleted);

		return "SUCC: " + dirToBeDeleted + " DELETED";
	}

}
