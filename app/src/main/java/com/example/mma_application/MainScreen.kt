package com.example.mma_application

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val navItemList = listOf(
        BottomNavItems("EVENTS", R.drawable.event,0),
        BottomNavItems("RESULTS", R.drawable.result,0),
        BottomNavItems("NEWS", R.drawable.news,5),
        BottomNavItems("FIGHTERS", R.drawable.mma_fighters,0),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar (modifier = Modifier.height(110.dp),
                containerColor = colorResource(id = R.color.bottom_nav_bar_color)) {

                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected =  selectedIndex == index ,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            BadgedBox(badge = {
                                if(navItem.badgeCount>0)
                                    Badge(){
                                        Text(text = navItem.badgeCount.toString())
                                    }
                            }) {
                                Icon(
                                    painter = painterResource(id = navItem.icon),
                                    contentDescription = "Icon",
                                    tint = androidx.compose.ui.graphics.Color.White
                                )
                            }

                        },
                        label = {
                            Text (
                                text = navItem.label,
                                color = androidx.compose.ui.graphics.Color.White)
                        },
                        colors = NavigationBarItemDefaults.colors(

                            indicatorColor = colorResource(id = R.color.black) // Ovo menja boju indikatora iza ikone
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex)
    }
}



@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex : Int) {
    when(selectedIndex){
        0-> EventsPage()
        1-> ResultsPage()
        2-> NewsPage()
        3-> FightersPage()
    }
}


