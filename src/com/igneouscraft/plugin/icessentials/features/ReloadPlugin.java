package com.igneouscraft.plugin.icessentials.features;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import com.igneouscraft.plugin.icessentials.CommandFeature;

/**
 * A feature to reload the plugin
 * @author bl4ckscor3
 */
public class ReloadPlugin extends CommandFeature
{
	@Override
	public void executeCommand(Plugin pl, CommandSender sender, String[] args)
	{
		pl.reloadConfig();
		pl.saveConfig();
		sendMessage(sender, "Config successfully reloaded.");
	}

	@Override
	public String getCommandName()
	{
		return "icreload";
	}
	
	@Override
	public String getConfigPath()
	{
		return "reload";
	}

	@Override
	public String getAuthor()
	{
		return "bl4ckscor3";
	}
}
