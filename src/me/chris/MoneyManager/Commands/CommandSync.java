package me.chris.MoneyManager.Commands;


import java.util.ArrayList;
import java.util.List;

import me.chris.MoneyManager.PayGroup;
import me.chris.MoneyManager.TaxGroup;
import me.chris.MoneyManager.Vars;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.platymuus.bukkit.permissions.Group;
import com.platymuus.bukkit.permissions.PermissionsPlugin;

public class CommandSync
{
	public static void sync(Player p, String permsGroupName, String mmGroup)
	{
		
		
		Plugin permsPlugin = Vars.plugin.getServer().getPluginManager().getPlugin("PermissionsBukkit");
		PermissionsPlugin permsClass = null;
        if (permsPlugin != null) 
        {
        	permsClass = (PermissionsPlugin) permsPlugin;
        }
        else
        {
        	p.sendMessage("§a[MoneyManager] §4This command only works with PermissionsBukkit.");
        }
		
		
		Group permsGroup = null;
		permsGroup = permsClass.getGroup(permsGroupName);
		
		if(permsGroup == null)
		{
			p.sendMessage("§a[MoneyManager] §4Sorry, but §c" + permsGroupName + "§4 was not found. ");
			return;
		}
		
		
		boolean has1 = false;
		boolean has2 = false;
		
		for (PayGroup g : Vars.payGroups)
		{
			if(g.getGroupName().equalsIgnoreCase(mmGroup))
			{
				has1 = true;
				break;
			}
		}
		for (TaxGroup g : Vars.taxGroups)
		{
			if(g.getGroupName().equalsIgnoreCase(mmGroup))
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
			p.sendMessage("§a[MoneyManager] §4Sorry, but §c" + mmGroup + "§4 was not found. ");
			return;
		}

		if(has1 == true)
		{
			for (PayGroup g : Vars.payGroups)
			{
				if (g.getGroupName().equalsIgnoreCase(mmGroup))
				{
					List<String> permsGroupMembers = permsGroup.getPlayers();
					g.members = new ArrayList<String>();
					for(String groupMember : permsGroupMembers)
					{
						g.addMember(groupMember);
					}
					p.sendMessage("§a[MoneyManager] §2Synced the members of the §c" + permsGroup.getName() + "§2 permissions group to the §c" + mmGroup + "§2 moneymanager group");
				}
			}
		}
		else
		{
			for (TaxGroup g : Vars.taxGroups)
			{
				if (g.getGroupName().equalsIgnoreCase(mmGroup))
				{
					List<String> permsGroupMembers = permsGroup.getPlayers();
					g.members = new ArrayList<String>();
					for(String groupMember : permsGroupMembers)
					{
						g.addMember(groupMember);
					}
					p.sendMessage("§a[MoneyManager] §2Synced the members of §c" + permsGroup.getName() + "§2 to the §c" + mmGroup + "§2 group");
				}
			}
		}
		
		Vars.plugin.saveYamls();
	
	}
}
