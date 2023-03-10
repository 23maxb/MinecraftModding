package net.maxbl.firstmod.block;

import net.maxbl.firstmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.maxbl.firstmod.FirstMod.MOD_ID;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> ret = BLOCKS.register(name, block);
        registerBlockItem(name, ret); // Register a BlockItem for this block
        return ret;
    }

    private static <T extends Block> RegistryObject<BlockItem> registerBlockItem(String name,
                                                                                 Supplier<T> block)
    {
        Component.literal("block." + MOD_ID + "." + name);
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));

    }

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)));
}
