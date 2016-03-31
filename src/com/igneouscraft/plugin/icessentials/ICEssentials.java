package com.igneouscraft.plugin.icessentials;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.igneouscraft.plugin.icessentials.features.ExampleFeature;
import com.igneouscraft.plugin.icessentials.features.HelpMenu;
import com.igneouscraft.plugin.icessentials.features.ReloadPlugin;

/**
 * The main class of this plugin. Please only add features in here and don't modify anything else
 * When adding a new feature, please increment the version in the plugin.yml by 0.1
 * @author bl4ckscor3
 */
public class ICEssentials extends JavaPlugin
{
	/**The default prefix of messages*/
	public static final String prefix = ChatColor.GREEN + "[" + ChatColor.GOLD + "IC-Essentials" + ChatColor.GREEN + "] " + ChatColor.WHITE;
	/**Contains all features with commands*/
	private static final ArrayList<Feature> features = new ArrayList<Feature>();
	
	@Override
	public void onEnable()
	{
		reloadConfig();
		//add your features alphabetically below this line
		addFeature(new ExampleFeature()); //adding the example feature
		addFeature(new ReloadPlugin());
		addFeature(new HelpMenu(features)); //this needs to be at the bottom at all times
		//no more features below this line
		getConfig().options().copyDefaults(true);
		saveConfig();
		getServer().getConsoleSender().sendMessage(prefix + "Successfully loaded all features.");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		for(Feature iF : features) //iF stands for initial feature
		{
			if(!(iF instanceof CommandFeature))
				continue;
			
			CommandFeature f = (CommandFeature)iF;
			
			if(cmd.getName().equals(f.getCommandName()))
			{
				if(getConfig().getBoolean(f.getConfigPath()))
					f.executeCommand(this, sender, args);
				else
					sender.sendMessage(prefix + "This feature is disabled.");
			}
		}
		
		return true;
	}
	
	/**
	 * Sets up a feature to use: Generates the neccessary config value and registers listeners
	 * @param feature The feature to set up
	 */
	public void addFeature(Feature feature)
	{
		getConfig().addDefault(feature.getConfigPath(), true);

		if(feature.getListeners().length != 0)
		{
			for(Listener l : feature.getListeners())
			{
				getServer().getPluginManager().registerEvents(l, this);
			}
		}
		
		features.add(feature);
	}
}
