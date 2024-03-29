package net.igneouscraft.plugin.icessentials.features;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import net.igneouscraft.plugin.icessentials.CommandFeature;

/**
 * A feature to reload the plugin
 * @author bl4ckscor3
 */
public class ReloadPlugin extends CommandFeature
{
	@Override
	public void executeCommand(Plugin pl, CommandSender sender, String[] args)
	{
		if(sender.hasPermission("icessentials.reload"))
		{
			pl.reloadConfig();
			pl.saveConfig();
			sendMessage(sender, "Config successfully reloaded.");
		}
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
	public String getSyntax()
	{
		return "/icreload";
	}

	@Override
	public String[] getExplanation()
	{
		return new String[]{"Reloads this plugin."};
	}

	@Override
	public String getVersion()
	{
		return "1.0";
	}

	@Override
	public String getAuthor()
	{
		return "bl4ckscor3"; //i am the author, so i add my name here
	}
}
