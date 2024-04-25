package io.github.lexadiky.openmind.library.navigation.desitnation

typealias AnyComposeScreenDestination = ComposeScreenDestination<Any, Any, Any>

interface ComposeScreenDestination<TArguments, TState, TAction> :
    ComposeDestination<TArguments, TState, TAction>