package design

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object ProfileIconConfig {
    enum class Context(
        val shouldHighlight: Boolean,
        val usernameShouldBeBold: Boolean
    ) {
        PreLogin(
            shouldHighlight = false,
            usernameShouldBeBold = true
        ),
        Stories(
            shouldHighlight = true,
            usernameShouldBeBold = false
        );

        fun shouldHighlight(): Boolean {
            return when (this) {
                PreLogin -> false
                Stories -> true
            }
        }

        fun usernameShouldBeBold(): Boolean {
            return when (this) {
                PreLogin -> true
                Stories -> false
            }
        }
    }

    data class Input(val image: Painter, val username: String)
}

@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier,
    input: ProfileIconConfig.Input,
    context: ProfileIconConfig.Context
) {
    val gradientColors = listOf(Color(0xFFE57373), Color(0xFFEF5350), Color(0xFFF44336))
    val gradient = Brush.linearGradient(
        colors = gradientColors,
        start = Offset(0f, 0f),
        end = Offset(100f, 100f)
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .border(
                    BorderStroke(if (context.shouldHighlight()) 2.dp else 0.dp, gradient),
                    shape = CircleShape
                ),
            painter = input.image,
            contentDescription = null,
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            text = input.username,
            fontWeight =
            if (context.usernameShouldBeBold()) FontWeight.Bold else FontWeight.Normal,
            fontSize = 12.sp
        )
    }
}