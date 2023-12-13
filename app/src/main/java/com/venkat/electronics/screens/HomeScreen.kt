package com.venkat.electronics.screens

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.venkat.electronics.ElectronicsDetailsActivity
import com.venkat.electronics.FourActivity
import com.venkat.electronics.FourthActivity

import com.venkat.electronics.R
import com.venkat.electronics.Screen_One_Activity
import com.venkat.electronics.ThreeActivity
import com.venkat.electronics.TwoActivity
import com.venkat.electronics.UserProfileActivity
import com.venkat.electronics.components.AppToolbar
import com.venkat.electronics.components.NavigationDrawerBody
import com.venkat.electronics.components.NavigationDrawerHeader

import com.venkat.electronics.data.home.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)
            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere","inside_NavigationItemClicked")
                    Log.d("ComingHere","${it.itemId} ${it.title}")
                })
        }

    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                Box(
                    modifier = Modifier
                        .requiredWidth(width = 360.dp)
                        .requiredHeight(height = 640.dp)
                        .background(color = Color.White)
                ) {
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 45.dp,
                                y = 18.dp)
                            .requiredWidth(width = 270.dp)
                            .requiredHeight(height = 44.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 270.dp)
                                .requiredHeight(height = 44.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = Color(0xfff4f4f4)))
                        Image(
                            painter = painterResource(id = R.drawable.group1),
                            contentDescription = "Group 1",
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 242.368408203125.dp,
                                    y = 12.571441650390625.dp)
                                .requiredWidth(width = 12.dp)
                                .requiredHeight(height = 19.dp))
                        Divider(
                            color = Color(0xfffbf1f1),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 225.dp,
                                    y = 7.071441650390625.dp)
                                .requiredWidth(width = 28.dp)
                                .rotate(degrees = -90f))

                        val context = LocalContext.current
                        Box(
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 15.78948974609375.dp, y = 12.571441650390625.dp)
                                .requiredWidth(width = 122.dp)
                                .clickable {
                                    context.startActivity(Intent(context,UserProfileActivity::class.java))
                                }
                                .requiredHeight(height = 19.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.profile),
                                contentDescription = "search",
                                modifier = Modifier
                                    .align(alignment = Alignment.TopStart)
                                    .offset(x = 0.dp, y = 1.5714111328125.dp)
                                    .requiredWidth(width = 16.dp)
                                    .requiredHeight(height = 16.dp))
                            Text(
                                text = "My Profile",
                                color = Color(0xFF1D1617),
                                style = TextStyle(
                                    fontSize = 16.sp),
                                modifier = Modifier
                                    .align(alignment = Alignment.TopStart)
                                    .offset(x = 31.578857421875.dp, y = 0.dp)
                                    .requiredWidth(width = 90.dp)
                                    .requiredHeight(height = 19.dp))
                        }
                    }
