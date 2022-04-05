package com.zynksoftware.futureup.models

import com.squareup.moshi.Json

data class CryptoDescription(
    @Json(name = "description") val description: String? = null

)
