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
import com.apollographql.apollo3.api.notNull
import com.mateie.kuramamc.type.GraphQLBoolean
import kotlin.collections.List

public object CheckPlayerMutationSelections {
  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "checkPlayer",
          type = GraphQLBoolean.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("username", CompiledVariable("username")).build()
        ))
        .build()
      )
}