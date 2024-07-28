package com.example.spacexassignment.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.spacexassignment.databinding.FragmentStoreBinding
import com.example.spacexassignment.viewmodels.LaunchMissionViewModel

class StoreFragment : Fragment() {
    private lateinit var binding: FragmentStoreBinding
    private lateinit var webView: WebView
    private val viewModel: LaunchMissionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = binding.webView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                binding.viewProgress.visibility = View.GONE
                binding.webView.visibility = View.VISIBLE
                super.onPageFinished(view, url)
            }
        }

        if(viewModel.webViewStateRetain.isEmpty.not()){
            webView.restoreState(viewModel.webViewStateRetain)
        }else{
            viewModel.url.let {
                webView.loadUrl(it)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        webView.saveState(outState)
        viewModel.setWebViewState(outState)
        super.onSaveInstanceState(outState)
    }
}
