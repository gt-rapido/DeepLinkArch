package dev.gtxtreme.deeplinkarch

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddMoneyToWalletArgs(val amount: String, val taxAmount: String, val deepLinkUri: Uri? = null): Parcelable