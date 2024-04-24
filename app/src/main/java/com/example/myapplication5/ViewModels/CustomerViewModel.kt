package com.example.myapplication5.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.example.myapplication5.Models.Customers


class CustomerViewModel {
    // CustomerViewModel.kt in viewmodel package

    private val _customers = MutableLiveData<List<Customers>>()
    val customers: LiveData<List<Customers>> = _customers

    init {
            // Initialize customers data
            _customers.value = listOf(
                Customers(1, "John Doe", "john@example.com", "1234567890"),
                Customers(2, "Jane Smith", "jane@example.com", "9876543210")
            )
        }

}