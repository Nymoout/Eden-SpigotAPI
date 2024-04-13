package rip.diamond.spigotapi.knockback.impl;

import dev.cobblesword.nachospigot.knockback.KnockbackProfile;
import ga.windpvp.windspigot.knockback.KnockbackConfig;
import org.bukkit.entity.Player;
import rip.diamond.practice.config.Language;
import rip.diamond.spigotapi.knockback.AbstractKnockback;
import rip.diamond.spigotapi.util.Reflection;

public class WindSpigotKnockback extends AbstractKnockback {
    @Override
    public void applyKnockback(Player player, String knockbackName) {
//        System.out.println("applyingKnockback to " + player.getName() + " trying to " + knockbackName);
        KnockbackProfile profile = KnockbackConfig.getKbProfileByName(knockbackName);
        if (profile == null) {
            Language.HOOK_ERROR_KNOCKBACK_NOT_FOUND.sendMessage(player);
            return;
        }
        Reflection.method(player, "setKnockbackProfile", profile);
//        System.out.println("apply to " + player.getName() + " new Knockback is " + knockbackName);
    }
}
