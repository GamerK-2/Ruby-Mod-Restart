package net.gamerk.rubymod.Blocks.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.gamerk.rubymod.RubyMod;
import net.gamerk.rubymod.item.ModItemGroup;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlock3 {

    public static final Block TOPAZ_BLOCK = registerBlock("topaz_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.TOPAZ);
    public static final Block TOPAZ_ORE = registerBlock("topaz_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.8f).requiresTool()), ModItemGroup.TOPAZ);

    public static final Block AMBER = registerBlock("amber_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).strength(4f).requiresTool()), ModItemGroup.AMBER);

    public static final Block RESIN_BLOCK = registerBlock("resin_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool()), ModItemGroup.AMBER);


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(RubyMod.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block, ItemGroup group) {
        Registry.register(Registry.ITEM, new Identifier(RubyMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModBlocks() {
        RubyMod.LOGGER.info("Registering ModBlocks for " + RubyMod.MOD_ID);

    }
}
