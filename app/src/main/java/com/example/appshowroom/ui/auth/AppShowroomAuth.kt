package com.example.appshowroom.ui.auth

import android.content.Context
import com.example.appshowroom.data.model.ActionState
import com.example.appshowroom.data.repository.AuthRepository
import kotlinx.coroutines.*

object AppShowroomAuth {
    fun logout(context: Context, callback: ((ActionState<Boolean>)-> Unit)? = null){
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main){
                if (callback != null) callback.invoke(resp)
            }
        }
    }
}