package io.linux.pojo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import io.linux.exceptions.InvalidDirectory;

public class Directory {
	private String name;
	private Map<String, Directory> directories;
	private Directory parentDir;
	public static final String PREVIOUS_DIR = "..";
	public static final String CURRENT_DIR = ".";

	public Directory() {
	}

	public Directory(String path, Directory parent) {
		this.name = path;
		this.directories = new HashMap<>();
		init(parent);
	}

	private void init(Directory parent) {
		// if parent is null, directory will point to itself(For ROOT dir)
		if (parent == null) {
			this.parentDir = this;
		} else {
			this.parentDir = parent;
		}
	}

	public String getName() {
		return name;
	}

	/**
	 * Adds new directory
	 * 
	 * @param dirName
	 */
	public void addDirectory(String dirName) {
		Directory newDir = new Directory(dirName, this);
		this.directories.put(dirName, newDir);
	}

	/**
	 * Remove the specified directory
	 * 
	 * @param dirName
	 */
	public void removeDirectory(String dirName) {
		this.directories.remove(dirName);
	}

	/**
	 * @param dirName
	 * @return the corresponding directory if present, otherwise null
	 */
	public Directory getDirectory(String dirName) {
		if (dirName == null) {
			throw new IllegalArgumentException("dirName is null.");
		}

		if (CURRENT_DIR.equals(dirName)) {
			return this;
		} else if (PREVIOUS_DIR.equals(dirName)) {
			return this.parentDir;
		}

		return this.directories.get(dirName);
	}

	/**
	 * 
	 * @return
	 */
	public Collection<String> getAllDirectories() {
		return Collections.unmodifiableCollection(this.directories.keySet());
	}

	public boolean isDirectoryPresent(String dirName) {
		if (dirName == null) {
			throw new InvalidDirectory("DIRECTORY NAME IS NULL");
		}
		return this.directories.containsKey(dirName) || PREVIOUS_DIR.equals(dirName) || CURRENT_DIR.equals(dirName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((directories == null) ? 0 : directories.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Directory other = (Directory) obj;
		if (directories == null) {
			if (other.directories != null)
				return false;
		} else if (!directories.equals(other.directories))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}