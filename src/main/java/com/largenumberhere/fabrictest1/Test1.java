package com.largenumberhere.fabrictest1;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1 implements ModInitializer {
	public static final String MOD_ID = "test-1";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocksRegistry.create()
				.onInitialize();
		ModItemsRegisry.create()
				.onInitialize();

		LOGGER.info("Initialized testmod");
	}
}

