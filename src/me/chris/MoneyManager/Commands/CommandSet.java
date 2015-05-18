package me.chris.MoneyManager.Commands;

import me.chris.MoneyManager.PayGroup;
import me.chris.MoneyManager.TaxGroup;
import me.chris.MoneyManager.Vars;

import org.bukkit.entity.Player;

public class CommandSet
{
	public static void set(Player p, String groupName, String variable)
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

		String variableType;
		if (variable.startsWith("a:"))
		{
			variableType = "Amount";
		}
		else if (variable.startsWith("t:"))
		{
			variableType = "Type";
		}
		else
		{
			p.sendMessage("§a[MoneyManager] §4Sorry, but §c" + variable + "§4 is not valid. ");
			p.sendMessage("§a[MoneyManager] §4Use §7/mm help set §4to find out how to properly use the set command.");
			return;
		}

		variable = variable.replace("a:", "");
		variable = variable.replace("t:", "");
		variable = variable.trim();

		if (has1 == true)
		{
			for (PayGroup g : Vars.payGroups)
			{
				if (g.getGroupName().equalsIgnoreCase(groupName))
				{
					if (variableType.equalsIgnoreCase("Amount"))
					{
						double doubleAmount = 0;
						try
						{
							doubleAmount = Double.parseDouble(variable);
						}
						catch (Throwable t)
						{
							p.sendMessage("§a[MoneyManager] §4The amount must be an integer or a double.");
							return;
						}

						g.setAmount(doubleAmount);
					}
					else if (variableType.equalsIgnoreCase("Type"))
					{
						if (variable.equalsIgnoreCase("Flat_Rate") || variable.equalsIgnoreCase("$"))
						{
							g.setType("Flat_Rate");
						}
						else if (variable.equalsIgnoreCase("Percent") || variable.equalsIgnoreCase("%"))
						{
							g.setType("Percent");
						}
						else
						{
							p.sendMessage("§a[MoneyManager] §4That wasnt a valid type.");
							p.sendMessage("§a[MoneyManager] §4The only valid types are §cFlat_Rate §4and §cPercent");
							return;
						}
					}

					p.sendMessage("§a[MoneyManager] §4Sucessfully set the " + variableType.toLowerCase() + " in the " + groupName + " group to " + variable);
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
					if (variableType.equalsIgnoreCase("Amount"))
					{
						double doubleAmount = 0;
						try
						{
							doubleAmount = Double.parseDouble(variable);
						}
						catch (Throwable t)
						{
							p.sendMessage("§a[MoneyManager] §4The amount must be an integer or a double.");
							return;
						}

						g.setAmount(doubleAmount);
					}
					else if (variableType.equalsIgnoreCase("Type"))
					{
						if (variable.equalsIgnoreCase("Flat_Rate") || variable.equalsIgnoreCase("$"))
						{
							g.setType("Flat_Rate");
						}
						else if (variable.equalsIgnoreCase("Percent") || variable.equalsIgnoreCase("%"))
						{
							g.setType("Percent");
						}
						else
						{
							p.sendMessage("§a[MoneyManager] §4That wasnt a valid type.");
							p.sendMessage("§a[MoneyManager] §4The only valid types are §cFlat_Rate §4and §cPercent");
							return;
						}
					}

					p.sendMessage("§a[MoneyManager] §4Sucessfully set the " + variableType.toLowerCase() + " in the " + groupName + " group to " + variable);
					break;

				}
			}
		}
		Vars.plugin.saveYamls();
	}
}
