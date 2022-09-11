package com.mateie.kuramamc.commands.music

import com.github.shynixn.mccoroutine.bukkit.SuspendingCommandExecutor
import com.mateie.kuramamc.structures.SubCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object MusicCommand : SuspendingCommandExecutor {
    val names = arrayListOf<String>()
    val commands: HashMap<String, SubCommand> = HashMap()

    override suspend fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if(sender !is Player) {
            sender.sendMessage("This command can be used only by a player")
            return false
        }

        if(args.isEmpty()) return false

        if(!commands.containsKey(args[0].lowercase())) {
            sender.sendMessage("The sub command does not exist")
            return false
        }

        return commands[args[0]]!!.onCommand(sender, command, args[0], args.drop(1).toTypedArray())
    }

    fun addSubcommand(name: String, subCommand: SubCommand) {
        commands[name] = subCommand
        names.add(name)
    }
}