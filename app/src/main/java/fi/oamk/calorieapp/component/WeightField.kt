package fi.oamk.calorieapp.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun WeightField(weightInput: String,onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = weightInput,
        onValueChange=onValueChange,
        label={ Text(text="Enter weight") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )
}
