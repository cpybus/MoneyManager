package me.chris.MoneyManager.Commands;

import org.bukkit.entity.Player;

public class CommandHelp
{
	public static void help(Player p)
	{
		p.sendMessage("§5================§c [ Money Manager Help ] §5================");
		p.sendMessage("§c/mm §e- States the general info.");
		p.sendMessage("§c/mm help <command> §e- Brings up the help menu. ");
		p.sendMessage("§c/mm list §7<group> §e- Lists payments for a group or all. ");
		p.sendMessage("§c/mm reload §e- Reloads config files. ");
		p.sendMessage("§c/mm pay §7<group> §e- Pays wages. ");
		p.sendMessage("§c/mm tax §7<group> §e- Takes taxes. ");
		p.sendMessage("§c/mm set §7[group] a:[amount] §e- Sets the payment/tax for a specific group. ");
		p.sendMessage("§c/mm set §7[group] t:[type] §e- Sets the type of payment/tax (Flat_Rate Or Percent). ");
		p.sendMessage("§c/mm sync §7[PermsGroup] [MMGroup] §e- Syncs a permission group's members over to a MM group. ");
		p.sendMessage("§c/mm add §7[group] [player1,player2...] §e- Adds players to a group. ");
		p.sendMessage("§c/mm remove §7[group] [player1,player2...] §e- Removes players from group. ");
		p.sendMessage("§c/mm create §7[group] [pay/tax] [amount] [type] [player1,player2...] §e- Creates a new group. ");
		p.sendMessage("§c/mm delete §7[group] §e- Deletes a group and everything in it.  ");
		p.sendMessage("§cNotes:");
		p.sendMessage("§b§o  [] = Manditory Command. <> = Optional.");
		p.sendMessage("§b§o  Commands are explained in detail with §7/mm help <command>");
		p.sendMessage("§b§o  The SYNC command only works with PermissionsBukkit!");
		p.sendMessage("§5=====================================================");
	}

