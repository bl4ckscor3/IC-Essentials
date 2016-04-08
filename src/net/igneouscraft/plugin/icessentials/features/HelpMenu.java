package net.igneouscraft.plugin.icessentials.features;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import net.igneouscraft.plugin.icessentials.CommandFeature;
import net.igneouscraft.plugin.icessentials.Feature;
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

		helpAdder:
		if(args.length == 1)
		{	
			for(Feature f : features)
			{
				boolean cmd = f instanceof CommandFeature;
				
				if(f.getName().equalsIgnoreCase(args[0])) //if the currently iterated feature is the one the user requested
				{
					helpToSend.add("~~~~~~~~~~~~" + ChatColor.BLUE + "Help for: " + f.getName() + ChatColor.GOLD + "~~~~~~~~~~~~");
					
					if(cmd)
					{
						helpToSend.add("Syntax: " + ChatColor.WHITE + ((CommandFeature)f).getSyntax());
						helpToSend.add("");
					}
					
					helpToSend.addAll(Arrays.asList(f.getExplanation()));
					helpToSend.add("");
					helpToSend.add("Author: " + ChatColor.WHITE + f.getAuthor());
					helpToSend.add("Version: " + ChatColor.WHITE + f.getVersion());
					break helpAdder;
				}
			}
			
			//if no ic-essentials feature fit the args
			String cmd = "bukkit:help ";
			
			for(String s : args)
			{
				cmd += s + " ";
			}
			
			pl.getServer().dispatchCommand(sender, cmd.trim());
			return;
		}
		else
		{
			pl.getServer().dispatchCommand(sender, "bukkit:help");
			return;
		}
		
		helpToSend.add("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(String s : helpToSend)
		{
			sendMessage(sender, s);
		}
	}

	@Override
	public String getCommandName()
	{
		return "help";
	}

	@Override
	public String getConfigPath()
	{
		return "help";
	}

	@Override
	public String[] getExplanation()
	{
		return new String[]{"Helps with IC-Essentials' features and commands, including other plugins."};
	}

	@Override
	public String getSyntax()
	{
		return "/ichelp [feature]";
	}

	@Override
	public String getVersion()
	{
		return "1.2";
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
}
