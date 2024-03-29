package net.igneouscraft.plugin.icessentials;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

/**
 * Models a feature that needs a command to work. Don't use this if you have no need for a command in your feature
 * You do NOT need to handle disabling command features yourself
 * NOTE: You still need to add the command to the plugin.yml, this is not done automatically for you
 * @author bl4ckscor3
 */
public abstract class CommandFeature extends Feature implements ICommandHelp
{
	/**
	 * Executes the command of this feature. NOTE: You can still limit the command to only Player or only Console etc. in this method
	 * @param pl The plugin this command gets executed from
	 * @param sender The instance who sent the command
	 * @param args The arguments of the command excluding the command itself
	 */
	public abstract void executeCommand(Plugin pl, CommandSender sender, String[] args);
	
	/**
	 * @return The String that triggers the command. NOTE: You can still add aliases to the plugin.yml without interfering with anything
	 */
	public abstract String getCommandName();
	
	@Override
	public final String getName()
	{
		return getCommandName();
	}
}
