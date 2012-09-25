package org.hanford.minecraft;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.Bukkit;

public class SignLogger extends JavaPlugin implements Listener
{
	static final String VERSION = "1.0.0";

	Logger log = Logger.getLogger("Minecraft");
 
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		log.info("[SignLogger] Enabled");
	}
 
	@EventHandler
	public void onSignChange (SignChangeEvent event)
	{
		Block block = event.getBlock();
		Player player = event.getPlayer();
		String[] lines = event.getLines();
		String buf = "";

		for (int i = 0; i < lines.length; i++)
		{
			if (i != lines.length)
			{
				buf += " ";
			}
			buf += lines[i];
		}

		log.info ("[SignLogger] <" + player.getName() + "> " + block.getX() + "," + block.getY() + "," + block.getZ() + buf);
	}
}
