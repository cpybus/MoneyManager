package me.chris.MoneyManager.Commands;

import java.util.ArrayList;

import me.chris.MoneyManager.PayGroup;
import me.chris.MoneyManager.TaxGroup;
import me.chris.MoneyManager.Vars;

import org.bukkit.entity.Player;

public class CommandCreate
{
	public static void create(Player p, String groupName, String PayTax, String amount, String type, String players)
	{
		double doubleAmount;
		String[] playerList;
		ArrayList<String> names = new ArrayList<String>();
		
		boolean alreadyExists = false;
		
		for (PayGroup g : Vars.payGroups)
		{
			if (g.getGroupName().equalsIgnoreCase(groupName))
			{
				alreadyExists = true;
				break;
			}
		}
		for (TaxGroup g : Vars.taxGroups)
		{
			if (g.getGroupName().equalsIgnoreCase(groupName))
			{
				alreadyExists = true;
				break;
			}
		}
		
		if(alreadyExists == true)
		{
			p.sendMessage("§a[MoneyManager] §4Sorry, that group already exists. ");
			return;
		}

		if (!PayTax.equalsIgnoreCase("pay") && !PayTax.equalsIgnoreCase("tax"))
		{
			p.sendMessage("§a[MoneyManager] §4Sorry, that was not a valid command. ");
			p.sendMessage("§a[MoneyManager] §c" + PayTax + " §4 is not a valid argument. Please use either §cPay §4or §cTax");
			return;
		}

		try
		{
			doubleAmount = Double.parseDouble(amount);
		}
		catch (Throwable t)
		{
			p.sendMessage("§a[MoneyManager] §4Sorry, that was not a sub command. ");
			p.sendMessage("§a[MoneyManager] §c" + amount + " §4 is not a valid argument. Please use a valid number.");
			return;
		}

		if (!type.equalsIgnoreCase("Flat_Rate") && !type.equalsIgnoreCase("Percent") && !type.equalsIgnoreCase("%") && !type.equalsIgnoreCase("$") )
		{
			p.sendMessage("§a[MoneyManager] §4Sorry, that was not a sub command. ");
			p.sendMessage("§a[MoneyManager] §c" + type + " §4 is not a valid argument. §cFlat_Rate §4and §cPercent are the only valid types.");
			return;
		}

		playerList = players.split(",");
		for(String ugh : playerList)
		{
			names.add(ugh);
		}

		if (PayTax.equalsIgnoreCase("pay"))
		{
			PayGroup g = new PayGroup(groupName, doubleAmount, type, names);
			Vars.payGroups.add(g);
		}
		else if (PayTax.equalsIgnoreCase("tax"))
		{
			TaxGroup g = new TaxGroup(groupName, doubleAmount, type, names);
			Vars.taxGroups.add(g);
		}
		
		Vars.plugin.saveYamls();
		p.sendMessage("§a[MoneyManager] §2Group created successfully.");
		
	}
}
