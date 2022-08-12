package dev.gtxtreme.deeplinkarch

import android.content.Context
import android.content.Intent

interface ActivityIntentProvider {

    fun getAddMoneyToWalletIntent(context: Context, addMoneyToWalletArgs: AddMoneyToWalletArgs) : Intent
}


class ActivityIntentProviderImpl: ActivityIntentProvider {

    override fun getAddMoneyToWalletIntent(
        context: Context,
        addMoneyToWalletArgs: AddMoneyToWalletArgs
    ): Intent {
        return Intent(context, AddMoneyToWalletActivity::class.java).apply {
            data = addMoneyToWalletArgs.deepLinkUri
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            putExtra("ACTIVITY_ARGS", addMoneyToWalletArgs)
        }
    }

}