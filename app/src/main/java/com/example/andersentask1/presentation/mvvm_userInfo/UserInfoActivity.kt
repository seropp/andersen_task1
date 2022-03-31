package com.example.andersentask1.presentation.mvvm_userInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.andersentask1.R
import com.example.andersentask1.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {

    private lateinit var vm: UserInfoVIewModel
    private lateinit var binding: ActivityUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this, UserInfoVIewModelFactory(this))[UserInfoVIewModel::class.java]

        vm.nameLiveData.observe(this, Observer { binding.tvUserName.text = it })
        vm.lastNameLiveData.observe(this, Observer { binding.tvUserLastName.text = it })
        vm.ageLiveData.observe(this, Observer { binding.tvUserAge.text = it.toString() })

        binding.btnSaveData.setOnClickListener {
            val name = binding.etName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val age = if(binding.etAge.text.toString() != "") binding.etAge.text.toString().toInt() else 0
            vm.save(name = name, lastName = lastName, age = age)
        }

        binding.btnGetData.setOnClickListener {
            vm.load()
        }
    }
}