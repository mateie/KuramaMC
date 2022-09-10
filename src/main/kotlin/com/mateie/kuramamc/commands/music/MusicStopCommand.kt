package com.mateie.kuramamc.commands.music

import com.mateie.kuramamc.KuramaMC
import com.mateie.kuramamc.StopPlayerMutation
import com.mateie.kuramamc.structures.SubCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

object MusicStopCommand : SubCommand() {
    override suspend fun onCommand(sender: CommandSender, command: Command, args: Array<out String>): Boolean {
        if(args.isNotEmpty()) return false

        val res = KuramaMC.client.mutation(StopPlayerMutation(sender.name)).execute()

        if(res.errors?.isNotEmpty() == true) {
            sender.sendMessage(res.errors!![0].message)
            return true
        }

        sender.sendMessage(res.data!!.stopPlayer)

        return true
    }
}