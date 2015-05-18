package me.chris.MoneyManager.Commands;

import me.chris.MoneyManager.PayGroup;
import me.chris.MoneyManager.TaxGroup;
import me.chris.MoneyManager.Vars;

import org.bukkit.entity.Player;

public class CommandRemove
{
	public static void remove(Player p, String groupName, String players)
	{
		String notInList = "§7";
		
		boolean has1 = false;
		boolean has2 = false;
		
		for (PayGroup g : Vars.payGroups)
		{
			if(g.getGroupName().equalsIgnoreCase(groupName))
			{
				has1 = true;
				break;
			}
		}
		for (TaxGroup g : Vars.taxGroups)
		{
			if(g.getGroupName().equalsIgnoreCase(groupName))
			{
				has2 = true;
				break;
			}
		}
		
		if(has1 == true && has2 == true)
		{
			p.sendMessage("§a[MoneyManager] §cMultiple groups with that name found, please rename groups accordingly.");
			return;
		}
		
		if(has1 == false && has2 == false)
		{
			p.sendMessage("§a[MoneyManager] §4Sorry, but §c" + groupName + "§4 was not found. ");
			return;
		}

		if(has1 == true)
		{
			for (PayGroup g : Vars.payGroups)
			{
				if (g.getGroupName().equalsIgnoreCase(groupName))
				{
					String[] names = players.split(",");
					for (String name : names)
					{
						boolean contains2 = false;
						for (String member : g.getMembers())
						{
							if (name.equalsIgnoreCase(member))
							{
								contains2 = true;
								g.getMembers().remove(member);
								break;
							}
						}

						if (contains2 == false)
						{
							notInList = notInList + name + "§4; §7";
						}
					}
				}
			}
		}
		else
		{
			for (TaxGroup g : Vars.taxGroups)
			{
				if (g.getGroupName().equalsIgnoreCase(groupName))
				{
					String[] names = players.split(",");
					for (String name : names)
					{
						boolean contains2 = false;
						for (String member : g.getMembers())
						{
							if (name.equalsIgnoreCase(member))
							{
								contains2 = true;
								g.getMembers().remove(member);
								break;
							}
						}

						if (contains2 == false)
						{
							notInList = notInList + name + "§4; §7";
						}
					}
				}
			}
		}
		

		if (notInList.length() > 2)
		{
			p.sendMessage("§a[MoneyManager] §4The following players were not found in the group: ");
			p.sendMessage("§a[MoneyManager] " + notInList);
			p.sendMessage("§a[MoneyManager] §2However, the rest of the players were removed.");
		}
		else
		{
			p.sendMessage("§a[MoneyManager] §2Successfully removed players.");
		}
		
		Vars.plugin.saveYamls();
	}
}
