package com.mateie.kuramamc

import com.apollographql.apollo3.ApolloClient
import com.github.shynixn.mccoroutine.bukkit.SuspendingJavaPlugin
import com.github.shynixn.mccoroutine.bukkit.setSuspendingExecutor
import com.github.shynixn.mccoroutine.bukkit.setSuspendingTabCompleter
import com.mateie.kuramamc.commands.LinkCommand
import com.mateie.kuramamc.commands.UnlinkCommand
import com.mateie.kuramamc.commands.music.MusicCommand
import com.mateie.kuramamc.commands.music.MusicPlayCommand
import com.mateie.kuramamc.commands.music.MusicSkipCommand
import com.mateie.kuramamc.commands.music.MusicStopCommand
import com.mateie.kuramamc.completers.MusicSubCommands
import org.bukkit.Bukkit

open class KuramaMC : SuspendingJavaPlugin() {
    companion object {
        val client: ApolloClient = ApolloClient.Builder().serverUrl("http://localhost:4000").webSocketServerUrl("http://localhost:4000").build()
    }

    override suspend fun onEnableAsync() {
        super.onEnableAsync()
        Bukkit.getLogger().info("Plugin Started")

        getCommand("link")!!.setSuspendingExecutor(LinkCommand)
        getCommand("unlink")!!.setSuspendingExecutor(UnlinkCommand)

        getCommand("music")!!.setSuspendingExecutor(MusicCommand)
        getCommand("music")!!.setSuspendingTabCompleter(MusicSubCommands)
        MusicCommand.addSubcommand("play", MusicPlayCommand)
        MusicCommand.addSubcommand("stop", MusicStopCommand)
        MusicCommand.addSubcommand("skip", MusicSkipCommand)
    }

    override suspend fun onDisableAsync() {
        super.onDisableAsync()
    }
}