package dev.ultreon.xypercode.mods;

import net.fabricmc.api.ModInitializer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("mymod");
    public static final String MOD_ID = "mymod";

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		try {
			var clazz = MyMod.class;
			Files.copy(clazz.getResourceAsStream("/natives/mymod.dll"), Paths.get("mymod.dll"), StandardCopyOption.REPLACE_EXISTING);
			// Files.copy(clazz.getResourceAsStream("/natives/mymod.so"), Paths.get("mymod.so"));
			// Files.copy(clazz.getResourceAsStream("/natives/mymod.dylib"), Paths.get("mymod.dylib"));
		} catch (Exception e) {
			throw new RuntimeException("Failed to copy natives", e);
		}

		System.loadLibrary("mymod");

		nativeInit();
	}

	public native void nativeInit();
}