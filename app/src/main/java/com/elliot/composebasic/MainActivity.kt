package com.elliot.composebasic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elliot.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("안드로이드.")
                }
            }
        }
    }
}

// 뷰
@Composable
fun Greeting(name: String) {
    //Scaffold 안에서 작업을 해줌
    Scaffold(
        //TopBar
        topBar ={
        TopAppBar(title = { Text("Elliot Android") },backgroundColor = Color(0xfff25287)) },
        //FloatingActionButton 위치 아래 끝으로
        floatingActionButtonPosition = FabPosition.End,
        //FloatingActionButton
        floatingActionButton = { FloatingActionButton(onClick = {}){
            Text("클릭")
        } },
    ) {
        //Text(text = "안녕하세요 $name!")
        MyComposaableView()
    }

}

@Composable
fun MyRowItem(){
    Log.d("TAG", "MyRowItem : ")
    // Like Horizontal LinearLayout
    Row(
        //Padding, Background
        Modifier
            //Row Padding
            .padding(10.dp)
            //Row 배경색
            .background(Color(0xffeaffd0))
            //가로 꽉 채우기
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        //TextView
        Text(text = "안녕하세요1",
            Modifier
                .padding(all = 10.dp)
                .background(Color.Yellow))
        //Space
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요2")
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요3")
    }
}

@Composable
fun MyComposaableView(){
    Log.d("TAG", "MyComposaableView : ")

    //Like Vertical LinearLayout
    Column(
        Modifier
            //Column 배경색
            .background(Color.Green)
            //세로 스크롤 가능하게 해주기
            .verticalScroll(rememberScrollState())
    ) {
        //아이템 0~31 만들어주기
        for ( i in 0..30){
            MyRowItem()
        }
    }

}

//미리보기
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicTheme {
        Greeting("Android")
    }
}