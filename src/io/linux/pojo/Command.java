package io.linux.pojo;

import java.util.HashMap;
import java.util.Map;

public class Command {
	Map<String, Boolean> commands;
	public Command(){
		commands = new HashMap<>();
	}
	
	public Map<String, Boolean> getCommands() {
		return commands;
	}

	public void setCommands(Map<String, Boolean> commands) {
		this.commands = commands;
	}

	public void add(String cmd) {
		commands.put(cmd, true);
	}
	
	public boolean contains(String cmd){
		if(this.commands.containsKey(cmd)){
			return true;
		}
		return false;
	}
}