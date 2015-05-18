package me.chris.MoneyManager.Commands;

import me.chris.MoneyManager.HelperMethods;
import me.chris.MoneyManager.Vars;

import org.bukkit.entity.Player;

public class CommandWelcome
{
	public static void welcome(Player p)
	{
		
		
		p.sendMessage("§5=====================================================");
		p.sendMessage("§a Welcome to MoneyManager Plugin §9("+Vars.version+")");
		p.sendMessage("§a Designed and Programmed by §9Hotshot2162");
		p.sendMessage("§a type §c/MoneyManager help§a for commands");
		p.sendMessage("§5=====================================================");
		
		if (p.isOp())
		{
			String lastestVersion = "";
			try
			{
				lastestVersion = HelperMethods.updateCheck();
			}
			catch (Throwable t)
			{
				return;
			}

			if (!lastestVersion.equalsIgnoreCase(Vars.version))
			{
				p.sendMessage("§4 Warning!§f This isnt the lastest version of MoneyManager!");
				p.sendMessage("§c " + lastestVersion + "§f Is out! (This is §c" + Vars.version + "§f)");
				p.sendMessage("§5=====================================================");
			}
		}
		
		
	}
}
