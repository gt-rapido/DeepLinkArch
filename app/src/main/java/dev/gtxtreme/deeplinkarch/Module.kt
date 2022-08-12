package dev.gtxtreme.deeplinkarch

import org.koin.dsl.module

val activityIntentProviderModule = module {
    single<ActivityIntentProvider> {
        ActivityIntentProviderImpl()
    }
}

val deepLinkModule = module {
    factory<DeepLinkHandler> { AddMoneyToWalletDeepLinkHandler(get()) }
    //any number of implementations
}

