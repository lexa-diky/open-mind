package io.github.lexadiky.openmind.library.navigation.desitnation

typealias AnyComposeDialogDestination = ComposeDialogDestination<Any, Any, Any>

interface ComposeDialogDestination<TArguments, TState, TAction> :
    ComposeDestination<TArguments, TState, TAction>