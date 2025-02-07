package fi.oamk.calorieapp.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun GenderChoices(male: Boolean, setGenderMale:(Boolean)->Unit) {
    Column {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = male,
                onClick = {setGenderMale(true)}
            )
            Text(text = "Male")
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !male,
                onClick = {setGenderMale(false)}
            )
            Text(text = "Female")
        }
    }
}
