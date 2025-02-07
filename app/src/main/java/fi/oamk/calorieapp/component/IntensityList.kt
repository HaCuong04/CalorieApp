package fi.oamk.calorieapp.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize

@Composable
fun IntensityList(onClick: (Float) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Light") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val items = listOf("Light","Usual","Moderate","Hard","Very hard")
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    Column {
        OutlinedTextField(
            readOnly = true,
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = { Text("Select intensity") },
            trailingIcon = {
                Icon(icon, "Select intensity",
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            items.forEach { item ->
                val intensity: Float = when (item) {
                    "Light" -> 1.3f
                    "Usual" -> 1.5f
                    "Moderate" -> 1.7f
                    "Hard" -> 2f
                    "Very hard" -> 2.2f
                    else -> 0.0f
                }
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onClick(intensity)
                        selectedText = item
                        expanded = false
                    }
                )
            }

        }
    }
}