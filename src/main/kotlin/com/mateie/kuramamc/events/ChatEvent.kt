package com.mateie.kuramamc.events

import com.mateie.kuramamc.ChatLogQuery
import com.mateie.kuramamc.KuramaMC
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

object LogsEvent : Listener {
    @EventHandler
    suspend fun onPlayerChatEvent(e: AsyncPlayerChatEvent) {
        val res = KuramaMC.apollo.query(ChatLogQuery(e.player.name, e.message, KuramaMC.getIp())).execute()

        if(res.errors?.isNotEmpty() == true) {
            e.player.sendMessage(res.errors!![0].message)
        }
    }
}