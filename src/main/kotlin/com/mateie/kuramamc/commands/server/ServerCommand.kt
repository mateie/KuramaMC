package com.mateie.kuramamc.commands.server

import com.github.shynixn.mccoroutine.bukkit.SuspendingCommandExecutor
import com.mateie.kuramamc.structures.SubCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

object ServerCommand : SuspendingCommandExecutor {
    val names = arrayListOf<String>()
    val commands: HashMap<String, SubCommand> = HashMap()

    override suspend fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if(!sender.isOp) {
            sender.sendMessage("Only OPed people can use this command")
            return true
        }

        if(args.isEmpty()) return false

        if(!commands.containsKey(args[0].lowercase())) {
            sender.sendMessage("The subcommand does not exist")
            return true
        }

        return commands[args[0]]!!.onCommand(sender, command, args[0], args.drop(1).toTypedArray())
    }

    fun addSubcommand(name: String, subcommand: SubCommand) {
        commands[name] = subcommand
        names.add(name)
    }
}