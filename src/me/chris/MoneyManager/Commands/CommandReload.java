package me.chris.MoneyManager.Commands;

import me.chris.MoneyManager.Vars;

import org.bukkit.entity.Player;

public class CommandReload
{
	public static void reload(Player p)
	{
		Vars.plugin.loadYamls();
		p.sendMessage("§a[MoneyManager] §2Reloaded config file.");
	}
}
