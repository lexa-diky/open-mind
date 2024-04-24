package io.github.lexadiky.openmind.library.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.github.lexadiky.openmind.library.arc.di.createViewModelSocket
import kotlin.reflect.KType
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.serializer

@Composable
fun NavigationHost(controller: NavHostController) {
    val destinations by rememberDestinationList()
    if (!destinations.isNullOrEmpty()) {
        NavHost(navController = controller, startDestination = Navigator.DEFAULT_ROUTE) {
            NavigatorComponentHolder.init(
                NavigatorComponent.from(controller)
            )

            destinations?.forEach { destination ->
                composable(
                    destination.route,
                    content = { backStackEntry ->
                        val arguments = rememberArguments(backStackEntry, destination)
                        val socket = destination.createViewModelSocket(arguments)
                        val state by socket.state.collectAsState()
                        destination.Content(state, socket::act)
                    }
                )
            }
        }
    }
}

private val navigationJson = Json { ignoreUnknownKeys = true }

@Composable
private fun rememberArguments(
    navBackStackEntry: NavBackStackEntry,
    destination: AnyComposeDestination,
): Any {
    return remember(navBackStackEntry, destination) {
        val argumentType = extractFactualArgumentType(destination)
        val serializer = navigationJson.serializersModule.serializer(argumentType)

        val arguments = navBackStackEntry.arguments ?: return@remember Unit
        val argMap = arguments.keySet().associateWith { key ->
            JsonPrimitive(arguments.get(key).toString())
        }
        val jsonObj = JsonObject(argMap)
        return@remember navigationJson.decodeFromJsonElement(serializer, jsonObj)!!
    }
}

fun extractFactualArgumentType(destination: AnyComposeDestination): KType {
    val parentClass = destination::class.supertypes.first()
    val superTypeTypeArgument = parentClass.arguments.first()
    return superTypeTypeArgument.type
        ?: error("parent class does not have type arguemnts")
}
