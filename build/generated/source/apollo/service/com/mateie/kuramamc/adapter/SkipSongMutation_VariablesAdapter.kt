//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.0'.
//
package com.mateie.kuramamc.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.mateie.kuramamc.SkipSongMutation
import kotlin.IllegalStateException
import kotlin.Unit

public object SkipSongMutation_VariablesAdapter : Adapter<SkipSongMutation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      SkipSongMutation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: SkipSongMutation,
  ): Unit {
    writer.name("username")
    StringAdapter.toJson(writer, customScalarAdapters, value.username)
  }
}
