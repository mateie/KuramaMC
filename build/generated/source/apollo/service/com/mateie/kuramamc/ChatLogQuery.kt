//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.6.1'.
//
package com.mateie.kuramamc

import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.mateie.kuramamc.adapter.ChatLogQuery_ResponseAdapter
import com.mateie.kuramamc.adapter.ChatLogQuery_VariablesAdapter
import com.mateie.kuramamc.selections.ChatLogQuerySelections
import kotlin.Boolean
import kotlin.String
import kotlin.Unit

public data class ChatLogQuery(
  public val username: String,
  public val message: String,
  public val ip: String,
) : Query<ChatLogQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    ChatLogQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = ChatLogQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.mateie.kuramamc.type.Query.type
  )
  .selections(selections = ChatLogQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(ChatLogQuery_ResponseAdapter.Data::class)
  public data class Data(
    public val chatLog: Boolean?,
  ) : Query.Data

  public companion object {
    public const val OPERATION_ID: String =
        "c1e6f677496b7e6e6941e90c73453df212793dcf703e3970dbc49acb5f5de376"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query ChatLog($username: String!, $message: String!, $ip: String!) {
     *   chatLog(username: $username, message: $message, ip: $ip)
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query ChatLog(${'$'}username: String!, ${'$'}message: String!, ${'$'}ip: String!) { chatLog(username: ${'$'}username, message: ${'$'}message, ip: ${'$'}ip) }"

    public const val OPERATION_NAME: String = "ChatLog"
  }
}
