package com.mateie.kuramamc

import com.apollographql.apollo3.ApolloClient
import com.github.shynixn.mccoroutine.bukkit.SuspendingJavaPlugin
import com.github.shynixn.mccoroutine.bukkit.setSuspendingExecutor
import com.github.shynixn.mccoroutine.bukkit.setSuspendingTabCompleter
import com.mateie.kuramamc.commands.LinkCommand
import com.mateie.kuramamc.commands.UnlinkCommand
import com.mateie.kuramamc.commands.music.*
import com.mateie.kuramamc.completers.MusicSubCommands
import org.bukkit.Bukkit

open class KuramaMC : SuspendingJavaPlugin() {
    companion object {
        val apollo: ApolloClient = ApolloClient.Builder().serverUrl(System.getenv("BOT_URL") ?: "http://localhost:4000").build()
    }

    override suspend fun onEnableAsync() {
        super.onEnableAsync()
        Bukkit.getLogger().info("Plugin Started")

        getCommand("link")!!.setSuspendingExecutor(LinkCommand)
        getCommand("unlink")!!.setSuspendingExecutor(UnlinkCommand)

        getCommand("music")!!.setSuspendingExecutor(MusicCommand)
        getCommand("music")!!.setSuspendingTabCompleter(MusicSubCommands)
        MusicCommand.addSubcommand("play", MusicPlayCommand)
        MusicCommand.addSubcommand("add", MusicAddCommand)
        MusicCommand.addSubcommand("stop", MusicStopCommand)
        MusicCommand.addSubcommand("skip", MusicSkipCommand)
    }

    override suspend fun onDisableAsync() {
        super.onDisableAsync()
    }
}