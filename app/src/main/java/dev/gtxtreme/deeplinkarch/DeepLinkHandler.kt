package dev.gtxtreme.deeplinkarch

import android.content.Context
import android.content.Intent

interface DeepLinkHandler {


    /**
     * @param intent Intent This is the intent received via the Android System
     * @param context Context This is the context needed to launch a new activity
     * This will contain the logic, for launching a new activity based on the intent received
     */
    fun launch(intent: Intent, context: Context)

    /**
     * @param intent Intent
     * @return true if this deeplink handler can handle the intent, false o.w.
     * This function describes if the implementation is capable of handling a specific deep link
     */
    fun handles(intent: Intent): Boolean
}