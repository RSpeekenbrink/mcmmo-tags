package nl.rspeekenbrink.mcmmotags.events;

import com.gmail.nossr50.events.experience.McMMOPlayerLevelUpEvent;
import nl.rspeekenbrink.mcmmotags.mcMMOTags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerLevelUp implements Listener {
    @EventHandler
    public void onPlayerLevelUp(McMMOPlayerLevelUpEvent event) {
        mcMMOTags.updatePlayerNametag(event.getPlayer());
    }
}
