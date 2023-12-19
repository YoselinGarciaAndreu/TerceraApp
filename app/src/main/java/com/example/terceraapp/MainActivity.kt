package com.example.terceraapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.terceraapp.ui.theme.TerceraAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerceraAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() { Column (modifier = Modifier
    .fillMaxSize()
    .padding(horizontal = 10.dp)
    .padding(vertical = 10.dp)) {

    var myState by remember { mutableStateOf(true) }
    val imagenes = listOf(
        R.drawable._703005144863,
        R.drawable._703005144888,
        R.drawable._703005144914,
        R.drawable._703005144937,
        R.drawable._703005144959,
        R.drawable._703005144981,
        R.drawable._703005144999,
        R.drawable._703005145018,
        R.drawable._703005697821
    )
    var idIMG by remember { mutableStateOf(0) }
    var estado by remember { mutableStateOf(true) }




    Row (modifier = Modifier
        .align(Alignment.CenterHorizontally),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Checkbox(
            checked = myState,
            onCheckedChange = { myState = it }

        )
        Text(
            text = "Checkbox 1",
            textAlign = TextAlign.Center,
        )
    }

    Row (modifier = Modifier
        .align(Alignment.CenterHorizontally)
    ) {
        if (myState){
        Text(
            text = "Aquí un párrafo largo (unas 3 líneas)\n que se muestre y oculte\n con el checkbox / switch",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.Red,
            modifier = Modifier
        )}else{
        }
    }
    MySpacerHeight(height = 15)

    Row (modifier = Modifier

        .align(Alignment.CenterHorizontally)
    ) {
        if (myState) {
            Text(
                text =
                "Checkbox activado",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Red,
                modifier = Modifier
            )
        }else{
            Text(
                text =
                "Checkbox desactivado",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Red,
                modifier = Modifier
            )

        }
    }



    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (bt1, bt2, img) = createRefs()


        Button(onClick = {
            idIMG = (idIMG - 1 + imagenes.size) % imagenes.size
        }, modifier = Modifier.constrainAs(bt1) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
        }) {
            Text("PREV")
        }



        Image(
             painter = painterResource(id = imagenes[idIMG]),
             contentDescription = null,
             modifier = Modifier
                 .size(220.dp)
                 .constrainAs(img) {
                 start.linkTo(bt1.end)
                 end.linkTo(bt2.start)
                 bottom.linkTo(parent.bottom)
          }
       )

        Button(onClick = {
            idIMG = (idIMG + 1) % imagenes.size
        }, modifier = Modifier.constrainAs(bt2) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }) {
            Text("NEXT")
        }
    }
}
}



@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("Filled")
    }
}

@Composable
fun MySpacerHeight(height:Int) {
    Spacer(modifier = Modifier.height(height.dp))
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TerceraAppTheme {
        Greeting()
    }
}


@Composable
fun nose() {
    Row(
        modifier = Modifier
            //.align(Alignment.CenterHorizontally)
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text("PREV")
        }

        //Carousel()

//        Image(
//          painter = painterResource(id = imagenes[idIMG]),
//            contentDescription = null,
//            modifier = estado.constrainAs(imageMap) {
//                start.linkTo(anteriorButton.end)
//                end.linkTo(postButton.start)
//                bottom.linkTo(parent.bottom)
//            }
//        )

        Button(onClick = { /*TODO*/ }) {
            Text("NEXT")
        }
    }
}