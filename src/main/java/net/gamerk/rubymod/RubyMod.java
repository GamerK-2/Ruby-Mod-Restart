package net.gamerk.rubymod;

import net.fabricmc.api.ModInitializer;
import net.gamerk.rubymod.Blocks.init.ModBlock2;
import net.gamerk.rubymod.Blocks.init.ModBlock3;
import net.gamerk.rubymod.Blocks.init.ModBlocks;
import net.gamerk.rubymod.enchantments.ModEnchantment;
import net.gamerk.rubymod.item.AppendEnchant;
import net.gamerk.rubymod.item.init.ModItems;
import net.gamerk.rubymod.item.init.ModItems2;
import net.gamerk.rubymod.item.init.ModItems3;
import net.gamerk.rubymod.item.init.ModItems4;
import net.gamerk.rubymod.receipe.ModRecipes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class RubyMod implements ModInitializer {
	public static final String MOD_ID = "rubymod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		AppendEnchant.appendEnchant();

		ModItems.registerModItems();
		ModItems2.registerModItems();
		ModItems3.registerModItems();
		ModItems4.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlock2.registerModBlocks();
		ModBlock3.registerModBlocks();

		ModRecipes.register();

		ModEnchantment.registerModEnchantments();
	}
}
