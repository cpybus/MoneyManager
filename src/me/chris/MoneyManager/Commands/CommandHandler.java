package me.chris.MoneyManager.Commands;

import me.chris.MoneyManager.Vars;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Chris
 * 
 */
public class CommandHandler implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String idk, String[] args)
	{
		if (!(sender instanceof Player))
		{
			/*
			CommandSender p = sender;
			if (args.length == 0)
				ConsoleCommandMethods.welcome(p);
			else if (args.length == 1)
			{
				String arg1 = args[0].toLowerCase();

				if (arg1.equals("help"))
					ConsoleCommandMethods.help(p);
				else if (arg1.equals("reload"))
					ConsoleCommandMethods.reload(p);
				else if (arg1.equals("list"))
					ConsoleCommandMethods.list(p);
				else if (arg1.equals("pay"))
					ConsoleCommandMethods.pay(p);
				else if (arg1.equals("tax"))
					ConsoleCommandMethods.tax(p);
				else
					p.sendMessage("[MoneyManager] Invalid command.");
			}
			else if (args.length == 2)
			{
				String arg1 = args[0].toLowerCase();
				String arg2 = args[1];

				if (arg1.equals("list"))
					ConsoleCommandMethods.list(p, arg2);
				else if (arg1.equals("pay"))
					ConsoleCommandMethods.pay(p, arg2);
				else if (arg1.equals("tax"))
					ConsoleCommandMethods.tax(p, arg2);
				else if (arg1.equals("help"))
					ConsoleCommandMethods.help(p, arg2);
				else if (arg1.equals("delete"))
					ConsoleCommandMethods.delete(p, arg2);
				else
					p.sendMessage("[MoneyManager] Invalid command.");
			}
			else if (args.length == 3)
			{
				String arg1 = args[0].toLowerCase();
				String arg2 = args[1];
				String arg3 = args[2];

				if (arg1.equals("set"))
					ConsoleCommandMethods.set(p, arg2, arg3);
				else if (arg1.equals("add"))
					ConsoleCommandMethods.add(p, arg2, arg3);
				else if (arg1.equals("remove"))
					ConsoleCommandMethods.remove(p, arg2, arg3);
				else
					p.sendMessage("[MoneyManager] Invalid command.");
			}
			else if (args.length == 6)
			{
				String arg1 = args[0].toLowerCase();
				String arg2 = args[1];
				String arg3 = args[2];
				String arg4 = args[3];
				String arg5 = args[4];
				String arg6 = args[5];

				if (arg1.equals("create"))
					ConsoleCommandMethods.create(p, arg2, arg3, arg4, arg5,arg6);
				else
					p.sendMessage("[MoneyManager] Invalid command.");

			}
			else
				p.sendMessage("[MoneyManager] Invalid command.");
			*/
			sender.sendMessage("[MoneyManager] Current does not support console commands.");
		}
		else
		{
			Player p = (Player) sender;
			if (args.length == 0)
			{
				if (Vars.perms.has(p, "MoneyManager.welcome") || Vars.perms.has(p, "MoneyManager.*"))
					CommandWelcome.welcome(p);
				else
					p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
			}
			else if (args.length == 1)
			{
				String arg1 = args[0].toLowerCase();
				if (arg1.equals("help"))
				{
					if (Vars.perms.has(p, "MoneyManager.help") || Vars.perms.has(p, "MoneyManager.*"))
						CommandHelp.help(p);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else if (arg1.equals("reload"))
				{
					if (Vars.perms.has(p, "MoneyManager.reload") || Vars.perms.has(p, "MoneyManager.*"))
						CommandReload.reload(p);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else if (arg1.equals("list"))
				{
					if (Vars.perms.has(p, "MoneyManager.list") || Vars.perms.has(p, "MoneyManager.*"))
						CommandList.list(p);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else if (arg1.equals("pay"))
				{
					if (Vars.perms.has(p, "MoneyManager.pay") || Vars.perms.has(p, "MoneyManager.*"))
						CommandPay.pay(p);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else if (arg1.equals("tax"))
				{
					if (Vars.perms.has(p, "MoneyManager.tax") || Vars.perms.has(p, "MoneyManager.*"))
						CommandTax.tax(p);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else
					p.sendMessage("§a[MoneyManager] §4Invalid command.");
			}
			else if (args.length == 2)
			{
				String arg1 = args[0].toLowerCase();
				String arg2 = args[1];
				if (arg1.equals("list"))
				{
					if (Vars.perms.has(p, "MoneyManager.list") || Vars.perms.has(p, "MoneyManager.*"))
						CommandList.list(p, arg2);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else if (arg1.equals("pay"))
				{
					if (Vars.perms.has(p, "MoneyManager.pay") || Vars.perms.has(p, "MoneyManager.*"))
						CommandPay.pay(p, arg2);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else if (arg1.equals("tax"))
				{
					if (Vars.perms.has(p, "MoneyManager.tax") || Vars.perms.has(p, "MoneyManager.*"))
						CommandTax.tax(p, arg2);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else if (arg1.equals("help"))
				{
					if (Vars.perms.has(p, "MoneyManager.help") || Vars.perms.has(p, "MoneyManager.*"))
						CommandHelp.help(p, arg2);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else if (arg1.equals("delete"))
				{
					if (Vars.perms.has(p, "MoneyManager.delete") || Vars.perms.has(p, "MoneyManager.*"))
						CommandDelete.delete(p, arg2);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else
					p.sendMessage("§a[MoneyManager] §4Invalid command.");
			}
			else if (args.length == 3)
			{
				String arg1 = args[0].toLowerCase();
				String arg2 = args[1];
				String arg3 = args[2];
				if (arg1.equals("set"))
				{
					if (Vars.perms.has(p, "MoneyManager.set") || Vars.perms.has(p, "MoneyManager.*"))
						CommandSet.set(p, arg2, arg3);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else if (arg1.equals("sync"))
				{
					if (Vars.perms.has(p, "MoneyManager.sync") || Vars.perms.has(p, "MoneyManager.*"))
						CommandSync.sync(p, arg2, arg3);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else if (arg1.equals("add"))
				{
					if (Vars.perms.has(p, "MoneyManager.add") || Vars.perms.has(p, "MoneyManager.*"))
						CommandAdd.add(p, arg2, arg3);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");

				}
				else if (arg1.equals("remove"))
				{
					if (Vars.perms.has(p, "MoneyManager.remove") || Vars.perms.has(p, "MoneyManager.*"))
						CommandRemove.remove(p, arg2, arg3);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");

				}
				else
					p.sendMessage("§a[MoneyManager] §4Invalid command.");
			}
			else if (args.length == 6)
			{
				String arg1 = args[0].toLowerCase();
				String arg2 = args[1];
				String arg3 = args[2];
				String arg4 = args[3];
				String arg5 = args[4];
				String arg6 = args[5];
				if (arg1.equals("create"))
				{
					if (Vars.perms.has(p, "MoneyManager.create") || Vars.perms.has(p, "MoneyManager.*"))
						CommandCreate.create(p, arg2, arg3, arg4, arg5, arg6);
					else
						p.sendMessage("§a[MoneyManager] §4You don't have permission for that command.");
				}
				else
					p.sendMessage("§a[MoneyManager] §4Invalid command.");
			}
			else
				p.sendMessage("§a[MoneyManager] §4Invalid command.");
		}
		return true;
	}
}