	public static void help(Player p, String command)
	{
		command = command.toLowerCase();
		if (command.equals("help"))
		{
			p.sendMessage("§5================§c [ Money Manager Help ] §5================");
			p.sendMessage("§eCommand: §c/mm help <command>");
			p.sendMessage("§eExample Usage:");
			p.sendMessage("  §2/mm help");
			p.sendMessage("  §2/mm help create");
			p.sendMessage("  §2/mm help set");
			p.sendMessage("§eExplanation:");
			p.sendMessage("§2  In the first example, the command will just list all the commands that the plugin has to offer. " + "However, on the second and third examples, the optional <command> argument is used. On these examples, the command " + "will return more detailed info on the create command and the set command.");
			p.sendMessage("§5=====================================================");
		}
		else if (command.equals("list"))
		{
			p.sendMessage("§5================§c [ Money Manager Help ] §5================");
			p.sendMessage("§eCommand: §c/mm list <group>");
			p.sendMessage("§eExample Usage:");
			p.sendMessage("  §2/mm list");
			p.sendMessage("  §2/mm list ExampleGroupName");
			p.sendMessage("  §2/mm list AnotherGroup");
			p.sendMessage("§eExplanation:");
			p.sendMessage("§2  The list command has two different ways you can use it. You can list all the groups by leaving the <group> argument " + "blank, and you can also name a group and get more detailed information on that specific group. In examples 2 and 3, the command " + "would return detaled information on the groups ExampleGroupName and AnotherGroup.");
			p.sendMessage("§5=====================================================");
		}
		else if (command.equals("reload"))
		{
			p.sendMessage("§5================§c [ Money Manager Help ] §5================");
			p.sendMessage("§eCommand: §c/mm reload");
			p.sendMessage("§eExample Usage:");
			p.sendMessage("  §2/mm reload");
			p.sendMessage("§eExplanation:");
			p.sendMessage("§2  Reload command is used when you make edits to the plugin\'s config.yml file. After you finish you edits, you can " + "use this command and the plugin will re-parse the config.yml file and intake all the changes you made.");
			p.sendMessage("§5=====================================================");
		}
		else if (command.equals("pay"))
		{
			p.sendMessage("§5================§c [ Money Manager Help ] §5================");
			p.sendMessage("§eCommand: §c/mm pay <group>");
			p.sendMessage("§eExample Usage:");
			p.sendMessage("  §2/mm pay");
			p.sendMessage("  §2/mm pay ExampleGroupName");
			p.sendMessage("  §2/mm pay AnotherGroup");
			p.sendMessage("§eExplanation:");
			p.sendMessage("§2  The pay command is one of the main commands of the plugin and the main purpose to the plugin: To pay players. " + "Using this command without a <group> argument will take all the players in all the groups in the PaymentGroups section " + "of the config.yml and pay them with their respective payment. Using the command with the <group> argument (as shown in " + "examples 2 and 3) will only pay the members of that group that is named.");
			p.sendMessage("§5=====================================================");
		}
		else if (command.equals("tax"))
		{
			p.sendMessage("§5================§c [ Money Manager Help ] §5================");
			p.sendMessage("§eCommand: §c/mm tax <group>");
			p.sendMessage("§eExample Usage:");
			p.sendMessage("  §2/mm tax");
			p.sendMessage("  §2/mm tax ExampleGroupName");
			p.sendMessage("  §2/mm tax AnotherGroup");
			p.sendMessage("§eExplanation:");
			p.sendMessage("§2  The tax command is one of the main commands of the plugin and also one of the main purposes of the plugin: To tax players. " + "Using this command without a <group> argument will take all the players in all the groups in the TaxGroups section " + "of the config.yml and tax them with their respective taxes.  Using the command with the <group> argument (as shown in " + "examples 2 and 3) will only tax the members of that group that is named");
			p.sendMessage("§5=====================================================");
		}
		else if (command.equals("set"))
		{
			p.sendMessage("§5================§c [ Money Manager Help ] §5================");
			p.sendMessage("§eCommand: §c/mm set [group] a:[amount]");
			p.sendMessage("§e         §c/mm set [group] t:[type]");
			p.sendMessage("§eExample Usage:");
			p.sendMessage("  §2/mm set ExampleGroupName a:100");
			p.sendMessage("  §2/mm set ExampleGroupName t:Flat_Rate");
			p.sendMessage("  §2/mm set AnotherGroup a:20");
			p.sendMessage("  §2/mm set AnotherGroup t:Percent");
			p.sendMessage("§eExplanation:");
			p.sendMessage("§2  This is one of the more complicated commands in the plugin. There are two basic variations of this: a and t. " + "a and t are for setting the amount and type variables (respectively) in the config.yml. You put in the Group you want to change " + "the amount or type value, and then you use either a: base or t: base. amount can be any number, but type has to be either " + "\"Flat_Rate\" or \"Percent\".");
			p.sendMessage("§5=====================================================");
		}
		else if (command.equals("sync"))
		{
			p.sendMessage("§5================§c [ Money Manager Help ] §5================");
			p.sendMessage("§eCommand: §c/mm sync [PermsGroup] [MMGroup]");
			p.sendMessage("§eExample Usage:");
			p.sendMessage("  §2/mm sync AdminPermsGroup AdminPayGroup");
			p.sendMessage("  §2/mm sync DonorGroup DonorPayGroup");
			p.sendMessage("  §2/mm sync Members MemberTaxGroup");
			p.sendMessage("§eExplanation:");
			p.sendMessage("§2  This command is designed to sync the members of a permission group with the members of a MoneyManager group... It actually overwrites any member in a MoneyManager group with those in the PermsGroup. This command only works with PermissionsBukkit, but support for other perms plugin is forthcoming. ");
			p.sendMessage("§5=====================================================");
		}
		else if (command.equals("add"))
		{
			p.sendMessage("§5================§c [ Money Manager Help ] §5================");
			p.sendMessage("§eCommand: §c/mm add [group] [player1,player2,player3,player4...]");
			p.sendMessage("§eExample Usage:");
			p.sendMessage("  §2/mm add ExampleGroupName Hotshot2162,Petmagnet13,Kayaloha");
			p.sendMessage("  §2/mm add ExampleGroupName Joecia82");
			p.sendMessage("  §2/mm add AnotherGroup JeremiahBye,MrsBye");
			p.sendMessage("§eExplanation:");
			p.sendMessage("§2  With this command, you can add players to a group. You need to make sure not to put any spaces in the names " + "or else the command will not go through. Seperate each name with a comma (,). There is not limit to the nunber of names " + "you can put. ");
			p.sendMessage("§5=====================================================");
		}
		else if (command.equals("remove"))
		{
			p.sendMessage("§5================§c [ Money Manager Help ] §5================");
			p.sendMessage("§eCommand: §c/mm remove [group] [player1,player2,player3,player4...]");
			p.sendMessage("§eExample Usage:");
			p.sendMessage("  §2/mm remove ExampleGroupName Hotshot2162,Petmagnet13,Kayaloha");
			p.sendMessage("  §2/mm remove ExampleGroupName Joecia82");
			p.sendMessage("  §2/mm remove AnotherGroup JeremiahBye,MrsBye");
			p.sendMessage("§eExplanation:");
			p.sendMessage("§2  This command is just like the add command, except it removes players from a group. Remember to not put any spaces " + "in or between the names, just use commas. Any name that isnt found will be returned and will display in chat that it couldnt be " + "removed because it wasnt found. ");
			p.sendMessage("§5=====================================================");
		}
		else if (command.equals("create"))
		{
			p.sendMessage("§5================§c [ Money Manager Help ] §5================");
			p.sendMessage("§eCommand: §c/mm create [group] [amount] [type] [player1,player2,player3...]");
			p.sendMessage("§eExample Usage:");
			p.sendMessage("  §2/mm create ExampleGroup tax 20 Percent Hotshot2162,Petmagnet13,Kayaloha");
			p.sendMessage("  §2/mm remove GroupName pay 200 Flat_Rate Joecia82,Jayty90yo");
			p.sendMessage("  §2/mm remove AnotherGroup tax 300 Flat_Rate JeremiahBye,MrsBye");
			p.sendMessage("§eExplanation:");
			p.sendMessage("§2  This command is used for creating new groups. The first argument is the group name. The second argument is [pay/tax] " + "which is asking for you to specify if the new gorup in question will be a PaymentGroup or TaxGroup. The third argument is " + "the amount. The fourth argument puts the third into more perspective... In example one, the tax would be 20 percent of what the " + "player has. In example two the payment would be 200. In the third example, the tax would be 300. the last argument is the players, " + "make sure when listing players do not put spaces and use commas to seperate the names.");
			p.sendMessage("§5=====================================================");
		}
		else if (command.equals("delete"))
		{
			p.sendMessage("§5================§c [ Money Manager Help ] §5================");
			p.sendMessage("§eCommand: §c/mm delete [group]");
			p.sendMessage("§eExample Usage:");
			p.sendMessage("  §2/mm delete ExampleGroup");
			p.sendMessage("  §2/mm delete AnotherGroup");
			p.sendMessage("§eExplanation:");
			p.sendMessage("§2  This command is used to delete a group from config.yml. Name the group and it will be deleted. ");
			p.sendMessage("§5=====================================================");
		}
		else
		{
			p.sendMessage("§a[MoneyManager] §4Invalid Command.");
		}
	}
}
