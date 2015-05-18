package me.chris.MoneyManager.Commands;

import java.util.logging.Level;

import me.chris.MoneyManager.PayGroup;
import me.chris.MoneyManager.Vars;

import org.bukkit.entity.Player;

public class CommandPay
{
	public static void pay(Player p)
	{
		for (PayGroup g : Vars.payGroups)
		{
			double amount = g.getAmount();

			if (g.getType().equalsIgnoreCase("Flat_Rate") || g.getType().equalsIgnoreCase("$") )
			{
				for (String player : g.getMembers())
				{
					Vars.eco.depositPlayer(player, amount);
				}
			}
			else if (g.getType().equalsIgnoreCase("Percent") || g.getType().equalsIgnoreCase("%") )
			{
				for (String player : g.getMembers())
				{
					double playerAmount = Vars.eco.getBalance(player);
					double amountToGive = playerAmount * (amount / 100.0);
					Vars.eco.depositPlayer(player, amountToGive);
				}
			}
			else
			{
				Vars.log.log(Level.SEVERE, "[MoneyManager] One of your pay groups does not have a correct payment type.");
				Vars.log.log(Level.SEVERE, "[MoneyManager] Correct payment types are \"Flat_Rate\" and \"Percent\"");
				Vars.log.log(Level.SEVERE, "[MoneyManager] This plugin will shut itself off until problem has been fixed.");

				p.sendMessage("§a[MoneyManager] §4One or more of your payment groups does not have a correct payment type. " +
						"Correct payment types are §c\"Flat_Rate\" §4and §c\"Percent\" §4" +
						"This plugin will shut itself off until problem has been fixed.");

				Vars.plugin.getServer().getPluginManager().disablePlugin(Vars.plugin);
				break;
			}

		}

		Vars.broadcast("§a[MoneyManager] §5Attention Server, §cALL §5wages have just been paid.");
	}

	public static void pay(Player p, String group)
	{
		boolean contains = false;
		for (PayGroup g : Vars.payGroups)
		{
			if (g.getGroupName().equalsIgnoreCase(group))
			{
				contains = true;
				double amount = g.getAmount();

				if (g.getType().equalsIgnoreCase("Flat_Rate") || g.getType().equalsIgnoreCase("$") )
				{
					for (String player : g.getMembers())
					{
						Vars.eco.depositPlayer(player, amount);
					}
					Vars.broadcast("§a[MoneyManager] §5Attention Server, the §c" + g.getGroupName() + "§5 has just been paid their wages of §c$" + amount);
				}
				else if (g.getType().equalsIgnoreCase("Percent") || g.getType().equalsIgnoreCase("%") )
				{
					for (String player : g.getMembers())
					{
						double playerAmount = Vars.eco.getBalance(player);
						double amountToGive = playerAmount * (amount / 100.0);
						Vars.eco.depositPlayer(player, amountToGive);
					}
					Vars.broadcast("§a[MoneyManager] §5Attention Server, the §c" + g.getGroupName() + "§5 has just been paid their wages of §c" + amount + "%");

				}
				else
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] One of your payment groups does not have a correct payment type.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] Correct payment types are \"Flat_Rate\" and \"Percent\"");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This plugin will shut itself off until problem has been fixed.");

					p.sendMessage("§a[MoneyManager] §4One or more of your payment groups does not have a correct payment type. " +
							"Correct payment types are §c\"Flat_Rate\" §4and §c\"Percent\" §4" +
							"This plugin will shut itself off until problem has been fixed.");

					Vars.plugin.getServer().getPluginManager().disablePlugin(Vars.plugin);
				}

				break;
			}
		}

		if (contains == false)
		{
			p.sendMessage("§a[MoneyManager] §4Sorry, but §c" + group + "§4 was not found. ");
		}
	}
}
