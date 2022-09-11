package com.mateie.kuramamc.structures

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

abstract class SubCommand {
    abstract suspend fun onCommand(sender: CommandSender, parent: Command, command: String, args: Array<out String>): Boolean
}