package components.buttons

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun TestButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick
    ) {
        Text("Test Button")
    }
}