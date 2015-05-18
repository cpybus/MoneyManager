/**
 * 
 */
package me.chris.MoneyManager;

import java.util.ArrayList;

import org.bukkit.entity.Player;


/**
 * @author Chris
 *
 */
public class TaxGroup
{
	private String groupName;
	private double amount;
	private String type;
	public ArrayList<String> members;

	public TaxGroup(String groupName, double amount, String type, ArrayList<String> members)
	{
		this.groupName = groupName;
		this.amount = amount;
		this.type = type;
		this.members = members;
	}

	public String getTaxType()
	{
		return type;
	}
	
	public String getGroupName()
	{
		return groupName;
	}

	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public ArrayList<String> getMembers()
	{
		return members;
	}
	
	
	public String getInfo()
	{
		if(type.equalsIgnoreCase("Flat_Rate"))
			return "§c" + groupName + "§a taxes are currently set to §c$" + amount;
		else if(type.equalsIgnoreCase("Percent"))
			return "§c" + groupName + "§a taxes are currently set to §c" + amount + "%";
		else
			return "§4Error #1";
	}
	
	public void getSpecificInfo(Player p)
	{
		if(getType().equalsIgnoreCase("Flat_Rate"))
		{
			p.sendMessage("§c" + groupName + "§a taxes are currently set to §c$" + amount);
			p.sendMessage("§aThis group is in the §ePayGroups§a list.");
			p.sendMessage("§aPlayers in this group are: ");
			
			String allMembers = "§7";
			for (String member : getMembers())
			{
				allMembers = allMembers + member + "§4; §7";
			}
			
			p.sendMessage(allMembers);
		}
		else if(getType().equalsIgnoreCase("Percent"))
		{	
			p.sendMessage("§c" + groupName + "§a taxes are currently set to §c" + amount + "%");
			p.sendMessage("§aThis group is in the §ePaymentGroups§a list.");
			p.sendMessage("§aPlayers in this group are: ");

			String allMembers = "§7";
			for (String member : getMembers())
			{
				allMembers = allMembers + member + "§4; §7";
			}
			
			p.sendMessage(allMembers);
		}
	}
	
	public void addMember(String name)
	{
		members.add(name);
		
	}
}
