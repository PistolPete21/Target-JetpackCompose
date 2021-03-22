package com.target.targetcasestudy_kotlincompose.data

import android.util.JsonReader
import android.util.JsonToken
import com.target.targetcasestudy_kotlincompose.data.DataHelpers.Companion.getStringSafely
import com.target.targetcasestudy_kotlincompose.data.DataHelpers.Companion.parseJsonObjectArray

data class BaseResponse(
    var id:String = "",
    var data: List<DealItem> = listOf(),
    var type:String = ""
) {
    fun parseJson(jsonReader: JsonReader): BaseResponse {
        val response = BaseResponse()

        try {
            if (jsonReader.peek() != JsonToken.NULL) {
                jsonReader.beginObject()
                while (jsonReader.hasNext()) {
                    when (if (jsonReader.peek() != JsonToken.NULL) jsonReader.nextName() else "") {
                        "_id" -> response.id = getStringSafely(jsonReader)
                        "data" -> response.data = parseJsonObjectArray(DealItem(), jsonReader)
                        "type" -> response.type = getStringSafely(jsonReader)
                        else -> jsonReader.skipValue()
                    }
                }
                jsonReader.endObject()
            } else {
                jsonReader.skipValue()
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return response
    }
}