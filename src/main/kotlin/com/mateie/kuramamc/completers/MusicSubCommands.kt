package com.mateie.kuramamc.completers

import com.github.shynixn.mccoroutine.bukkit.SuspendingTabCompleter
import com.mateie.kuramamc.commands.music.MusicCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.util.StringUtil
import java.util.Collections

object MusicSubCommands : SuspendingTabCompleter {
    override suspend fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): List<String> {
        if(sender !is Player) return emptyList()

        val completions: ArrayList<String> = ArrayList()

        StringUtil.copyPartialMatches(args[0], MusicCommand.names, completions)

        completions.sort()
        return completions
    }
}