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
import com.apollographql.apollo3.api.Mutation
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.mateie.kuramamc.adapter.LinkPlayerMutation_ResponseAdapter
import com.mateie.kuramamc.adapter.LinkPlayerMutation_VariablesAdapter
import com.mateie.kuramamc.selections.LinkPlayerMutationSelections
import kotlin.String
import kotlin.Unit

public data class LinkPlayerMutation(
  public val username: String,
  public val code: String,
) : Mutation<LinkPlayerMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    LinkPlayerMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = LinkPlayerMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.mateie.kuramamc.type.Mutation.type
  )
  .selections(selections = LinkPlayerMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(LinkPlayerMutation_ResponseAdapter.Data::class)
  public data class Data(
    public val linkPlayer: String,
  ) : Mutation.Data

  public companion object {
    public const val OPERATION_ID: String =
        "2f03c538dda1eeb6aa72cac1e9ede449a7db26eff71063ae37d6f087f67d9f4c"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation linkPlayer($username: String!, $code: String!) {
     *   linkPlayer(username: $username, code: $code)
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation linkPlayer(${'$'}username: String!, ${'$'}code: String!) { linkPlayer(username: ${'$'}username, code: ${'$'}code) }"

    public const val OPERATION_NAME: String = "linkPlayer"
  }
}