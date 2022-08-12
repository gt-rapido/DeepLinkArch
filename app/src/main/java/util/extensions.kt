package util

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController


fun NavGraph.setup(
    navController: NavController,
    startDestId: Int,
    startDestinationArgs: Bundle? = null
) {
    setStartDestination(startDestId)
    if (startDestinationArgs != null) {
        navController.setGraph(this, startDestinationArgs)
    } else {
        navController.graph = this
    }
}

fun FragmentActivity.getNavGraphWithController(
    @IdRes navHostFragmentId: Int,
    @NavigationRes navGraphId: Int
): NavGraphWithController {
    val navHost =
        supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
    val navController = navHost.findNavController()
    val navInflater = navController.navInflater
    val graph = navInflater.inflate(navGraphId)

    return NavGraphWithController(graph, navController)
}

data class NavGraphWithController(
    val graph: NavGraph,
    val controller: NavController
)
