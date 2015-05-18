package me.chris.MoneyManager.Commands;

import me.chris.MoneyManager.PayGroup;
import me.chris.MoneyManager.TaxGroup;
import me.chris.MoneyManager.Vars;

import org.bukkit.entity.Player;

public class CommandDelete
{
	public static void delete(Player p, String groupName)
	{
		boolean has1 = false;
		boolean has2 = false;

		for (PayGroup g : Vars.payGroups)
		{
			if (g.getGroupName().equalsIgnoreCase(groupName))
			{
				has1 = true;
				break;
			}
		}
		for (TaxGroup g : Vars.taxGroups)
		{
			if (g.getGroupName().equalsIgnoreCase(groupName))
			{
				has2 = true;
				break;
			}
		}

		if (has1 == true && has2 == true)
		{
			p.sendMessage("§a[MoneyManager] §cMultiple groups with that group name found, please rename groups accordingly.");
			return;
		}

		if (has1 == false && has2 == false)
		{
			p.sendMessage("§a[MoneyManager] §4Sorry, but §c" + groupName + "§4 was not found. ");
			return;
		}

		if (has1 == true)
		{
			for (PayGroup g : Vars.payGroups)
			{
				if (g.getGroupName().equalsIgnoreCase(groupName))
				{
					Vars.payGroups.remove(g);
					break;
				}
			}
		}
		else if (has2 == true)
		{
			for (TaxGroup g : Vars.taxGroups)
			{
				if (g.getGroupName().equalsIgnoreCase(groupName))
				{
					Vars.taxGroups.remove(g);
					break;
				}
			}
		}
		
		Vars.plugin.saveYamls();
		p.sendMessage("§a[MoneyManager] §2Successfully deleted group.");

	}
}
