package me.hsgamer.bettergui.realcolor;

import me.hsgamer.bettergui.lib.xseries.XMaterial;
import me.hsgamer.bettergui.manager.VariableManager;
import me.hsgamer.bettergui.object.GlobalVariable;
import me.hsgamer.bettergui.object.addon.Addon;
import org.bukkit.ChatColor;

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
    GlobalVariable hexColorVariable = (offlinePlayer, s) -> {
      if (s.length() != 6) {
        return null;
      }

      try {
        Integer.parseInt(s, 16);
      } catch (NumberFormatException e) {
        return null;
      }

      StringBuilder builder = new StringBuilder(ChatColor.COLOR_CHAR + "x");
      for (char c : s.toCharArray()) {
        builder.append(ChatColor.COLOR_CHAR).append(c);
      }
      return builder.toString();
    };
    VariableManager.register("hcolor_", hexColorVariable);
    VariableManager.register("#", hexColorVariable);
  }
}
