package com.example.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import com.example.login.databinding.ActivityHelpBinding
import androidx.compose.ui.tooling.preview.Preview
import androidx.test.core.app.ApplicationProvider




class HelpFragment : Fragment() {

    private var _binding: ActivityHelpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.helpTextView.text = "This app is meant to help with keeping track of your tasks."
    }
}

@Composable
fun HelpFragmentContent() {
    Column {
        Text(text = "This app is meant to help with keeping track of your tasks.")
    }
}

@Preview
@Composable
fun HelpFragmentPreview() {
    HelpFragmentContent()
}

