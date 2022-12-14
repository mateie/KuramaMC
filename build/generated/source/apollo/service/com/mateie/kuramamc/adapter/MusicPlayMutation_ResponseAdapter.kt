//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.6.1'.
//
package com.mateie.kuramamc.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.mateie.kuramamc.MusicPlayMutation
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object MusicPlayMutation_ResponseAdapter {
  public object Data : Adapter<MusicPlayMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("music")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        MusicPlayMutation.Data {
      var _music: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _music = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return MusicPlayMutation.Data(
        music = _music!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: MusicPlayMutation.Data,
    ): Unit {
      writer.name("music")
      StringAdapter.toJson(writer, customScalarAdapters, value.music)
    }
  }
}
