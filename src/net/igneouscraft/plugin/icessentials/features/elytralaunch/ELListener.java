package net.igneouscraft.plugin.icessentials.features.elytralaunch;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class ELListener implements Listener
{
	private ElytraLaunch feature;
	
	public ELListener(ElytraLaunch f)
	{
		feature = f;
	}
	
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent event)
	{
		Player player = event.getPlayer();

		if(player.isSneaking() && player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SLIME_BLOCK && player.getLocation().getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getType().equals(Material.TNT))
		{
			Material tiermaterial = TierInfo.getTierMaterial(player);
			double tier = TierInfo.getTierMultiplier(tiermaterial);

			if(tier == 0)
			{
				feature.sendMessage(player, "");
				feature.sendMessage(player, "You need an iron, gold or diamond block beneath the tnt to create a slime launcher.");
				feature.sendMessage(player, "(The better the block the higher the tier)");
				feature.sendMessage(player, "");
			}
			else if(TierInfo.hasTierPermission(tiermaterial, player))
			{
				player.playSound(player.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 0.5F, 1);
				player.setVelocity(player.getLocation().getDirection().multiply(1.5 * tier).setY(tier));
				tier = 0;
			}
		}
	}
}
