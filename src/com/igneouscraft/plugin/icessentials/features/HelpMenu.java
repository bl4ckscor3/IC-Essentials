package com.igneouscraft.plugin.icessentials.features;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import com.igneouscraft.plugin.icessentials.CommandFeature;
import com.igneouscraft.plugin.icessentials.Feature;
import com.igneouscraft.plugin.icessentials.ICEssentials;

import net.md_5.bungee.api.ChatColor;

/**
 * Help menu
 * @author bl4ckscor3
 */
public class HelpMenu extends CommandFeature
{
	private ArrayList<Feature> features;

	public HelpMenu(ArrayList<Feature> f)
	{
		features = f;
	}

	@Override
	public void executeCommand(Plugin pl, CommandSender sender, String[] args)
	{
		ArrayList<String> helpToSend = new ArrayList<String>();

		if(args.length == 1)
		{	
			for(Feature f : features)
			{
				boolean cmd = f instanceof CommandFeature;
				
				if((cmd ? ((CommandFeature)f).getCommandName() : getName()).equals(args[0])) //if the currently iterated feature is the one the user requested
				{
					helpToSend.add("~~~~~~~~~~~~" + ChatColor.BLUE + "Help for: " + (cmd ? ((CommandFeature)f).getCommandName() : getName()) + ChatColor.GOLD + "~~~~~~~~~~~~");
					
					if(cmd)
						helpToSend.add("Syntax: " + ChatColor.WHITE + ((CommandFeature)f).getSyntax());
					
					helpToSend.add("");
					helpToSend.addAll(Arrays.asList(f.getExplanation()));
					helpToSend.add("");
					helpToSend.add("Author: " + ChatColor.WHITE + f.getAuthor());
					helpToSend.add("Version: " + ChatColor.WHITE + f.getVersion());
					break;
				}
			}
			
			sendMessage(sender, ICEssentials.prefix + "No help found.");
		}
		else
		{
			helpToSend.add("~~~~~~~~~~~~" + ChatColor.BLUE + "IC-Essentials Help" + ChatColor.GOLD + "~~~~~~~~~~~~");
			helpToSend.addAll(Arrays.asList(getExplanation()));
			helpToSend.add("");
			helpToSend.add("Author: " + ChatColor.WHITE + getAuthor());
			helpToSend.add("Version: " + ChatColor.WHITE + getVersion());
		}
		
		for(String s : helpToSend)
		{
			sendMessage(sender, s);
		}
	}

	@Override
	public String getCommandName()
	{
		return "ichelp";
	}

	@Override
	public String getConfigPath()
	{
		return "help";
	}

	@Override
	public String[] getExplanation()
	{
		return new String[]{"Shows help for features."};
	}

	@Override
	public String getSyntax()
	{
		return "/ichelp [feature]";
	}

	@Override
	public String getVersion()
	{
		return "0.1";
	}

	@Override
	public String getAuthor()
	{
		return "bl4ckscor3";
	}

	@Override
	public String getChatPrefix()
	{
		return "" + ChatColor.GOLD;
	}
	
	@Override
	public boolean useDefaultPrefix()
	{
		return false;
	}
}
