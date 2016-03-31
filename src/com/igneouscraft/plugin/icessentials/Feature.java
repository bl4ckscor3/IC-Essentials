package com.igneouscraft.plugin.icessentials;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

/**
 * Models a feature of this plugin
 * You need to handle disabling non command features yourself
 * @author bl4ckscor3
 */
public abstract class Feature implements IHelp
{
	/**
	 * @return All listeners this feature requires. "return null" if none are needed. Please create your own listeners instead of using already existing ones
	 */
	public Listener[] getListeners()
	{
		return new Listener[]{};
	}
	
	/**
	 * @return The name of this feature used in the help menu to determine if the given feature is the correct one
	 */
	public abstract String getName();
	
	/**
	 * @return The path to the config value to enable/disable this feature
	 */
	public abstract String getConfigPath();
	
	/**
	 * @return The prefix that will be used when sending a message to an instance (player, console, etc)
	 */
	public String getChatPrefix()
	{
		return ICEssentials.prefix;
	}
	
	/**
	 * Sends a message to the given instance with the prefix of this feature. If no prefix is given, the plugin's default will be used
	 * @param sender The instance to send the message to
	 * @param msg The message to send
	 */
	public final void sendMessage(CommandSender sender, String msg)
	{
		sender.sendMessage(getChatPrefix() + msg);
	}
}
