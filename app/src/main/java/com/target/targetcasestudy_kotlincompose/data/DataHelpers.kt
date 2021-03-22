package com.target.targetcasestudy_kotlincompose.data

import android.util.JsonReader
import android.util.JsonToken
import com.target.targetcasestudy_kotlincompose.deals.detail.DealsDetailViewModel
import com.target.targetcasestudy_kotlincompose.deals.list.DealsListViewModel
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


abstract class DataHelpers {
    companion object {
        fun getStringSafely(jsonReader: JsonReader): String =
            when (jsonReader.peek()) {
                JsonToken.NULL -> {
                    jsonReader.nextNull()
                    ""
                }
                else -> jsonReader.nextString()
            }

        fun getIntSafely(jsonReader: JsonReader): Int =
            when (jsonReader.peek()) {
            JsonToken.NULL -> {
                jsonReader.nextNull()
                0
            }
            else -> jsonReader.nextInt()
        }

        @Throws(IOException::class)
        fun parseJsonObjectArray(
            objectClass: DealItem,
            jsonReader: JsonReader
        ): List<DealItem> {
            val list = ArrayList<DealItem>()

            if (jsonReader.peek() != JsonToken.NULL) {
                jsonReader.beginArray()
                if (jsonReader.peek() != JsonToken.NULL) {
                    while (jsonReader.hasNext()) {
                        try {
                            list.add(objectClass.getObject(jsonReader))
                        } catch (ex: Exception) {
                            ex.printStackTrace()
                        }

                    }
                }
                jsonReader.endArray()
            } else {
                jsonReader.nextNull()
            }

            return list
        }
    }
}
