package com.justai.jaicf.activator.caila

import com.justai.jaicf.activator.caila.slotfilling.CailaSlotFillingSettings

data class CailaNLUSettings(
    val accessToken: String,
    val confidenceThreshold: Double = 0.2,
    val cailaSlotfillingSettings: CailaSlotFillingSettings = CailaSlotFillingSettings.DEFAULT,
    val cailaUrl: String = "$DEFAULT_CAILA_URL/api/caila/p"
)

internal const val DEFAULT_CAILA_URL = "https://app.jaicp.com/cailapub"