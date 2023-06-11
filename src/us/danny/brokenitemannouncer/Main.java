package us.danny.brokenitemannouncer;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private static final String NAME = "[Broken Item Announcer]";
	
	//ctor
	public Main() {
		//do nothing
	}
	
	@Override
	public void onEnable() {
		PluginManager pluginManager = getServer().getPluginManager();
		InventoryClickListener listener = new InventoryClickListener();
		pluginManager.registerEvents(listener, this);
		System.out.println(NAME + " enabled");
	}
	
	@Override
	public void onDisable() {
		System.out.println(NAME + " disabled");
	}
}
