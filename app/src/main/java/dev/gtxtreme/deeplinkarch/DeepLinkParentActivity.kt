package dev.gtxtreme.deeplinkarch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import org.koin.android.ext.android.getKoin

class DeepLinkParentActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val deepLinkIntent = intent
        val deepLinkHandlers: List<DeepLinkHandler> = getKoin().getAll()

        deepLinkHandlers.find { it.handles(deepLinkIntent) }
            ?.launch(context = this, intent = deepLinkIntent)
    }
}