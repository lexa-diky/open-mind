package io.github.lexadiky.openmind.library.arc.di

interface ComponentHolder<TComponent: Component> {

    fun get(): TComponent

    interface Factory<T> {

        fun create(argument: T): Component
    }
}

abstract class StaticComponentHolder<C: Component> : ComponentHolder<C> {
    private var component: C? = null

    fun init(component: C) {
        this.component = component
    }

    override fun get(): C {
        return component ?: error("static component not set")
    }
}