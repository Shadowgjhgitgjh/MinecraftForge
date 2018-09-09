package com.shadowlight.test;

import org.apache.logging.log4j.Logger;

import com.shadowlight.test.proxy.CommonProxy;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = DerpMod.MODID, name = DerpMod.NAME, version = DerpMod.VERSION)
public class DerpMod
{
    public static final String MODID = "derpmod";
    public static final String NAME = "Derping Around";
    public static final String VERSION = "0.0.004";

    private static Logger logger;
    
    @Mod.Instance(MODID)
    public static DerpMod instance;
    
	@SidedProxy(serverSide = "com.shadowlight.test.proxy.CommonProxy", clientSide = "com.shadowlight.test.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
	
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ModItems.register(event.getRegistry());
			ModItems.registerModels();
		}
	
	}
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    
    @EventHandler
    public void postInit(FMLInitializationEvent event)
    {
    	
    }
}
