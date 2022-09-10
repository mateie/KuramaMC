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
import com.mateie.kuramamc.StopPlayerMutation
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object StopPlayerMutation_ResponseAdapter {
  public object Data : Adapter<StopPlayerMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("stopPlayer")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        StopPlayerMutation.Data {
      var _stopPlayer: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _stopPlayer = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return StopPlayerMutation.Data(
        stopPlayer = _stopPlayer!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: StopPlayerMutation.Data,
    ): Unit {
      writer.name("stopPlayer")
      StringAdapter.toJson(writer, customScalarAdapters, value.stopPlayer)
    }
  }
}
