package io.linux.pojo;

public class RootDirectory {
	private static Directory rootDir; // Root directory
	public static final String ROOT = "/";

	private RootDirectory() {
	}

	public static Directory getRootDir() {
		if (rootDir == null) {
			rootDir = new Directory(ROOT, null);
		}
		return rootDir;
	}

	public static void clearRootDir() {
		rootDir = new Directory(ROOT, null);
	}
}
