package com.dscoding.hosteluniverse.core.presentation.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object CustomNavType {

    val PropertyUiType = object : NavType<PropertyUi>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): PropertyUi? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): PropertyUi {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: PropertyUi): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: PropertyUi) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }
}