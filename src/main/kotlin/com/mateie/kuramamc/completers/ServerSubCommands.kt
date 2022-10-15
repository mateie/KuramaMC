package com.mateie.kuramamc.completers

import com.github.shynixn.mccoroutine.bukkit.SuspendingTabCompleter
import com.mateie.kuramamc.commands.server.ServerCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.util.StringUtil

object ServerSubCommands : SuspendingTabCompleter{
    override suspend fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): List<String>? {
        val completions: ArrayList<String> = ArrayList()

        StringUtil.copyPartialMatches(args[0], ServerCommand.names, completions)

        completions.sort()

        return completions
    }
}