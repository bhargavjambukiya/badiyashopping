package com.app.badiyashopping.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.app.badiyashopping.data.network.ApiInterface
import com.app.badiyashopping.databinding.FragmentSignupBinding
import com.app.badiyashopping.repository.AuthRepository
import com.app.badiyashopping.ui.base.BaseFragment
import com.app.badiyashopping.viewmodels.AuthViewModel

class SignupFragment : BaseFragment<AuthViewModel, FragmentSignupBinding, AuthRepository>() {
    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSignupBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        AuthRepository(remoteDataSource.buildApi(ApiInterface::class.java), userPreferences)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvLoginTitle.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
        binding.ivBack.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
    }
}