package com.mateie.kuramamc.commands

import com.apollographql.apollo3.exception.ApolloException
import com.github.shynixn.mccoroutine.bukkit.SuspendingCommandExecutor
import com.mateie.kuramamc.KuramaMC
import com.mateie.kuramamc.UnlinkMinecraftMutation
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object UnlinkCommand : SuspendingCommandExecutor{
    override suspend fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if(sender !is Player) return false

        if(args.isNotEmpty()) return false

        try {
            val res = KuramaMC.client.mutation(UnlinkMinecraftMutation(sender.displayName)).execute()

            if(res.errors?.isNotEmpty() == true) {
                sender.sendMessage(res.errors!![0].message)
                return true
            }

            sender.sendMessage(res.data?.unlinkMinecraft)

        } catch (e: ApolloException) {
            e.printStackTrace()
        }

        return true
    }
}