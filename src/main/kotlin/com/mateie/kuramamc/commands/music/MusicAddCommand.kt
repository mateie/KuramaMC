package com.mateie.kuramamc.commands.music

import com.mateie.kuramamc.KuramaMC
import com.mateie.kuramamc.MusicPlayMutation
import com.mateie.kuramamc.structures.SubCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

object MusicAddCommand : SubCommand() {
    override suspend fun onCommand(
        sender: CommandSender,
        parent: Command,
        command: String,
        args: Array<out String>
    ): Boolean {
        if(args.isEmpty()) return false

        val res = KuramaMC.apollo.mutation(MusicPlayMutation(sender.name, command, args.joinToString(" "))).execute()

        if(res.errors?.isNotEmpty() == true) {
            sender.sendMessage(res.errors!![0].message)
            return true
        }

        sender.sendMessage(res.data!!.music)

        return true
    }
}
