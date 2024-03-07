import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.foundation.layout.fillMaxSize
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.LocalContentAlpha


class PreferencesPreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreferencesPreview()
        }
    }
}

@Composable
fun PreferencesPreview() {
    var notificationsEnabled by remember { mutableStateOf(true) }
    var syncEnabled by remember { mutableStateOf(true) }
    var attachmentEnabled by remember { mutableStateOf(true) }
    var replyOption by remember { mutableStateOf("Option 2") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            PreferenceItem(
                title = "Notifications",
                summary = "Enable/disable notifications",
                checked = notificationsEnabled,
                onCheckedChange = { notificationsEnabled = it }
            )
            PreferenceItem(
                title = "Sync",
                summary = "Enable/disable sync",
                checked = syncEnabled,
                onCheckedChange = { syncEnabled = it }
            )
            if (syncEnabled) {
                PreferenceItem(
                    title = "Attachment",
                    summary = "Enable/disable attachment",
                    checked = attachmentEnabled,
                    onCheckedChange = { attachmentEnabled = it }
                )
            }
            ListPreferenceItem(
                title = "Reply",
                summary = "Select reply option",
                options = listOf("Option 1", "Option 2", "Option 3"),
                selectedOption = replyOption,
                onOptionSelected = { replyOption = it }
            )
        }
    }
}

@Composable
fun PreferenceItem(
    title: String,
    summary: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable { onCheckedChange(!checked) }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.padding(end = 8.dp)
        )
        Column {
            Text(text = title)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(text = summary)
            }
        }
    }
}

@Composable
fun ListPreferenceItem(
    title: String,
    summary: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable {
            }
    ) {
        Column {
            Text(text = title)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(text = summary)
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = selectedOption)
    }
}

@Preview
@Composable
fun PreferencesPreviewPreview() {
    PreferencesPreview()
}
