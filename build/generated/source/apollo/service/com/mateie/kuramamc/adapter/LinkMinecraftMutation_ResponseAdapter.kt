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
import com.mateie.kuramamc.LinkMinecraftMutation
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object LinkMinecraftMutation_ResponseAdapter {
  public object Data : Adapter<LinkMinecraftMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("linkMinecraft")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        LinkMinecraftMutation.Data {
      var _linkMinecraft: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _linkMinecraft = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return LinkMinecraftMutation.Data(
        linkMinecraft = _linkMinecraft!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: LinkMinecraftMutation.Data,
    ): Unit {
      writer.name("linkMinecraft")
      StringAdapter.toJson(writer, customScalarAdapters, value.linkMinecraft)
    }
  }
}
