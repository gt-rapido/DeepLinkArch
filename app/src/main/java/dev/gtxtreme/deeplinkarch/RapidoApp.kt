package dev.gtxtreme.deeplinkarch

import android.app.Application
import org.koin.core.context.startKoin

class RapidoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(activityIntentProviderModule, deepLinkModule)
        }
    }

}