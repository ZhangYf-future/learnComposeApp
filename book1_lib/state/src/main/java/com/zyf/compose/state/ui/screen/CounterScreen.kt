package com.zyf.compose.state.ui.screen

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.DisposableEffectResult
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.SaverScope
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import com.zyf.book1.mywidget_lib.CenterRow
import com.zyf.book1.mywidget_lib.HeightSpacer
import com.zyf.book1.mywidget_lib.ScreenScaffold
import com.zyf.book1.mywidget_lib.WidthSpacer
import com.zyf.book1.utils.DispatchBackWidget
import com.zyf.compose.state.R
import com.zyf.compose.state.bean.UserBean
import kotlinx.coroutines.flow.asStateFlow


val userSaver = object : Saver<UserBean, Bundle> {
    override fun restore(value: Bundle): UserBean = UserBean(
        value.getString("userName") ?: "",
        value.getInt("age") ?: 0
    )

    override fun SaverScope.save(value: UserBean): Bundle? = bundleOf(
        "userName" to value.userName,
        "age" to value.age
    )
}

val userMapSaver = mapSaver<UserBean>(save = {
    mapOf(
        "userName" to it.userName,
        "age" to it.age
    )
}, restore = {
    UserBean(it["userName"] as? String ?: "", it["age"] as? Int ?: 0)
})

val userListSaver = listSaver<UserBean, Any>(save = {
    listOf(it.userName,it.age)
}, restore = {
    UserBean(it[0] as? String ?: "", it[1] as? Int ?: 0)
})


@Composable
fun CounterScreen(mViewModel: CountScreenViewModel, backPressed: () -> Unit) {

//    val result = object : DisposableEffectResult {
//        override fun dispose() {
//            Log.i("CounterScreen", "dispose...")
//        }
//    }
//
//    DisposableEffect(key1 = "") {
//        result
//    }

//    val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
//    val backCallback = remember {
//        object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                //backDispatcher?.onBackPressed()
//                Log.i("CounterScreen", "handleOnBackPressed ... ")
//                if(mViewModel.countState.value > 0){
//                    mViewModel.decrement()
//                }else{
//                    this.remove()
//                    backDispatcher?.onBackPressed()
//                }
//            }
//        }
//    }
//
//    DisposableEffect(key1 = backDispatcher) {
//        backDispatcher?.addCallback(backCallback)
//        onDispose {
//            backCallback.remove()
//        }
//    }
    DispatchBackWidget(enable = true) {
        if(mViewModel.countState.value > 0){
            mViewModel.decrement()
            true
        }else{
            false
        }
    }

    ScreenScaffold(title = stringResource(id = R.string.counter_screen_title)) {
        var count by rememberSaveable {
            mutableIntStateOf(0)
        }

        var userInfo by rememberSaveable(stateSaver = userListSaver) {
            mutableStateOf(UserBean("",0))
        }

        val countNum by mViewModel.countState.collectAsState()

        CountWidget(count = countNum,
            onIncrement = {
                Log.i("CounterScreen", "click increment")
                mViewModel.increment()
            },
            onDecrement = mViewModel::decrement
        )

        EditUserNameWidget(modifier = Modifier.fillMaxWidth(fraction = 0.9f), userName = userInfo.userName) {
            userInfo = UserBean(
                it,
                userInfo.age
            )
        }

        EditUserAgeWidget(modifier = Modifier.fillMaxWidth(), userAge = userInfo.age) {
            userInfo = UserBean(
                userInfo.userName,
                it.toInt()
            )
        }
        
        ShowUserInfo(userInfo = userInfo, modifier = Modifier.fillMaxWidth())

    }
}

@Composable
fun CountWidget(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Counter Text")
        HeightSpacer(height = 10.dp)
        Text(text = count.toString())
        HeightSpacer(height = 10.dp)
        CenterRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Button(onClick = onDecrement) {
                Text(text = "-")
            }

            WidthSpacer(width = 20.dp, height = 1.dp)
            Button(onClick = onIncrement) {
                Text(text = "+")
            }
        }
    }
}

@Composable
fun EditUserNameWidget(
    modifier: Modifier = Modifier,
    userName: String? = null,
    onValueChanged: (String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(modifier = Modifier.fillMaxWidth(),text = stringResource(id = R.string.please_input_user_name))
        TextField(modifier = Modifier.fillMaxWidth(), value = userName ?: "", onValueChange = onValueChanged)
    }
}


@Composable
fun EditUserAgeWidget(
    modifier: Modifier = Modifier,
    userAge: Int? = null,
    onValueChanged: (String) -> Unit
){
    Column(
        modifier = modifier
    ) {
        Text(modifier = Modifier.fillMaxWidth(), text = stringResource(id = R.string.please_input_user_age))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = userAge.toString(),
            onValueChange = onValueChanged,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}


@Composable
fun ShowUserInfo(
    modifier: Modifier = Modifier,
    userInfo: UserBean
){
    Text(modifier = modifier, text = userInfo.toString())
}


@Composable
@Preview(widthDp = 320, heightDp = 640)
fun PreviewHome() {
    //CounterScreen()
}