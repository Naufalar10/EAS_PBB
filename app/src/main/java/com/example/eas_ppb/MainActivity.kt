package com.example.eas_ppb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eas_ppb.ui.theme.EAS_PPBTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EAS_PPBTheme {
                EasApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun EasApp(modifier: Modifier = Modifier) {
    var shouldFirstPage by rememberSaveable { mutableStateOf(true) }
    var shouldLogIn by rememberSaveable { mutableStateOf(true) }
    var shouldHome by rememberSaveable { mutableStateOf(true) }
    var shouldreward by rememberSaveable {mutableStateOf(true) }
    var shouldbenefit by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldFirstPage) {
            FirstPage(onContinueClicked = { shouldFirstPage = false })
            LaunchedEffect(Unit) {
                delay(2000)
                shouldFirstPage = false
            }
        } else if (shouldLogIn) {
            SignUpScreen(onContinueClicked = { shouldLogIn = false })
        }
        else if (shouldHome){
            LoginScreen(onContinueClicked = { shouldHome = false })
        }
        else if (shouldreward) {
            RewardScreen(onContinueClicked = { shouldreward = false})
        }
        else {
            RewardBenefit(onContinueClicked = { shouldbenefit = false})
    }
    }

}

@Preview
@Composable
fun EasAppPreview() {
    EAS_PPBTheme {
        EasApp(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun FirstPage(onContinueClicked: () -> Unit,
                     modifier: Modifier = Modifier){
    Image(
        painter = painterResource(id = R.drawable.splash_screen),
        contentDescription = "login image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )


}

@Composable
fun SignUpScreen(onContinueClicked: () -> Unit,
                modifier: Modifier = Modifier) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var namaPengguna by remember {
        mutableStateOf("")
    }
    var mobileNumber by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }


    Image(
        painter = painterResource(id = R.drawable.splash_screen_1),
        contentDescription = "login image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Text("Create Account", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(90.dp))

        SelectionContainer(Modifier.width(275.dp)) {
            Text(text = "Full Name")
        }
        OutlinedTextField(value = namaPengguna, onValueChange = {namaPengguna = it}, placeholder = { Text(text = "user's name")})
        Spacer(modifier = Modifier.height(8.dp))

        SelectionContainer(Modifier.width(275.dp)) {
            Text(text = "Email")
        }
        OutlinedTextField(value = email, onValueChange = {email = it}, placeholder = { Text(text = "example@example.com")})
        Spacer(modifier = Modifier.height(8.dp))

        SelectionContainer(Modifier.width(275.dp)) {
            Text(text = "Mobile Number")
        }
        OutlinedTextField(value = mobileNumber, onValueChange = {mobileNumber = it}, placeholder = { Text(text = "+621234567890")})
        Spacer(modifier = Modifier.height(8.dp))

        SelectionContainer(Modifier.width(275.dp)) {
            Text(text = "Password")
        }
        OutlinedTextField(value = password, onValueChange = {password = it}, placeholder = { Text(text = "********")}, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(8.dp))

        SelectionContainer(Modifier.width(275.dp)) {
            Text(text = "Confirm Password")
        }
        OutlinedTextField(value = confirmPassword, onValueChange = {confirmPassword = it}, placeholder = { Text(text = "********")}, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onContinueClicked,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0,208,158))
        ) {
            Text("Sign Up", color = Color.Black)
        }
        Row {
            Text(text = "Already have an account?", fontSize = 12.sp, fontWeight = FontWeight.Normal)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Login", color = Color.Blue, fontSize = 12.sp, fontWeight = FontWeight.Normal, modifier = Modifier.clickable { onContinueClicked() })
        }

    }
}

