package com.example.tomasardiles
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomasardiles.ui.theme.TomasardilesTheme
import com.example.tomasardiles.MyMessages as MyMessages

private val messages: List<MyMessage> = listOf(
    MyMessage("hello-1","world , 1 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                                  "tempor incididunt ut labore et dolore magna aliqua. Ultricies mi eget mauris"),
    MyMessage("hello-2","world , 2 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                                  "tempor incididunt ut labore et dolore magna aliqua. Ultricies mi eget mauris"),
    MyMessage("hello-3","world , 3 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                                  "tempor incididunt ut labore et dolore magna aliqua. Ultricies mi eget mauris"),
    MyMessage("hello-4","world , 4 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                                  "tempor incididunt ut labore et dolore magna aliqua. Ultricies mi eget mauris"),
    MyMessage("hello-5","world , 5 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                                  "tempor incididunt ut labore et dolore magna aliqua. Ultricies mi eget mauris"),
    MyMessage("hello-6","world , 6 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                                  "tempor incididunt ut labore et dolore magna aliqua. Ultricies mi eget mauris"),
    MyMessage("hello-7","world , 7 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                                  "tempor incididunt ut labore et dolore magna aliqua. Ultricies mi eget mauris"),
    MyMessage("hello-8","world , 8 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                                  "tempor incididunt ut labore et dolore magna aliqua. Ultricies mi eget mauris"),
    MyMessage("hello-9","world , 9 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                                  "tempor incididunt ut labore et dolore magna aliqua. Ultricies mi eget mauris"),
    MyMessage("hello-10","world , 10 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                                   "tempor incididunt ut labore et dolore magna aliqua. Ultricies mi eget mauris"))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TomasardilesTheme(darkTheme = true) {
                Column() {
                    MyMessages(messages)
                }
            }
        }
    }
}
data class MyMessage(val title:String,val body:String)
@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn {
        items (messages) { message ->
            MyCompnent(message) }
    }
}
@Composable
fun MyImageView(){
    Image (
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription ="test image",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primaryVariant)
            .size(64.dp)
    )
}
@Composable
fun MyCompnent(message: MyMessage){
    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(23.dp)
        .fillMaxWidth()
        )
    {
        MyImageView()
        MyTexts(message)
    }
}
@Composable
fun MyTexts(message: MyMessage){
    Column(modifier = Modifier.padding(start = 5.dp)) {
        MyText(
            message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(9.dp))
        MyText(
            message.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2
        )
    }
}
@Composable
fun MyText(text: String, color: Color, style: TextStyle){
    Text(text,color = color,style = style)
}
@Preview(showSystemUi = true)
@Composable
fun PreviewComposable(){
    TomasardilesTheme(darkTheme = true) {
        Column() {
            MyMessages(messages)
        }
    }
}