//                    Image(
//                        painter = painterResource(id = R.drawable.button),
//                        contentDescription = "Button",
//                        modifier = Modifier
//                            .align(alignment = Alignment.TopStart)
//                            .offset(x = 9.dp,
//                                y = 29.dp)
//                            .requiredWidth(width = 342.dp)
//                            .requiredHeight(height = 18.dp))
                    Image(
                        painter = painterResource(id = R.drawable.rectangle23),
                        contentDescription = "Rectangle 23",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 6.dp,
                                y = 663.dp)
                            .requiredWidth(width = 95.dp)
                            .requiredHeight(height = 108.dp)
                            .clip(shape = RoundedCornerShape(10.dp)))
                    Image(
                        painter = painterResource(id = R.drawable.rectangle24),
                        contentDescription = "Rectangle 24",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 131.dp,
                                y = 663.dp)
                            .requiredWidth(width = 97.dp)
                            .requiredHeight(height = 108.dp)
                            .clip(shape = RoundedCornerShape(10.dp)))
                    Image(
                        painter = painterResource(id = R.drawable.rectangle25),
                        contentDescription = "Rectangle 25",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 249.dp,
                                y = 663.dp)
                            .requiredWidth(width = 98.dp)
                            .requiredHeight(height = 108.dp)
                            .clip(shape = RoundedCornerShape(10.dp)))
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 249.dp,
                                y = 748.dp)
                            .requiredWidth(width = 98.dp)
                            .requiredHeight(height = 23.dp)
                            .clip(shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                            .background(color = Color.White))
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 131.dp,
                                y = 748.dp)
                            .requiredWidth(width = 97.dp)
                            .requiredHeight(height = 23.dp)
                            .clip(shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                            .background(color = Color.White))
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 6.dp,
                                y = 748.dp)
                            .requiredWidth(width = 95.dp)
                            .requiredHeight(height = 23.dp)
                            .clip(shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                            .background(color = Color.White))
                    val localContext = LocalContext.current
                    Image(
                        painter = painterResource(id = R.drawable.group),
                        contentDescription = "Group 9",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 269.dp,
                                y = 761.dp)
                            .requiredWidth(width = 26.dp)
                            .requiredHeight(height = 5.dp))
                    Image(
                        painter = painterResource(id = R.drawable.group),
                        contentDescription = "Group 10",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 141.dp,
                                y = 761.dp)
                            .requiredWidth(width = 26.dp)
                            .requiredHeight(height = 5.dp))
                    Image(
                        painter = painterResource(id = R.drawable.group),
                        contentDescription = "Group 11",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 16.dp,
                                y = 761.dp)
                            .requiredWidth(width = 26.dp)
                            .requiredHeight(height = 5.dp))
                    Text(
                        text = "Lonsdale Food Hub",
                        color = Color(0xff121212),
                        style = TextStyle(
                            fontSize = 7.sp,
                            shadow = Shadow(color = Color.Black.copy(alpha = 0.10000000149011612f),
                                offset = Offset(0f, 1f), blurRadius = 200f)
                        ),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 269.dp,
                                y = 752.dp)
                            .requiredWidth(width = 67.dp)
                            .requiredHeight(height = 7.dp))
                    Text(
                        text = "Lonsdale Food Hub",
                        color = Color(0xff121212),
                        style = TextStyle(
                            fontSize = 7.sp,
                            shadow = Shadow(color = Color.Black.copy(alpha = 0.10000000149011612f),
                                offset = Offset(0f, 1f), blurRadius = 200f)
                        ),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 141.dp,
                                y = 752.dp)
                            .requiredWidth(width = 67.dp)
                            .requiredHeight(height = 7.dp))
                    Text(
                        text = "Lonsdale Food Hub",
                        color = Color(0xff121212),
                        style = TextStyle(
                            fontSize = 7.sp,
                            shadow = Shadow(color = Color.Black.copy(alpha = 0.10000000149011612f),
                                offset = Offset(0f, 1f), blurRadius = 200f)),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 16.dp,
                                y = 752.dp)
                            .requiredWidth(width = 67.dp)
                            .requiredHeight(height = 7.dp))
                    Text(
                        text = "Top Brands",
                        color = Color.Black,
//                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 11.dp,
                                y = 81.dp))
                    Text(
                        text = "Trending This Week",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 20.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 6.dp,
                                y = 337.dp))
                    Text(
                        text = "XPS Laptops",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 18.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 19.dp,
                                y = 267.dp))
                    Text(
                        text = "Apple Iphone 15",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 18.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 204.dp,
                                y = 267.dp))
                    Text(
                        text = "Suzy Queue 4455 Landing Lange, APT 4 Louisville, Kentucky",
                        color = Color(0xff04cb9e),
                        style = TextStyle(
                            fontSize = 12.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 19.dp,
                                y = 119.dp)
                            .requiredWidth(width = 223.dp)
                            .requiredHeight(height = 28.dp))
                    Image(
                        painter = painterResource(id = R.drawable.electronic21),
                        contentDescription = "electronic2 1",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 14.dp,
                                y = 156.dp)
                            .requiredWidth(width = 168.dp)
                            .requiredHeight(height = 102.dp)
                            .clip(shape = RoundedCornerShape(30.dp))
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, FourthActivity::class.java))
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.rectangle46),
                        contentDescription = "Rectangle 46",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 19.dp,
                                y = 372.dp)
                            .requiredWidth(width = 144.dp)
                            .requiredHeight(height = 83.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, FourActivity::class.java))
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.group),
                        contentDescription = "Group 6",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 30.dp,
                                y = 478.dp)
                            .requiredWidth(width = 55.dp)
                            .requiredHeight(height = 14.dp))
                    Image(
                        painter = painterResource(id = R.drawable.group),
                        contentDescription = "Group 12",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 203.dp,
                                y = 478.dp)
                            .requiredWidth(width = 55.dp)
                            .requiredHeight(height = 14.dp))
                    Image(
                        painter = painterResource(id = R.drawable.group),
                        contentDescription = "Group 13",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 24.dp,
                                y = 616.dp)
                            .requiredWidth(width = 55.dp)
                            .requiredHeight(height = 14.dp))
                    Image(
                        painter = painterResource(id = R.drawable.group),
                        contentDescription = "Group 14",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 198.dp,
                                y = 619.dp)
                            .requiredWidth(width = 55.dp)
                            .requiredHeight(height = 14.dp))
                    Text(
                        text = "Dell  India",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Light),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 21.dp,
                                y = 289.dp)
                            .requiredWidth(width = 78.dp)
                            .requiredHeight(height = 16.dp))
                    Text(
                        text = "South California",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Light),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 215.dp,
                                y = 294.dp)
                            .requiredWidth(width = 145.dp)
                            .requiredHeight(height = 16.dp))
                    Text(
                        text = "AirPods",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 15.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 30.dp,
                                y = 455.dp)
                            .requiredWidth(width = 73.dp)
                            .requiredHeight(height = 16.dp))
                    Text(
                        text = "LED  TV",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 15.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 200.dp,
                                y = 599.dp)
                            .requiredWidth(width = 73.dp)
                            .requiredHeight(height = 16.dp))
                    Text(
                        text = "Electronic Watch",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 15.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 17.dp,
                                y = 597.dp)
                            .requiredWidth(width = 126.dp)
                            .requiredHeight(height = 22.dp))
                    Text(
                        text = "Speakers",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 15.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 204.dp,
                                y = 460.dp)
                            .requiredWidth(width = 73.dp)
                            .requiredHeight(height = 16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.electronic31),
                        contentDescription = "electronic3 1",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 190.dp,
                                y = 156.dp)
                            .requiredWidth(width = 170.dp)
                            .requiredHeight(height = 100.dp)
                            .clip(shape = RoundedCornerShape(30.dp))
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, ElectronicsDetailsActivity::class.java))
                            })
                    Image(
                        painter = painterResource(id = R.drawable.electronic41),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 190.dp,
                                y = 372.dp)
                            .requiredWidth(width = 136.dp)
                            .requiredHeight(height = 83.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, Screen_One_Activity::class.java))
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.electronic51),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 22.dp,
                                y = 501.dp)
                            .requiredWidth(width = 99.dp)
                            .requiredHeight(height = 96.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, TwoActivity::class.java))
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.tv11),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 180.dp,
                                y = 499.dp)
                            .requiredWidth(width = 142.dp)
                            .requiredHeight(height = 98.dp)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, ThreeActivity::class.java))
                            }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}