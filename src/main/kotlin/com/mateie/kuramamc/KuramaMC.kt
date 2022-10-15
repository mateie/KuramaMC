package com.mateie.kuramamc

import com.apollographql.apollo3.ApolloClient
import com.github.shynixn.mccoroutine.bukkit.SuspendingJavaPlugin
import com.github.shynixn.mccoroutine.bukkit.registerSuspendingEvents
import com.github.shynixn.mccoroutine.bukkit.setSuspendingExecutor
import com.github.shynixn.mccoroutine.bukkit.setSuspendingTabCompleter
import com.mateie.kuramamc.commands.PlayerLinkCommand
import com.mateie.kuramamc.commands.PlayerUnlinkCommand
import com.mateie.kuramamc.commands.music.*
import com.mateie.kuramamc.commands.server.ServerCommand
import com.mateie.kuramamc.commands.server.ServerLinkCommand
import com.mateie.kuramamc.completers.MusicSubCommands
import com.mateie.kuramamc.completers.ServerSubCommands
import com.mateie.kuramamc.events.LogsEvent
import org.bukkit.Bukkit
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

open class KuramaMC : SuspendingJavaPlugin() {
    companion object {
        val apollo: ApolloClient = ApolloClient.Builder().serverUrl(System.getenv("BOT_URL") ?: "http://localhost:4000").build()
        fun getIp(): String = run {
            val whatismyip = URL("http://checkip.amazonaws.com")
            val `in` = BufferedReader(InputStreamReader(whatismyip.openStream()))
            return `in`.readLine()
        }
    }

    override suspend fun onEnableAsync() {
        super.onEnableAsync()
        Bukkit.getLogger().info("Plugin Started")

        // Events
        server.pluginManager.registerSuspendingEvents(LogsEvent, this)

        // Commands
        getCommand("link")!!.setSuspendingExecutor(PlayerLinkCommand)
        getCommand("unlink")!!.setSuspendingExecutor(PlayerUnlinkCommand)

        getCommand("music")!!.setSuspendingExecutor(MusicCommand)
        getCommand("music")!!.setSuspendingTabCompleter(MusicSubCommands)
        MusicCommand.addSubcommand("play", MusicPlayCommand)
        MusicCommand.addSubcommand("add", MusicAddCommand)
        MusicCommand.addSubcommand("stop", MusicStopCommand)
        MusicCommand.addSubcommand("skip", MusicSkipCommand)

        getCommand("server")!!.setSuspendingExecutor(ServerCommand)
        getCommand("server")!!.setSuspendingTabCompleter(ServerSubCommands)
        ServerCommand.addSubcommand("link", ServerLinkCommand)
    }

    override suspend fun onDisableAsync() {
        super.onDisableAsync()
    }
}