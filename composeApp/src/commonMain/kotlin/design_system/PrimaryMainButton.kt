package design_system

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object PrimaryMainButtonConfig {
    enum class ImageAlignment {
        START, END
    }
}

@Composable
private fun IconImage(image: Painter?) {
    if (image != null) Image(
        image,
        modifier = Modifier.size(16.dp),
        contentDescription = null
    )
}

@Composable
private fun ContentText(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Transparent),
        color = Color.White,
        textAlign = TextAlign.Center,
        fontSize = 18.sp
    )
}

@Composable
fun PrimaryMainButton(
    modifier: Modifier = Modifier,
    text: String,
    image: Painter? = null,
    imageAlignment: PrimaryMainButtonConfig.ImageAlignment = PrimaryMainButtonConfig.ImageAlignment.START,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .padding(16.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFF3797EF)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (imageAlignment) {
                PrimaryMainButtonConfig.ImageAlignment.START -> {
                    IconImage(image = image)
                    ContentText(text = text)
                }

                PrimaryMainButtonConfig.ImageAlignment.END -> {
                    ContentText(text = text)
                    IconImage(image = image)
                }
            }
        }
    }
}