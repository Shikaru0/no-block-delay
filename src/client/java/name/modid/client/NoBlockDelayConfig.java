package name.modid.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NoBlockDelayConfig {
    private static final Path PATH = FabricLoader.getInstance().getConfigDir().resolve("noblockdelay.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public boolean enabled = true;

    private static NoBlockDelayConfig instance;

    public  static NoBlockDelayConfig get() {
        if (instance == null) {
            load();
        }
        return instance;
    }

    public static void load() {
        try {
            if (Files.exists(PATH)) {
                instance = GSON.fromJson(Files.readString(PATH), NoBlockDelayConfig.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (instance == null) {
            instance = new NoBlockDelayConfig();
            save();
        }
    }

    public static void save() {
        try {
            Files.writeString(PATH, GSON.toJson(get()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
