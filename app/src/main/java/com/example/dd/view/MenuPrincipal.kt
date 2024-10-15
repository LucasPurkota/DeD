package com.example.dd.view

import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dd.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun menuPrincipal(){
    var isCreatingCharacter by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.dog),
//            contentDescription = stringResource(id = R.string.dog_content_description),
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(200.dp)
//                .clip(CircleShape)
//        )
        Button(
            onClick = {
//                criarPersonagem()
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isCreatingCharacter
        ) {
//            if (isCreatingCharacter) {
//                CircularProgressIndicator()
//            } else {
//                Text("Criar Personagem")
//            }
        }

    }
}