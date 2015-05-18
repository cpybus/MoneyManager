package me.chris.MoneyManager;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * @author Chris
 * 
 */
public class Vars
{
	public static File configFile;
	
	public static MoneyManagerMain plugin;
	public static Logger log = Logger.getLogger("Minecraft");
	public static FileConfiguration config;
	public static Permission perms;
	public static Economy eco;
	
	public static String version = "MoneyManager 2.1";
	
	public static ArrayList<PayGroup> payGroups = new ArrayList<PayGroup>();
	public static ArrayList<TaxGroup> taxGroups = new ArrayList<TaxGroup>();

	public Vars(MoneyManagerMain plugin)
	{
		Vars.plugin = plugin;
		Vars.configFile = new File(plugin.getDataFolder(), "config.yml");
		Vars.config = new YamlConfiguration();
		
		
	}
	
	public static void broadcast(String string)
	{
		Vars.plugin.getServer().broadcastMessage(string);
	}

}
