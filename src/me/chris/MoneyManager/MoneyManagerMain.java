package me.chris.MoneyManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import me.chris.MoneyManager.Commands.CommandHandler;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class MoneyManagerMain extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		new Vars(this);
		
		if (!setupPermissions())
		{
			Vars.log.log(Level.SEVERE, "[MoneyManager] No Permission found! Disabling plugin!");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		if (!setupEconomy())
		{
			Vars.log.log(Level.SEVERE, "[MoneyManager] No Economy found! Disabling plugin!");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		try
		{
			firstRun();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		loadYamls();
		
		getServer().getPluginManager().registerEvents(new MMListener(), this);
		
		CommandHandler commandHandler = new CommandHandler();
		getCommand("MoneyManager").setExecutor(commandHandler);
		getCommand("mm").setExecutor(commandHandler);
		
		Vars.log.log(Level.INFO, "[MoneyManager] Version 1.0");
		Vars.log.log(Level.INFO, "[MoneyManager] Started successfully.");
		
	}
	
	@Override
	public void onDisable()
	{
		Vars.log.log(Level.INFO, "[MoneyManager] Disabling plugin.");
		saveYamls();
	}

	private void firstRun() throws Exception
	{
		if (!Vars.configFile.exists())
		{
			Vars.configFile.getParentFile().mkdirs();
			copy(getResource("config.yml"), Vars.configFile);
		}

	}

	private void copy(InputStream in, File file)
	{
		try
		{
			OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0)
			{
				out.write(buf, 0, len);
			}
			out.close();
			in.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void loadYamls()
	{
		try
		{
			Vars.config.load(Vars.configFile);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		HelperMethods.ImportGroups();
	}

	public void saveYamls()
	{
		HelperMethods.ExportGroups();
		try
		{
			Vars.config.save(Vars.configFile);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private Boolean setupPermissions()
	{
		RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
		if (permissionProvider != null)
		{
			Vars.perms = permissionProvider.getProvider();
		}
		return (Vars.perms != null);
	}
	
	private boolean setupEconomy()
	{
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null)
		{
			Vars.eco = economyProvider.getProvider();
		}

		return (Vars.eco != null);
	}
}
