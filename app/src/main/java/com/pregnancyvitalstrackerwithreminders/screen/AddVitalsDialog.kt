package com.pregnancyvitalstrackerwithreminders.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pregnancyvitalstrackerwithreminders.data.VitalsEntity

@Composable
fun AddVitalsDialog(
    onDismiss: () -> Unit,
    onSubmit: (VitalsEntity) -> Unit
) {
    var sys by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("") }
    var hr by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var kicks by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Card {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Add Vitals",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4B187B),
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Row for Sys and Dia BP
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = sys,
                        onValueChange = { sys = it },
                        label = { Text("Sys BP") },
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp), // make text fields taller
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next)
                    )
                    OutlinedTextField(
                        value = dia,
                        onValueChange = { dia = it },
                        label = { Text("Dia BP") },
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Heart Rate
                OutlinedTextField(
                    value = hr,
                    onValueChange = { hr = it },
                    label = { Text("Heart Rate") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next)
                )

                // Weight
                OutlinedTextField(
                    value = weight,
                    onValueChange = { weight = it },
                    label = { Text("Weight") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Next)
                )

                // Baby Kicks
                OutlinedTextField(
                    value = kicks,
                    onValueChange = { kicks = it },
                    label = { Text("Baby Kicks") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val vitals = VitalsEntity(
                            sysBP = sys.toIntOrNull() ?: 0,
                            diaBP = dia.toIntOrNull() ?: 0,
                            heartRate = hr.toIntOrNull() ?: 0,
                            weight = weight.toFloatOrNull() ?: 0f,
                            babyKicks = kicks.toIntOrNull() ?: 0
                        )
                        onSubmit(vitals)
                        onDismiss()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp), // make button taller
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C4DBA))
                ) {
                    Text(
                        "Submit",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }
            }
        }
    }
}


