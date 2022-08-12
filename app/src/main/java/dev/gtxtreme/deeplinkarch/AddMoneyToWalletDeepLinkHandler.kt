package dev.gtxtreme.deeplinkarch

import android.content.Context
import android.content.Intent
import android.util.Log

class AddMoneyToWalletDeepLinkHandler(private val activityIntentProvider: ActivityIntentProvider) :
    DeepLinkHandler {

    override fun launch(intent: Intent, context: Context) {
        val amount = intent.data?.getQueryParameter("amount")
        val taxAmount = intent.data?.getQueryParameter("taxAmount")
        val addMoneyToWalletIntent = activityIntentProvider.getAddMoneyToWalletIntent(
            context,
            AddMoneyToWalletArgs(amount = amount ?: "0", taxAmount = taxAmount ?: "0",  deepLinkUri = intent.data)
        )

        context.startActivity(addMoneyToWalletIntent)
    }

    override fun handles(intent: Intent): Boolean {
        Log.d(Companion.TAG, "Received ${intent.data}")
        val uri = intent.data
        val host = uri?.host?.lowercase()
        return host?.contains("add_money_to_wallet") ?: false
    }

    companion object {
        private const val TAG = "AddMoneyHandler"
    }
}