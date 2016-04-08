package net.igneouscraft.plugin.icessentials.features.elytralaunch;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

/**
 * Utility class for ElytraLaunch
 * @author JustRamon
 */
public class TierInfo
{
	/**
	 * Gets the material three blocks below the player
	 * @param player The player to check the block relative from
	 * @return The material three blocks below the player
	 */
	public static Material getTierMaterial(Player player)
	{
		return player.getLocation().getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getType();
	}
	
	/**
	 * Defines how hard the player gets launched into the air depending on the material
	 * @param blocktype The material to get the launch multiplier from
	 * @return The launch multiplier depending on the material
	 */
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
	
	/**
	 * Checks wether a player has permission to use the launcher of a specific material
	 * @param tier The material the player wants to use
	 * @param player The player to check the permissions of
	 * @return true if the player has permission to use it, false otherwhise
	 */
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
