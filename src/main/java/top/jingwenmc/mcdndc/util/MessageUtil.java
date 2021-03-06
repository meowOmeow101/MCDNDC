package top.jingwenmc.mcdndc.util;

import org.bukkit.command.CommandSender;
import top.jingwenmc.mcdndc.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Objects;

public class MessageUtil {
    public static void sendConsole(String path) {
        Bukkit.getLogger().info(getPrefix() + getMessage(path));
    }
    public static void sendServer(String path) {
        Bukkit.broadcastMessage(getPrefix() + getMessage(path));
    }
    public static String convert(String original)
    {
        return getPrefix()+ChatColor.translateAlternateColorCodes('&',original);
    }
    public static void sendPlayer(CommandSender player, String path) {
        player.sendMessage(getPrefix() + getMessage(path));
    }
    public static String getPrefix() {
        String original = Main.lang.getConfig().getString(getLanguage() + ".prefix",null);
        if(original==null) {
            langError(getLanguage() + ".prefix");
            return null;
        }
        return ChatColor.translateAlternateColorCodes('&', original);
    }

    public static String getLanguage() {
        return ConfigUtil.getString("lang");
    }
    public static String getMessage(String path) {
        if(Main.lang.getConfig().isSet(getLanguage()+"."+path))
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.lang.getConfig().
                getString(getLanguage() + "." + path)));
        else
        {
            langError(getLanguage() + "." + path);
            return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Main.lang.getConfig().
                    getString(getLanguage() + "." + path)));
        }
    }
    public static Object get(String path) {
        Object r = Main.lang.getConfig().get(getLanguage()+"."+path,null);
        if(r==null) langError(getLanguage()+"."+path);
        return r;
    }
    private static void langError(String path)
    {
        System.out.println("MCDNDC发生语言文件异常: 未找到的键:"+path);
        System.out.println("MCDNDC Language File Error: Key Not Found:"+path);
        System.out.println("已经将当前的语言文件保存至\"lang_backup_"+System.currentTimeMillis()+".yml\"");
        System.out.println("The current language file has been saved to\"lang_backup_"+System.currentTimeMillis()+".yml\"");
        Main.lang.forceRename("lang_backup_"+System.currentTimeMillis()+".yml");
        Main.lang = new ConfigAccessor(Main.getInstance(),"lang.yml");
        Main.lang.saveDefaultConfig();
    }
}
