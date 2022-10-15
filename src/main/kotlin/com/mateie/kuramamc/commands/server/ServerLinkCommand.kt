package com.mateie.kuramamc.commands.server

 import com.mateie.kuramamc.KuramaMC
import com.mateie.kuramamc.LinkServerMutation
import com.mateie.kuramamc.structures.SubCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender


object ServerLinkCommand : SubCommand() {
    override suspend fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if(args.isEmpty()) return false

        val ip = KuramaMC.getIp();

        val res = KuramaMC.apollo.mutation(LinkServerMutation(args[0], ip)).execute()

        if(res.errors?.isNotEmpty() == true) {
            sender.sendMessage(res.errors!![0].message)
            return true
        }

        sender.sendMessage(res.data!!.linkServer)

        return true
    }
}