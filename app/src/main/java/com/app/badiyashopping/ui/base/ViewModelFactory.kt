package com.app.badiyashopping.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.badiyashopping.repository.AuthRepository
import com.app.badiyashopping.repository.BaseRepository
import com.app.badiyashopping.repository.HomeRepository
import com.app.badiyashopping.viewmodels.AuthViewModel
import com.app.badiyashopping.viewmodels.HomeViewModel

/**
 * Created by Bhargav Jambukiya on 22-012-2020.
 * */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository as HomeRepository) as T
//            modelClass.isAssignableFrom(MyProductsViewModel::class.java) -> MyProductsViewModel(repository as MyProductsRepository) as T
//            modelClass.isAssignableFrom(MyBidsViewModel::class.java) -> MyBidsViewModel(repository as MyBidsRepository) as T
//            modelClass.isAssignableFrom(NotificationsViewModel::class.java) -> NotificationsViewModel(repository as NotificationRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }

}