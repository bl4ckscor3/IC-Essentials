package net.igneouscraft.plugin.icessentials.features;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import net.igneouscraft.plugin.icessentials.CommandFeature;

/**
 * Hooks into Essential's /nick command to check wether a nick change should be performed or not
 * @author bl4ckscor3
 */
public class Nick extends CommandFeature
{
	@Override
	public void executeCommand(Plugin pl, CommandSender sender, String[] args)
	{
		if((!(sender instanceof Player) && args.length != 2) || !sender.hasPermission("icessentials.nick"))
		{
			sendMessage(sender, ChatColor.DARK_RED + "You do not have access to that command.");
			return;
		}
		
		if(args.length == 2)
		{
			if(sender.hasPermission("icessentials.nick.others"))
			{
				if(Bukkit.getPlayer(args[0]) != null)
					pl.getServer().dispatchCommand(pl.getServer().getConsoleSender(), "essentials:nick " + args[0] + " " + args[1]);
				else
					sendMessage(sender, ChatColor.DARK_RED + "This player is not on the server.");
			}
			else
				sendMessage(sender, ChatColor.DARK_RED + "You do not have access to that command.");
			
			return;
		}
		
		Player p = (Player)sender;
			
		if(args.length == 0)
		{
			sendMessage(p, "Change your nickname or that of another player.");
			sendMessage(p, "/nick [player] <nickname|off>");
		}
		
		if(args.length == 1)
		{
			if(args[0].equals("off"))
			{
				pl.getServer().dispatchCommand(pl.getServer().getConsoleSender(), "essentials:nick " + p.getName() + " off");
				return;
			}
			else
			{
				if(p.hasPermission("icessentials.nick.special"))
				{
					pl.getServer().dispatchCommand(pl.getServer().getConsoleSender(), "essentials:nick " + p.getName() + " " + args[0]);
					return;
				}
				
				StringBuilder b = new StringBuilder(args[0]);
				
				b.replace(b.length() - 1, b.length() - 1, "");
				
				loop:
				for(int i = 0; i < b.length() - 1; i++)
				{
					if(b.charAt(i) == '&')
					{
						switch(b.charAt(i + 1))
						{
							case 'k': case 'l': case 'm': case 'n': case 'o': //making sure that the name is incorrect if anything else than colors is used
								b.delete(0, b.length() - 1);
								b.append("dj9wdfj8934fj3q0ucr9qn30");
								break loop;
							default:
								b.replace(i, i + 2, "");
						}
					}
				}
				
				if(b.toString().equals(p.getName()))
					pl.getServer().dispatchCommand(pl.getServer().getConsoleSender(), "essentials:nick " + p.getName() + " " + args[0]);
				else
					sendMessage(sender, ChatColor.GOLD + "You cannot name yourself " + ChatColor.WHITE + args[0] + ChatColor.GOLD + ". You are only allowed to change colors.");
			}
		}
	}
	
	@Override
	public String getCommandName()
	{
		return "nick";
	}

	@Override
	public String getSyntax()
	{
		return "/nick [player] <nickname|off>";
	}
	
	@Override
	public String[] getExplanation()
	{
		return new String[]{"Checks wether a nickchange is allowed or not."};
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
		return "nick";
	}
	
	@Override
	public String getChatPrefix()
	{
		return "";
	}
}
