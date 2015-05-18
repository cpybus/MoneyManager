package me.chris.MoneyManager.Commands;

import java.util.logging.Level;

import me.chris.MoneyManager.TaxGroup;
import me.chris.MoneyManager.Vars;

import org.bukkit.entity.Player;

public class CommandTax
{
	public static void tax(Player p)
	{
		String unableToPay = "§7";

		for (TaxGroup g : Vars.taxGroups)
		{
			double amount = g.getAmount();

			if (g.getType().equalsIgnoreCase("Flat_Rate") || g.getType().equalsIgnoreCase("$") )
			{
				for (String player : g.getMembers())
				{
					double playerAmount = Vars.eco.getBalance(player);
					if (playerAmount - amount < 0)
					{
						unableToPay = unableToPay + player + "(" + amount + ") §4; §7";
					}
					else
					{
						Vars.eco.withdrawPlayer(player, amount);
					}
				}
			}
			else if (g.getType().equalsIgnoreCase("Percent") || g.getType().equalsIgnoreCase("%") )
			{
				for (String player : g.getMembers())
				{
					double playerAmount = Vars.eco.getBalance(player);
					double amountToTake = playerAmount * (amount / 100.0);
					if (playerAmount - amountToTake < 0)
					{
						unableToPay = unableToPay + player + "(" + amountToTake + ") §4; §7";
					}
					else
					{
						Vars.eco.withdrawPlayer(player, amount);
					}
				}
			}
			else
			{
				Vars.log.log(Level.SEVERE, "[MoneyManager] One of your tax groups does not have a correct tax type.");
				Vars.log.log(Level.SEVERE, "[MoneyManager] Correct tax types are \"Flat_Rate\" and \"Percent\"");
				Vars.log.log(Level.SEVERE, "[MoneyManager] This plugin will shut itself off until problem has been fixed.");

				p.sendMessage("§a[MoneyManager] §4One or more of your tax groups does not have a correct tax type. " +
						"Correct tax types are §c\"Flat_Rate\" §4and §c\"Percent\" §4" +
						"This plugin will shut itself off until problem has been fixed.");

				Vars.plugin.getServer().getPluginManager().disablePlugin(Vars.plugin);
				return;
			}

		}

		Vars.broadcast("§a[MoneyManager] §5Attention Server, §cALL §5taxes have just been paid.");

		if (unableToPay.length() > 2)
		{
			p.sendMessage("§a[MoneyManager] §4The following players were not able to pay their taxes:");
			p.sendMessage(unableToPay);
		}
	}

	public static void tax(Player p, String group)
	{
		boolean contains = false;

		String unableToPay = "§7";

		for (TaxGroup g : Vars.taxGroups)
		{
			if (g.getGroupName().equalsIgnoreCase(group))
			{
				contains = true;
				double amount = g.getAmount();

				if (g.getType().equalsIgnoreCase("Flat_Rate") || g.getType().equalsIgnoreCase("$") )
				{
					for (String player : g.getMembers())
					{
						double playerAmount = Vars.eco.getBalance(player);
						if (playerAmount - amount < 0)
						{
							unableToPay = unableToPay + player + "(" + amount + ") §4; §7";
						}
						else
						{
							Vars.eco.withdrawPlayer(player, amount);
						}
					}
					Vars.broadcast("§a[MoneyManager] §5Attention Server, the §c" + g.getGroupName() + "§5 has just paid their taxes of §c$" + amount);

				}
				else if (g.getType().equalsIgnoreCase("Percent") || g.getType().equalsIgnoreCase("%") )
				{
					for (String player : g.getMembers())
					{
						double playerAmount = Vars.eco.getBalance(player);
						double amountToTake = playerAmount * (amount / 100.0);
						if (playerAmount - amountToTake < 0)
						{
							unableToPay = unableToPay + player + "(" + amountToTake + ") §4; §7";
						}
						else
						{
							Vars.eco.withdrawPlayer(player, amount);
						}
					}
					Vars.broadcast("§a[MoneyManager] §5Attention Server, the §c" + g.getGroupName() + "§5 has just paid their taxes of §c" + amount + "%");
				}
				else
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] One of your tax groups does not have a correct tax type.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] Correct tax types are \"Flat_Rate\" and \"Percent\"");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This plugin will shut itself off until problem has been fixed.");

					p.sendMessage("§a[MoneyManager] §4One or more of your tax groups does not have a correct tax type. " +
							"Correct tax types are §c\"Flat_Rate\" §4and §c\"Percent\" §4" +
							"This plugin will shut itself off until problem has been fixed.");

					Vars.plugin.getServer().getPluginManager().disablePlugin(Vars.plugin);
					return;
				}

				break;
			}
		}

		if (contains == false)
		{
			p.sendMessage("§a[MoneyManager] §4Sorry, but §c" + group + "§4 was not found. ");
			return;
		}

		if (unableToPay.length() > 2)
		{
			p.sendMessage("§a[MoneyManager] §4The following players were not able to pay their taxes:");
			p.sendMessage(unableToPay);
			return;
		}
	}
}
