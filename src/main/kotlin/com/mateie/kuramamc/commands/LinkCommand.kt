package com.mateie.kuramamc.commands

import com.apollographql.apollo3.exception.ApolloException
import com.github.shynixn.mccoroutine.bukkit.SuspendingCommandExecutor
import com.mateie.kuramamc.KuramaMC
import com.mateie.kuramamc.LinkMinecraftMutation
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object LinkCommand : SuspendingCommandExecutor{
    override suspend fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender !is Player) return false

        if(args.isEmpty()) return false

        try {
            val res = KuramaMC.client.mutation(LinkMinecraftMutation(sender.displayName, args[0])).execute()

            if(res.errors?.isNotEmpty() == true) {
                sender.sendMessage(res.errors!![0].message)
                return true;
            }

            sender.sendMessage(res.data?.linkMinecraft)

        } catch (e: ApolloException) {
            e.printStackTrace()
        }

        return true
    }
}