package com.app.badiyashopping.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.badiyashopping.repository.*
import com.app.badiyashopping.viewmodels.AuthViewModel
import com.app.badiyashopping.viewmodels.CategoryViewModel
import com.app.badiyashopping.viewmodels.ProductViewModel
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
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> CategoryViewModel(
                repository as CategoryRepository
            ) as T
            modelClass.isAssignableFrom(ProductViewModel::class.java) -> ProductViewModel(
                repository as ProductRepository
            ) as T
//            modelClass.isAssignableFrom(NotificationsViewModel::class.java) -> NotificationsViewModel(repository as NotificationRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }

}