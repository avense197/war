package bukkit.tommytony.war;

import org.bukkit.entity.Player;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.ServerListener;
import org.getspout.spoutapi.player.SpoutPlayer;

public class WarServerListener extends ServerListener {

	public void onPluginDisable(PluginDisableEvent event) {
		if (event.getPlugin().getDataFolder().getName().equals("Spout")) {
			if (War.war.isSpoutServer()) {
				for (Player player : War.war.getServer().getOnlinePlayers()) {
		            SpoutPlayer sp = (SpoutPlayer) player;
		            if (sp.isSpoutCraftEnabled()) {
		                sp.getMainScreen().removeWidgets(War.war);
		            }
		        }
			}
		}
	}
}
