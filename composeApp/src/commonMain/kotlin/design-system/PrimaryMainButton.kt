package design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object PrimaryMainButtonConfig {
   enum class ImageAlignment {
       START, END
   }
}

@Composable
fun PrimaryMainButton(modifier: Modifier = Modifier,
                      text: String,
                      image: Painter? = null,
                      imageAlignment: PrimaryMainButtonConfig.ImageAlignment = PrimaryMainButtonConfig.ImageAlignment.START,
                      onClick: () -> Unit) {
    @Composable
    fun IconImage() {
        if(image != null) Image(image,
            modifier = Modifier.size(16.dp),
            contentDescription = "Some image")
    }

    @Composable
    fun ContentText() {
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

    Card(
        modifier = modifier
            .padding(16.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFF3797EF)
    ) {
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            when(imageAlignment) {
                PrimaryMainButtonConfig.ImageAlignment.START -> {
                    IconImage()
                    ContentText()
                }
                PrimaryMainButtonConfig.ImageAlignment.END -> {
                    ContentText()
                    IconImage()
                }
            }
        }
    }
}