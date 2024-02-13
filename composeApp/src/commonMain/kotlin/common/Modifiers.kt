package common

import androidx.compose.ui.Modifier

fun Modifier.conditional(
    condition: Boolean,
     ifModifier: Modifier): Modifier {
    return if (condition) ifModifier else Modifier
}

fun Modifier.conditionalWithElse(
    condition: Boolean,
    ifModifier: Modifier,
    elseModifier: Modifier): Modifier {
    return if (condition) ifModifier else elseModifier
}