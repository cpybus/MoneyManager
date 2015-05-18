package me.chris.MoneyManager.Commands;

import me.chris.MoneyManager.PayGroup;
import me.chris.MoneyManager.TaxGroup;
import me.chris.MoneyManager.Vars;

import org.bukkit.entity.Player;

public class CommandList
{
	public static void list(Player p)
	{
		p.sendMessage("§5==================§c [ Money Manager ] §5==================");
		p.sendMessage("§ePayGroups:");
		for (PayGroup g : Vars.payGroups)
		{
			p.sendMessage(" " + g.getInfo());
		}
		p.sendMessage("§eTaxGroups:");
		for (TaxGroup g : Vars.taxGroups)
		{
			p.sendMessage(" " + g.getInfo());
		}
		p.sendMessage("§5=====================================================");
	}

	public static void list(Player p, String group)
	{
		boolean contains = false;
		for (PayGroup g : Vars.payGroups)
		{
			if (g.getGroupName().equalsIgnoreCase(group))
			{
				contains = true;
				p.sendMessage("§5==================§c [ Money Manager ] §5==================");
				g.getSpecificInfo(p);
				p.sendMessage("§5=====================================================");
				break;
			}
		}
		
		for (TaxGroup g : Vars.taxGroups)
		{
			if (g.getGroupName().equalsIgnoreCase(group))
			{
				contains = true;
				p.sendMessage("§5==================§c [ Money Manager ] §5==================");
				g.getSpecificInfo(p);
				p.sendMessage("§5=====================================================");
				break;
			}
		}

		if (contains == false)
		{
			p.sendMessage("§a[MoneyManager] §4Sorry, but §c" + group + "§4 was not found. ");
		}
	}
}
