package nl.rspeekenbrink.mcmmotags;

import com.gmail.nossr50.util.player.UserManager;
import com.nametagedit.plugin.NametagEdit;
import nl.rspeekenbrink.mcmmotags.events.PlayerLevelDown;
import nl.rspeekenbrink.mcmmotags.events.PlayerLevelUp;
import nl.rspeekenbrink.mcmmotags.events.PlayerProfileLoaded;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class mcMMOTags extends JavaPlugin {
    public static Plugin plugin;
    protected PluginManager pluginManager;

    public mcMMOTags() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        pluginManager = getServer().getPluginManager();

        if (pluginManager.getPlugin("mcMMO") == null) {
            getLogger().severe("mcMMO not found, disabling mcMMO tags...");
            getPluginLoader().disablePlugin(this);
        }

        pluginManager.registerEvents(new PlayerProfileLoaded(), plugin);
        pluginManager.registerEvents(new PlayerLevelUp(), plugin);
        pluginManager.registerEvents(new PlayerLevelDown(), plugin);

        getLogger().info("mcMMO tags enabled!");
    }

    public static void updatePlayerNametag(Player player) {
        mcMMOTags.plugin.getServer().getScheduler().scheduleSyncDelayedTask(mcMMOTags.plugin, new Runnable() {
            @Override
            public void run() {
                ChatColor levelColor = ChatColor.GREEN;
                int powerLevel = UserManager.getPlayer(player).getPowerLevel();

                if (powerLevel > 250) {
                    levelColor = ChatColor.DARK_GREEN;
                }
                if (powerLevel > 500) {
                    levelColor = ChatColor.YELLOW;
                }
                if (powerLevel > 750) {
                    levelColor = ChatColor.GOLD;
                }
                if (powerLevel > 1000) {
                    levelColor = ChatColor.RED;
                }
                if (powerLevel > 1500) {
                    levelColor = ChatColor.DARK_RED;
                }

                NametagEdit.getApi().setSuffix(
                        player,
                        " &r&8[&r" + levelColor + powerLevel + "&r&8]&r"
                );
            }
        });
    }
}
