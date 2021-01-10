package com.app.badiyashopping.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.app.badiyashopping.UserPreferences
import com.app.badiyashopping.data.network.RemoteDataSource
import com.app.badiyashopping.repository.BaseRepository
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern

/**
 * Created by Bhargav Jambukiya on 10-01-2021.
 */
abstract class BaseActivity<VM : ViewModel, B : ViewBinding, R : BaseRepository> :
    AppCompatActivity() {

    protected lateinit var userPreferences: UserPreferences

    protected lateinit var binding: B
    protected lateinit var viewModel: VM
    protected val remoteDataSource = RemoteDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userPreferences = UserPreferences(this)
        binding = getActivityBinding(layoutInflater)
        val factory = ViewModelFactory(getActivityRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
//        return binding.root

    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getActivityBinding(inflater: LayoutInflater): B

    abstract fun getActivityRepository(): R


    open fun showSnackBar(message: String, view: View) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        snackbar.show()
    }

    /**
     * Check Email is valid or not
     *
     * @param email - email
     * @return - true if email is valid else false
     */
    open fun isEmailValid(email: String?): Boolean {
        val regex =
            "[A-Z0-9a-z]+([._%+-]{1}[A-Z0-9a-z]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    open fun hideKeyBoard(view: View?) {
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}