//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.0'.
//
package com.mateie.kuramamc.selections

import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.notNull
import com.mateie.kuramamc.type.GraphQLString
import kotlin.collections.List

public object MusicPlayMutationSelections {
  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "music",
          type = GraphQLString.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("action", CompiledVariable("action")).build(),
          CompiledArgument.Builder("query", CompiledVariable("query")).build(),
          CompiledArgument.Builder("username", CompiledVariable("username")).build()
        ))
        .build()
      )
}
