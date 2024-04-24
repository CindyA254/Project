package com.example.myapplication5.ui.theme.screens.customerScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication5.Models.Customers
import com.example.myapplication5.ViewModels.CustomerViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CustomerScreen(viewModel: CustomerViewModel) {
    val customers by viewModel.customers.observeAsState()

    Scaffold(
        topBar = { AppBar() }
    ) {
        CustomerList(customers)
    }
}

@Composable
fun AppBar() {
    TopAppBar(
        title = { Text(text = "Customer List") },
        actions = {
            // Add logout button here
        }
    )
}

@Composable
fun CustomerList(customers: List<Customers>?) {
    if (customers.isNullOrEmpty()) {
        Text(text = "No customers available")
    } else {
        LazyColumn {
            items(customers) { customer ->
                CustomerListItem(customer)
            }
        }
    }
}

@Composable
fun CustomerListItem(customer: Customers) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "Name: ${customer.name}")
            Text(text = "Email: ${customer.email}")
            Text(text = "Phone: ${customer.phoneNumber}")
        }
    }
}

@Preview
@Composable
fun PreviewCustomerScreen() {
    val viewModel = CustomerViewModel()
    CustomerScreen(viewModel = viewModel)
}