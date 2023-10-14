package cc.mewcraft.reforge.command;

import cc.mewcraft.reforge.ReforgePlugin;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PluginCommands {
    private final ReforgePlugin plugin;
    private final CommandRegistry registry;

    @Inject
    public PluginCommands(
        ReforgePlugin plugin,
        CommandRegistry registry
    ) {
        this.plugin = plugin;
        this.registry = registry;
    }

    public void registerCommands() {
        // Prepare commands
        registry.prepareCommand(registry
            .commandBuilder("reforge")
            .literal("reload")
            .permission("reforge.command.reload")
            .handler(ctx -> {
                plugin.onDisable();
                plugin.onEnable();
            }).build());

        // Register commands
        registry.registerCommands();
    }
}
