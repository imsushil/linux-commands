package io.linux.commands.commandsImpl;

import io.linux.commands.Command;
import io.linux.exceptions.DirectoryAlreadyExists;
import io.linux.exceptions.InvalidCommand;
import io.linux.exceptions.InvalidDirectory;
import io.linux.pojo.Directory;
import io.linux.pojo.PresentWorkingDirectory;
import io.linux.pojo.RootDirectory;

public class MakeDirectoryCommand implements Command {
	private static final String SPLIT_BY = "/";

	private void validateCommand(String[] commandParam) {
		if (commandParam.length == 1) {
			throw new InvalidCommand("PROVIDE SOME PATH.");
		}
	}

	private void validateDirectory(Directory currDir, String dirName) {
		if (!currDir.isDirectoryPresent(dirName)) {
			throw new InvalidDirectory("DIRECTORY " + dirName + " DOES NOT EXIST.");
		}
	}

	@Override
	public String execute(String[] commandParam) {
		validateCommand(commandParam);

		String pathToDir = commandParam[1];
		String dirs[] = pathToDir.split(SPLIT_BY);

		if (dirs.length == 0 || pathToDir.charAt(pathToDir.length() - 1) == '/') {
			throw new InvalidDirectory("DIRECTORY NAME CAN'T BE BLANK");
		}

		Directory currDir = PresentWorkingDirectory.getPresentDirectory();

		// If dirs[0] is empty, then it is an absolute path
		int start = 0;
		if (dirs[0].isEmpty()) {
			currDir = RootDirectory.getRootDir();
			start = 1;
		}

		for (int j = start; j < dirs.length - 1; ++j) {
			validateDirectory(currDir, dirs[j]);
			currDir = currDir.getDirectory(dirs[j]);
		}

		String newDirName = dirs[dirs.length - 1];
		if (currDir.isDirectoryPresent(newDirName)) {
			throw new DirectoryAlreadyExists("CANNOT CREATE DIRECTORY: " + newDirName + " AS IT ALREADY EXISTS.");
		}
		currDir.addDirectory(newDirName);

		return "SUCC: " + newDirName + " CREATED.";
	}
}
