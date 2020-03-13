package com.justai.jaicf.channel.jaicp.dto

import com.justai.jaicf.api.BotRequest
import com.justai.jaicf.api.BotRequestType
import kotlinx.serialization.json.content

abstract class JaicpNativeBotRequest(
    val jaicp: JaicpBotRequest
): BotRequest {
    override val type: BotRequestType = jaicp.type
    override val clientId: String = jaicp.clientId
    override val input: String = jaicp.input
}

data class TelephonyBotRequest(
    private val request: JaicpBotRequest
) : JaicpNativeBotRequest(request) {
    val caller: String? = request.rawRequest["caller"]?.content
    val trunk: String? = request.rawRequest["extension"]?.content
}

data class ChatWidgetBotRequest(
    private val request: JaicpBotRequest
) : JaicpNativeBotRequest(request)

data class ChatApiBotRequest(
    val request: JaicpBotRequest
) : JaicpNativeBotRequest(request)

val BotRequest.telephony
    get() = this as? TelephonyBotRequest

val BotRequest.chatapi
    get() = this as? ChatApiBotRequest

val BotRequest.chatwidget
    get() = this as? ChatWidgetBotRequest