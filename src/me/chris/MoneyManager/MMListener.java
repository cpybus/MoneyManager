package me.chris.MoneyManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MMListener implements Listener
{
	@EventHandler(priority = EventPriority.HIGHEST)
	public void playerJoin(PlayerJoinEvent event)
	{
		Player p = event.getPlayer();

		if (p.isOp())
		{
			String lastestVersion = "";
			try
			{
				lastestVersion = HelperMethods.updateCheck();
			}
			catch (Throwable t)
			{
				return;
			}

			if (!lastestVersion.equalsIgnoreCase(Vars.version))
			{
				p.sendMessage("§5=====================================================");
				p.sendMessage("§4 Warning!§f This isnt the lastest version of MoneyManager!");
				p.sendMessage("§c " + lastestVersion + "§f Is out! (This is §c" + Vars.version + "§f)");
				p.sendMessage("§5=====================================================");
			}
		}
	}
}
