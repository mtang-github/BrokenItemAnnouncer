package us.danny.brokenitemannouncer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if(isEligible(event.getWhoClicked())) {
			ItemStack itemStack = event.getCurrentItem();
			if(itemStack.getType() == Material.GOLDEN_APPLE && itemStack.getDurability() == 1) {
				String name = event.getWhoClicked().getName();
				printAnnouncement(name, "GOD APPLE");
			}
			else if(itemStack.getType() == Material.POTION) {
				switch(itemStack.getDurability()) {
				case 8233:
				case 16425:
					String name = event.getWhoClicked().getName();
					printAnnouncement(name, "POTION OF STRENGTH II");
				}
			}
		}
	}
	
	private boolean isEligible(HumanEntity entity) {
		switch(entity.getGameMode()) {
		case ADVENTURE:
		case SURVIVAL:
			return true;
		default:
			return false;
		}
	}
	
	private void printAnnouncement(String name, String itemType) {
		for(int i = 0; i < 10; ++i) {
			Bukkit.broadcastMessage("§d§l§4" + name + " HAS ACQUIRED A " + itemType + "!");
		}
	}
}
