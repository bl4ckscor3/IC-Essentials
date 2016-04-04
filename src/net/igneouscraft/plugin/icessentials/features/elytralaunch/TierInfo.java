package net.igneouscraft.plugin.icessentials.features.elytralaunch;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public class TierInfo
{
	public static Material getTierMaterial(Player player)
	{
		return player.getLocation().getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getType();
	}
	
	public static double getTierMultiplier(Material blocktype)
	{
		switch(blocktype)
		{
			case IRON_BLOCK: return 1.5; 
			case GOLD_BLOCK: return 2.3; 
			case DIAMOND_BLOCK: return 4;
			default: return 0;
		}
	}
	
	public static boolean hasTierPermission(Material tier, Player player)
	{
		switch(tier)
		{
			case IRON_BLOCK: if(player.hasPermission("icessentials.elytralaunch.iron")){return true;} break;
			case GOLD_BLOCK: if(player.hasPermission("icessentials.elytralaunch.gold")){return true;} break;
			case DIAMOND_BLOCK: if(player.hasPermission("icessentials.elytralaunch.diamond")){return true;} break;
			default: return false;
		}
		return false;
	}
}
