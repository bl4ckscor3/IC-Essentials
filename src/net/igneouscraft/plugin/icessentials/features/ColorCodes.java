package net.igneouscraft.plugin.icessentials.features;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import net.igneouscraft.plugin.icessentials.CommandFeature;

/**
 * A feature to show all chat formatting codes of Minecraft
 * @author bl4ckscor3
 */
public class ColorCodes extends CommandFeature
{
	@Override
	public void executeCommand(Plugin pl, CommandSender sender, String[] args)
	{
		sendMessage(sender, "&/0: " + ChatColor.BLACK + "Black");
		sendMessage(sender, "&/1: " + ChatColor.DARK_BLUE + "Dark Blue");
		sendMessage(sender, "&/2: " + ChatColor.DARK_GREEN + "Dark Green");
		sendMessage(sender, "&/3: " + ChatColor.DARK_AQUA + "Cyan");
		sendMessage(sender, "&/4: " + ChatColor.DARK_RED + "Dark Red");
		sendMessage(sender, "&/5: " + ChatColor.DARK_PURPLE + "Purple");
		sendMessage(sender, "&/6: " + ChatColor.GOLD + "Orange");
		sendMessage(sender, "&/7: " + ChatColor.GRAY + "Grey");
		sendMessage(sender, "&/8: " + ChatColor.DARK_GRAY + "Dark Grey");
		sendMessage(sender, "&/9: " + ChatColor.BLUE + "Blue");
		sendMessage(sender, "&/a: " + ChatColor.GREEN + "Green");
		sendMessage(sender, "&/b: " + ChatColor.AQUA + "Aqua");
		sendMessage(sender, "&/c: " + ChatColor.RED + "Red");
		sendMessage(sender, "&/d: " + ChatColor.LIGHT_PURPLE + "Magenta");
		sendMessage(sender, "&/e: " + ChatColor.YELLOW + "Yellow");
		sendMessage(sender, "&/f: " + ChatColor.WHITE + "White");
		sendMessage(sender, "&/l: " + ChatColor.BOLD + "Bold");
		sendMessage(sender, "&/m: " + ChatColor.STRIKETHROUGH + "Strikethrough");
		sendMessage(sender, "&/n: " + ChatColor.UNDERLINE + "Underlined");
		sendMessage(sender, "&/o: " + ChatColor.ITALIC + "Italics");
		sendMessage(sender, "&/r: " + ChatColor.RESET + "Remove all formatting");
	}
	
	@Override
	public String getCommandName()
	{
		return "cc";
	}
	
	@Override
	public String getSyntax()
	{
		return "/cc";
	}
	
	@Override
	public String[] getExplanation()
	{
		return new String[]{"Shows all the chat formatting codes Minecraft uses."};
	}

	@Override
	public String getVersion()
	{
		return "1.0";
	}

	@Override
	public String getAuthor()
	{
		return "bl4ckscor3";
	}

	@Override
	public String getConfigPath()
	{
		return "colorcodes";
	}
}
