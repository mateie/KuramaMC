package com.mateie.kuramamc.structures

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

abstract class SubCommand {
    abstract suspend fun onCommand(sender: CommandSender, command: Command, args: Array<out String>): Boolean;
}