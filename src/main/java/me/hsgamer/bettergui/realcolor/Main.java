package me.hsgamer.bettergui.realcolor;

import java.util.concurrent.ThreadLocalRandom;
import me.hsgamer.bettergui.lib.xseries.XMaterial;
import me.hsgamer.bettergui.manager.VariableManager;
import me.hsgamer.bettergui.object.addon.Addon;
import net.md_5.bungee.api.ChatColor;

public final class Main extends Addon {

  @Override
  public boolean onLoad() {
    if (!XMaterial.supports(16)) {
      getPlugin().getLogger().warning("[RealColor] Your server is not on 1.16+ !! Disabling");
      return false;
    }
    return true;
  }

  @Override
  public void onEnable() {
    VariableManager.register("hcolor_", (offlinePlayer, s) -> convertHexToColor(s));
    VariableManager.register("hrainbow", (offlinePlayer, s) -> convertHexToColor(
        String.format("%06x", ThreadLocalRandom.current().nextInt(0xFFFFFF + 1))));
  }

  private String convertHexToColor(String hex) {
    return String.valueOf(ChatColor.of("#" + hex));
  }
}
