package com.app.badiyashopping.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.app.badiyashopping.R
import com.app.badiyashopping.data.network.AuthApi
import com.app.badiyashopping.databinding.FragmentLoginBinding
import com.app.badiyashopping.repository.AuthRepository
import com.app.badiyashopping.ui.activity.HomeActivity
import com.app.badiyashopping.ui.base.BaseFragment
import com.app.badiyashopping.ui.startNewActivity
import com.app.badiyashopping.viewmodels.AuthViewModel

class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {
    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        AuthRepository(remoteDataSource.buildApi(AuthApi::class.java), userPreferences)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvSignupTitle.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_signupFragment)
        }

        binding.btnLogin.setOnClickListener {
            requireActivity().startNewActivity(HomeActivity::class.java)
        }

        binding.tvForgotTitle.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }
    }
}