@Composable
fun LoginScreen(onContinueClicked: () -> Unit,
                modifier: Modifier = Modifier) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }


    Image(
        painter = painterResource(id = R.drawable.splash_screen_2),
        contentDescription = "login image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Text("Starbucks", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(30.dp))

        Text("Welcome Back!", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(30.dp))

        Spacer(modifier = Modifier.height(60.dp))

        SelectionContainer(Modifier.width(275.dp)) {
            Text(text = "Email")
        }
        OutlinedTextField(value = email, onValueChange = {email = it}, placeholder = { Text(text = "example@example.com")})
        Spacer(modifier = Modifier.height(8.dp))

        Spacer(modifier = Modifier.height(30.dp))

        SelectionContainer(Modifier.width(275.dp)) {
            Text(text = "Password")
        }
        OutlinedTextField(value = password, onValueChange = {password = it}, placeholder = { Text(text = "********")}, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(8.dp))
        Spacer(modifier = Modifier.height(30.dp))

        Row {
            Text(text = "Forgot Your Password?", fontSize = 12.sp, fontWeight = FontWeight.Normal)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Login", color = Color.Blue, fontSize = 12.sp, fontWeight = FontWeight.Normal, modifier = Modifier.clickable { onContinueClicked() })
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = onContinueClicked,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0,208,158))
        ) {
            Text("Sign In", color = Color.Black)
        }

    }
}

@Composable
fun RewardScreen(onContinueClicked: () -> Unit,
                modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(id = R.drawable.splash_screen_3),
        contentDescription = "login image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Spacer(modifier = Modifier.height(60.dp))
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {

            Column(modifier = Modifier) {
                Spacer(modifier = Modifier.height(80.dp))
                Divider(
                    color = Color(196, 196, 196), thickness = 1.dp, modifier = Modifier
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        //horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Membership Status", fontSize = 20.sp, fontWeight = FontWeight.Normal)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Green Level", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color(16, 124, 65))
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "300 Stars to Gold Tier", fontSize = 20.sp, fontWeight = FontWeight.Normal)
                        Text(text = "Member Since 26 June 2024", fontSize = 20.sp, fontWeight = FontWeight.Normal)
                    }

                }
                Divider(
                    color = Color(196, 196, 196), thickness = 1.dp, modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp)
                )


            }
            Column(modifier = Modifier) {
                Row(
                    modifier = Modifier
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        //horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(text = "More about your reward benefits", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                    }
                    Button(
                        onClick = onContinueClicked,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text(">", fontSize = 20.sp,fontWeight = FontWeight.Bold, color = Color.Black)
                    }


                }
                Divider(
                    color = Color(196, 196, 196), thickness = 1.dp, modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp)
                )

            }
            Column(modifier = Modifier) {
                Row(
                    modifier = Modifier
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        //horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "Reward and Benefits",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )

                    }

                }
            }
        }
    }
}

@Composable
fun RewardBenefit(onContinueClicked: () -> Unit,
                 modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(id = R.drawable.splash_screen_4),
        contentDescription = "login image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {

            Column(modifier = Modifier) {
                //Spacer(modifier = Modifier.height(10.dp))
                //Divider(
                //    color = Color(196, 196, 196), thickness = 1.dp, modifier = Modifier
                    //.fillMaxWidth()
                //)
                Row(
                    modifier = Modifier
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        //horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Rewards Benefit",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Green Level",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(16, 124, 65)
                        )
                    }


                }
                Divider(
                    color = Color(196, 196, 196), thickness = 1.dp, modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp)
                )
            }
            Column(modifier = Modifier) {
                //Spacer(modifier = Modifier.height(10.dp))
                //Divider(
                //    color = Color(196, 196, 196), thickness = 1.dp, modifier = Modifier
                //.fillMaxWidth()
                //)
                Row(
                    modifier = Modifier
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        //horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Collect 1 star for every Rp6.000,- spent using your registered Starbucks Card balance as a means of payment",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Collect 1 star for every Rp12.000,- spent using any other means of payment linked to your Starbucks Reward account",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                        )

                        Divider(
                            color = Color(196, 196, 196), thickness = 1.dp, modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 15.dp)
                        )


                        Text(
                            text = "Rewards :",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "- 30 Stars = Free add-on(Espresso Shot/ Syrup / Sauce)",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "- 60 Stars = Free Tall Brewed Tea / Americano ",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "- 120 Stars = Free Any Food / Handcrafted Beverage (Tall Size) ",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                        )


                    }


                }
                Divider(
                    color = Color(196, 196, 196), thickness = 1.dp, modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                )
                Column(
                    modifier = Modifier.padding(10.dp),
                    //horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Terms & Conditions Appy.",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = " - Star & Rewards may appear up to 1 x 24 hours",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = " - Other T&C apply",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
        }
    }
}


