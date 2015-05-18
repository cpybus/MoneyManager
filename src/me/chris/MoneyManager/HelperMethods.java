package me.chris.MoneyManager;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Chris
 * 
 */
public class HelperMethods
{
	public static void ImportGroups()
	{
		Vars.payGroups = new ArrayList<PayGroup>();
		Vars.taxGroups = new ArrayList<TaxGroup>();

		ArrayList<String> payGroups = convertToArrayList(Vars.config.getConfigurationSection("PayGroups.").getKeys(false));
		ArrayList<String> taxGroups = convertToArrayList(Vars.config.getConfigurationSection("TaxGroups.").getKeys(false));

		// PAY GROUPS
		if (payGroups != null)
		{
			for (String groupName : payGroups)
			{
				double amount = -1;
				String type;
				ArrayList<String> members = new ArrayList<String>();

				// GET THE VALUES
				try
				{
					amount = Vars.config.getDouble("PayGroups." + groupName + ".Amount");
				}
				catch (Throwable t)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Amount variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}

				try
				{
					type = Vars.config.getString("PayGroups." + groupName + ".Type");
				}
				catch (Throwable t)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Type variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}

				try
				{
					members = convertToArrayList(Vars.config.getStringList("PayGroups." + groupName + ".Members"));
				}
				catch (Throwable t)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Members variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}

				// IF VALUES DID NOT ASSIGN PROPERLY
				if (amount == -1)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Amount variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}
				if (type == null)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Type variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}
				if (members.isEmpty())
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Members variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}

				// CHECKS RESTRICTIONS ON VALUES
				if (amount < 0)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Amount variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] Cannot have negative payment amount");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}
				if ((type.equalsIgnoreCase("flat_rate") || type.equalsIgnoreCase("percent") || type.equalsIgnoreCase("$") || type.equalsIgnoreCase("%")) == false)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Type variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] Type values must be: flat, percent, $, %");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}

				Vars.payGroups.add(new PayGroup(groupName, amount, type, members));
			}
		}

		// TAX GROUPS
		if (taxGroups != null)
		{
			for (String groupName : taxGroups)
			{
				double amount = -1;
				String type;
				ArrayList<String> members = new ArrayList<String>();

				// GET THE VALUES
				try
				{
					amount = Vars.config.getDouble("TaxGroups." + groupName + ".Amount");
				}
				catch (Throwable t)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Amount variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}

				try
				{
					type = Vars.config.getString("TaxGroups." + groupName + ".Type");
				}
				catch (Throwable t)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Type variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}

				try
				{
					members = convertToArrayList(Vars.config.getStringList("TaxGroups." + groupName + ".Members"));
				}
				catch (Throwable t)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Members variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}

				// IF VALUES DID NOT ASSIGN PROPERLY
				if (amount == -1)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Amount variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}
				if (type == null)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Type variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}
				if (members.isEmpty())
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Members variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}

				// CHECKS RESTRICTIONS ON VALUES
				if (amount < 0)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Amount variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] Cannot have negative tax amount");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}
				if ((type.equalsIgnoreCase("flat_rate") || type.equalsIgnoreCase("percent") || type.equalsIgnoreCase("$") || type.equalsIgnoreCase("%")) == false)
				{
					Vars.log.log(Level.SEVERE, "[MoneyManager] Problem found with the Type variable in your " + groupName + " group.");
					Vars.log.log(Level.SEVERE, "[MoneyManager] Type values must be: flat, percent, $, %");
					Vars.log.log(Level.SEVERE, "[MoneyManager] This group will not be registered until said problem is fixed.");
					continue;
				}

				Vars.taxGroups.add(new TaxGroup(groupName, amount, type, members));
			}
		}
	}

	public static void ExportGroups()
	{
		Vars.config.set("PayGroups", "");
		Vars.config.set("TaxGroups", "");

		if (Vars.payGroups != null)
		{
			for (PayGroup group : Vars.payGroups)
			{
				String name = group.getGroupName();
				double amount = group.getAmount();
				String type = group.getType();
				ArrayList<String> members = group.getMembers();

				Vars.config.set("PayGroups." + name + ".Amount", amount);
				Vars.config.set("PayGroups." + name + ".Type", type);
				Vars.config.set("PayGroups." + name + ".Members", members);
			}
		}

		if (Vars.taxGroups != null)
		{
			for (TaxGroup group : Vars.taxGroups)
			{
				String name = group.getGroupName();
				double amount = group.getAmount();
				String type = group.getType();
				ArrayList<String> members = group.getMembers();

				Vars.config.set("TaxGroups." + name + ".Amount", amount);
				Vars.config.set("TaxGroups." + name + ".Type", type);
				Vars.config.set("TaxGroups." + name + ".Members", members);
			}
		}
	}

	private static ArrayList<String> convertToArrayList(Set<String> original)
	{
		ArrayList<String> newList = new ArrayList<String>();
		for (String str : original)
		{
			newList.add(str);
		}
		return newList;
	}

	private static ArrayList<String> convertToArrayList(List<String> original)
	{
		ArrayList<String> newList = new ArrayList<String>();
		for (String str : original)
		{
			newList.add(str);
		}
		return newList;
	}

	public static String updateCheck() throws Exception
	{
		String pluginUrlString = "http://dev.bukkit.org/server-mods/moneymanager/files.rss";
		String lastestVersion = "";
		try
		{
			URL url = new URL(pluginUrlString);
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url.openConnection().getInputStream());
			doc.getDocumentElement().normalize();
			NodeList nodes = doc.getElementsByTagName("item");
			Node firstNode = nodes.item(0);
			if (firstNode.getNodeType() == 1)
			{
				Element firstElement = (Element) firstNode;
				NodeList firstElementTagName = firstElement.getElementsByTagName("title");
				Element firstNameElement = (Element) firstElementTagName.item(0);
				NodeList firstNodes = firstNameElement.getChildNodes();
				lastestVersion = firstNodes.item(0).getNodeValue();
			}
		}
		catch (Exception localException)
		{
		}
		return lastestVersion;
	}
}
