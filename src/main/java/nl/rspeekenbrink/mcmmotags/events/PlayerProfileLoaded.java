package nl.rspeekenbrink.mcmmotags.events;

import com.gmail.nossr50.events.players.McMMOPlayerProfileLoadEvent;
import com.gmail.nossr50.util.player.UserManager;
import com.nametagedit.plugin.NametagEdit;
import nl.rspeekenbrink.mcmmotags.mcMMOTags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerProfileLoaded implements Listener {
    @EventHandler
    public void playerProfileLoaded(McMMOPlayerProfileLoadEvent event) {
        mcMMOTags.updatePlayerNametag(event.getPlayer());
    }
}
