package io.linux.pojo;

import static io.linux.pojo.Directory.PREVIOUS_DIR;

import java.util.Stack;

public class PresentWorkingDirectory {
	private static Stack<Directory> path;

	private PresentWorkingDirectory() {
	}

	public static Stack<Directory> getInstance() {
		if (path == null) {
			path = new Stack<>();
			path.add(RootDirectory.getRootDir());
		}
		return path;
	}

	public static Directory getPresentDirectory() {
		return path.peek();
	}

	public static Directory goToRootDir() {
		while (!path.peek().getName().equals("/")) {
			path.pop();
		}
		return path.peek();
	}

	public static void goToPreviousDir() {
		if (path.size() > 1) {
			path.pop();
		}
	}

	public static Directory goToDir(String dirName) {
		if (Directory.CURRENT_DIR.equals(dirName)) {
			return path.peek();
		}

		if (PREVIOUS_DIR.equals(dirName)) {
			if (path.size() > 1) {
				path.pop();
			}
			return path.peek();
		}

		Directory dir = getPresentDirectory().getDirectory(dirName);
		path.push(dir);
		return dir;
	}

	public static boolean contains(String dirName) {
		return path.stream().anyMatch((dir) -> dir.getName().equals(dirName));
	}

}