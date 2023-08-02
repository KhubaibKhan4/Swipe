package com.codespacepro.swipjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codespacepro.swipjetpackcompose.ui.theme.SwipJetpackComposeTheme
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipJetpackComposeTheme {

                val archive = SwipeAction(
                    onSwipe = {
                        Log.d("Message", "Archive")
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.padding(16.dp),
                            painter = painterResource(id = R.drawable.ic_archive),
                            contentDescription = "Archive",
                            tint = Color.White
                        )
                    },
                    background = Color.Green
                )

                val email = SwipeAction(
                    onSwipe = {
                        Log.d("Message", "Email")
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.padding(16.dp),
                            painter = painterResource(id = R.drawable.ic_email),
                            contentDescription = "Email",
                            tint = Color.White
                        )
                    },
                    background = Color.Blue
                )
                val snooze = SwipeAction(
                    icon = { Text("Snooze") },
                    background = Color.Yellow,
                    isUndo = true,
                    onSwipe = {  },
                )

                SwipeableActionsBox(
                    startActions = listOf(snooze),
                    endActions = listOf(email),
                    swipeThreshold = 50.dp,
                ) {
                    Row(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(horizontal = 18.dp)
                            .padding(vertical = 8.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(size = 50.dp))
                                .background(MaterialTheme.colorScheme.primary)
                                .size(50.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(modifier = Modifier.weight(7f)) {
                            Text(
                                text = "Title",
                                style = TextStyle(
                                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(text = "Some Random Text")
                        }

                    }
                }


            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SwipJetpackComposeTheme {
        Greeting("Android")
    }
}