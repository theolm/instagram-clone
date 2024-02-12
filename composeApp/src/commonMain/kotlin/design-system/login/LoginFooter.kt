package `design-system`.login

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.theolm.instaclone.textColorBlack20A
import com.theolm.instaclone.textColorBlack40A

@Composable
fun LoginFooter() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(0.5.dp, color = textColorBlack20A, RectangleShape)
                .padding(30.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Instagram from Facebook", color = textColorBlack40A)
        }
    }
}