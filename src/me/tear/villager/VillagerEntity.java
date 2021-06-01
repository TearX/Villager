package me.tear.villager;

import org.bukkit.craftbukkit.v1_16_R2.entity.CraftVillager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent;

public class VillagerEntity implements Listener {
	
	@EventHandler
	public void onFlee(EntityTargetEvent e) {
		
		Entity entity = e.getTarget();
		
		if (entity.getType() == EntityType.VILLAGER) {
			
			CraftVillager v = (CraftVillager) entity;
			
				if (v.isAware()) {
					
					v.setAware(false);
					e.setCancelled(true);
					return;
					
			}
				e.setCancelled(true);
				return;
		}	
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		
		Entity entity = e.getEntity();
		
		if (entity.getType() == EntityType.VILLAGER) {
			
			CraftVillager v = (CraftVillager) entity;
			
			if (v.isAware()) {
				return;
			}
			
			v.setAware(true);
			e.setCancelled(true);
			return;
		}
	}
}
