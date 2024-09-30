package id.piusanggoro.belajarlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
//import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Favorite
//import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.piusanggoro.belajarlayout.ui.theme.BelajarLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarLayoutTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF073042)) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = null,
            Modifier.fillMaxWidth(0.3f)
        )
        Text(text = stringResource(R.string.my_name), fontSize = 50.sp, color = Color.White)
        Text(text = stringResource(R.string.my_title), fontSize = 11.sp, color = Color.Green)
        //Spacer(modifier = Modifier.padding(bottom = 250.dp))
        ContactRow(
            icon = Icons.Rounded.Favorite,
            text = stringResource(R.string.my_phone_number)
        )
        ContactRow(
            icon = Icons.Rounded.Share,
            text = stringResource(R.string.twitter_handle)
        )
        ContactRow(
            icon = Icons.Rounded.Email,
            text = stringResource(R.string.my_email)
        )
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    //ini adalah penggunaan layout kolom
    // digunakan untuk me-layout teks dan ikon dalam satu baris
    Row(
        horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.weight(4f)
        )
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier.weight(1f)
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = Color(0xFF073042)
    ) {
        BelajarLayoutTheme {
            BusinessCard()
        }
    }
}
