package com.target.targetcasestudy_kotlincompose.data

import android.util.JsonReader
import android.util.JsonToken
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DealItem(
    var id: String = "",
    var aisle: String = "",
    var description: String = "",
    var guid: String = "",
    var image: String = "",
    var index: Int = 0,
    var price: String = "",
    var salePrice: String = "",
    var title: String = ""
) : Serializable {
    fun getObject(jsonReader: JsonReader): DealItem {
        val deal = DealItem()
        if (jsonReader.peek() != JsonToken.NULL) {
            jsonReader.beginObject()
            while (jsonReader.hasNext()) {
                when (if (jsonReader.peek() != JsonToken.NULL) jsonReader.nextName() else "") {
                    "_id" -> deal.id = DataHelpers.getStringSafely(jsonReader)
                    "aisle" -> deal.aisle = DataHelpers.getStringSafely(jsonReader)
                    "description" -> deal.description = DataHelpers.getStringSafely(jsonReader)
                    "guid" -> deal.guid = DataHelpers.getStringSafely(jsonReader)
                    "image" -> deal.image = DataHelpers.getStringSafely(jsonReader)
                    "index" -> deal.index = DataHelpers.getIntSafely(jsonReader)
                    "price" -> deal.price = DataHelpers.getStringSafely(jsonReader)
                    "salePrice" -> deal.salePrice = DataHelpers.getStringSafely(jsonReader)
                    "title" -> deal.title = DataHelpers.getStringSafely(jsonReader)
                }
            }
            jsonReader.endObject()
        } else {
            jsonReader.nextNull()
        }
        return deal
    }
}