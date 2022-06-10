package com.example.fcmnotification

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fcmnotification.ui.theme.Purple500
import com.google.firebase.messaging.FirebaseMessaging

@Composable
fun FirebaseScreen() {
    val context = LocalContext.current
    FirebaseMessaging.getInstance().token
        .addOnCompleteListener {
            if (!it.isSuccessful) {
                Log.d("@@@@@", "Token Failed")
                return@addOnCompleteListener
            }
            val token: String? = it.result
            Log.d("@@@@@", token, it.exception)
            Toast.makeText(context, token, Toast.LENGTH_SHORT).show()
        }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Compose FCM Notification",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple500)
                    .padding(15.dp)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_fcm),
                contentDescription = "Image",
                modifier = Modifier
                    .height(200.dp)
                    .padding(15.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
        }
    }
}