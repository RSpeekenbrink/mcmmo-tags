package nl.rspeekenbrink.mcmmotags.events;

import com.gmail.nossr50.events.experience.McMMOPlayerLevelDownEvent;
import nl.rspeekenbrink.mcmmotags.mcMMOTags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerLevelDown implements Listener {
    @EventHandler
    public void onPlayerLevelDown(McMMOPlayerLevelDownEvent event) {
        mcMMOTags.updatePlayerNametag(event.getPlayer());
    }
}
