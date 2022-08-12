package dev.gtxtreme.deeplinkarch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import util.getNavGraphWithController
import util.setup

class AddMoneyToWalletActivity: AppCompatActivity() {

    companion object {
        private const val TAG = "AddMoneyToWallet"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val receivedIntent = intent
        setContentView(R.layout.activity_add_money_to_wallet)
        val activityArgs = receivedIntent.extras?.getParcelable("ACTIVITY_ARGS") as AddMoneyToWalletArgs?
        setupNavController(receivedIntent)


//        val textView = findViewById<TextView>(R.id.mainTextView)
//        if (activityArgs != null) {
//            textView.text = "Received amount:${activityArgs.amount} taxAmount:${activityArgs.taxAmount}"
//        }else {
//            textView.text = "Fallback Values"
//        }



    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        findNavController(R.id.nav_host_fragment).handleDeepLink(intent)
    }

    private fun setupNavController(intent: Intent?) {
        val (graph, controller) = getNavGraphWithController(
            R.id.nav_host_fragment,
            R.navigation.wallet_nav
        )

        graph.setup(
            controller,
            R.id.blankFragment,
        )

        controller.handleDeepLink(intent)
    }
}