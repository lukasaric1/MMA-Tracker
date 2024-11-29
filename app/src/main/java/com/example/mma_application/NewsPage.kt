package com.example.mma_application


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NewsPage(modifier: Modifier = Modifier) {


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF170202)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "News Page",
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        CardRowsExample()
    }
}

@Composable
fun CardRowsExample() {
    //I use LazyColumn if I have more items for scrolling. Otherwise I would use Column if I had fixed number of rows.
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp), //Space between rows
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Dodajemo stavke unutar LazyColumn
        items(10) { index -> // Primer sa 10 redova
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                shape = RoundedCornerShape(1.dp), //Shadow effect
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp), // Padding inside card
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Card $index", color = Color.Black)
                }
            }
        }
    }
}

