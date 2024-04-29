package io.github.lexadiky.openmind.feature.me

import io.github.lexadiky.openmind.library.arc.Reducer
import io.github.lexadiky.openmind.library.arc.ignore

class MeScreenState(

)

sealed interface MeScreenAction {

}

sealed interface MeScreenCommand {

}

class MeScreenReducer : Reducer<MeScreenState, MeScreenAction, MeScreenCommand> {

    override fun reduce(state: MeScreenState, action: MeScreenAction): Reducer.Result<MeScreenState, MeScreenCommand> {
        return ignore()
    }
}
