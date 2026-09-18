package name.modid.client;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.Text;

public class NoBlockDelayClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		NoBlockDelayConfig.load();

		ClientCommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess) -> {
			dispatcher.register(ClientCommandManager.literal("noblockdelay")
					.then(ClientCommandManager.literal("toggle")
							.executes(context -> {
								NoBlockDelayConfig config = NoBlockDelayConfig.get();
								config.enabled = !config.enabled;
								NoBlockDelayConfig.save();

								context.getSource().sendFeedback(Text.literal("noblockdelay:" + (config.enabled ? "Enabled" : "Disabled"))
								);
								return 1;
							}))
					.then(ClientCommandManager.literal("set")
						.then(ClientCommandManager.argument("delay", IntegerArgumentType.integer(0))
							.executes(context -> {
								int delay = IntegerArgumentType.getInteger(context, "delay");

								NoBlockDelayConfig config = NoBlockDelayConfig.get();
								config.delay = delay;
								NoBlockDelayConfig.save();

								context.getSource().sendFeedback(Text.literal("noblockdelay: set delay to " + delay)
								);
								return 1;
							})))
			);
		}));
	}
}