package com.mateie.kuramamc.commands

import com.apollographql.apollo3.exception.ApolloException
import com.github.shynixn.mccoroutine.bukkit.SuspendingCommandExecutor
import com.mateie.kuramamc.KuramaMC
import com.mateie.kuramamc.LinkPlayerMutation
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object PlayerLinkCommand : SuspendingCommandExecutor{
    override suspend fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender !is Player) return false

        if(args.isEmpty()) return false

        try {
            val res = KuramaMC.apollo.mutation(LinkPlayerMutation(sender.name, args[0])).execute()

            if(res.errors?.isNotEmpty() == true) {
                sender.sendMessage(res.errors!![0].message)
                return true
            }

            sender.sendMessage(res.data!!.linkPlayer)

        } catch (e: ApolloException) {
            e.printStackTrace()
        }

        return true
    }
}