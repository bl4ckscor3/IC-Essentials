package com.igneouscraft.plugin.icessentials;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

/**
 * Models a feature of this plugin
 * @author bl4ckscor3
 */
public abstract class Feature
{
	/**
	 * @return All listeners this feature requires. "return null" if none are needed. Please create your own listeners instead of using already existing ones
	 */
	public Listener[] getListeners()
	{
		return new Listener[]{};
	}
	
	/**
	 * @return The path to the config value to enable/disable this feature
	 */
	public abstract String getConfigPath();
	
	/**
	 * @return The author of this feature
	 */
	public abstract String getAuthor();
	
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
