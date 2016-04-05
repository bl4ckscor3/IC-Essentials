package net.igneouscraft.plugin.icessentials.features;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import net.igneouscraft.plugin.icessentials.CommandFeature;

/**
 * An example feature to show how the usage of this system is supposed to work
 * @author bl4ckscor3
 */
public class ExampleFeature extends CommandFeature
{
	@Override
	public void executeCommand(Plugin pl, CommandSender sender, String[] args)
	{
		String result = "";
		
		for(String s : args) //for each value in the args array add it to the result String
		{
			result += s + " ";
		}
		
		sendMessage(sender, (args.length == 0 ? "You did not write anything after the command." : result.trim())); //sends whatever the command is appended by
		// a call of "/example This is a test." would send "This is a test." with the appropriate prefix to the sender, wether it's the console or other
	}

	@Override
	public String getCommandName()
	{
		return "example";
	}

	//no listeners are needed for this feature, so i just don't override the method

	@Override
	public String getConfigPath()
	{
		return "exampleFeature"; //the config option that needs to be changed to disable this feature can be found under "exampleFeature"
	}

	@Override
	public String getChatPrefix()
	{
		return ChatColor.AQUA + "You wrote > " + ChatColor.DARK_AQUA; //custom chat prefix
	}

	@Override
	public String getSyntax()
	{
		return "/example [sentence]";
	}

	@Override
	public String[] getExplanation()
	{
		return new String[]{"Echoes everything you say after the command."};
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
