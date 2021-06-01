package me.tear.villager;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new VillagerEntity(), this);
	}
	
	@Override
	public void onDisable() {
		
	}

}
