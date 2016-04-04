package net.igneouscraft.plugin.icessentials.features.elytralaunch;

import org.bukkit.event.Listener;

import net.igneouscraft.plugin.icessentials.Feature;

public class ElytraLaunch extends Feature
{
	@Override
	public Listener[] getListeners()
	{
		return new Listener[]{new ELListener(this)};
	}
	
	@Override
	public String[] getExplanation()
	{
		return new String[] {"Adds elytra launchers into the game."};
	}
	
	@Override
	public String getChatPrefix()
	{
		return "";
	}

	@Override
	public String getVersion()
	{
		return "1.0";
	}

	@Override
	public String getAuthor()
	{
		return "JustRamon";
	}

	@Override
	public String getName()
	{
		return "ElytraLaunch";
	}

	@Override
	public String getConfigPath()
	{
		return "elytralaunch";
	}
}
