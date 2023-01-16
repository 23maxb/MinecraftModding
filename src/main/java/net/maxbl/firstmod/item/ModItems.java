package net.maxbl.firstmod.item;

import net.maxbl.firstmod.FirstMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.maxbl.firstmod.FirstMod.MOD_ID;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().stacksTo(64)));
}
