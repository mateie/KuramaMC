//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.6.1'.
//
package com.mateie.kuramamc.selections

import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.mateie.kuramamc.type.GraphQLBoolean
import kotlin.collections.List

public object ChatLogQuerySelections {
  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "chatLog",
          type = GraphQLBoolean.type
        ).arguments(listOf(
          CompiledArgument.Builder("ip", CompiledVariable("ip")).build(),
          CompiledArgument.Builder("message", CompiledVariable("message")).build(),
          CompiledArgument.Builder("username", CompiledVariable("username")).build()
        ))
        .build()
      )
}