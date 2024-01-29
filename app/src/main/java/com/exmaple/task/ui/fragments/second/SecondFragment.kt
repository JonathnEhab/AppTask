package com.exmaple.task.ui.fragments.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.exmaple.task.R
import com.exmaple.task.databinding.SecondFragmentBinding
import com.exmaple.task.ui.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {
    var _binding : SecondFragmentBinding?= null
    val binding get() = _binding!!
    private val viewModel: PostViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater
                              , container: ViewGroup?
                              , savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.second_fragment , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = SecondFragmentBinding.bind(view)
        val postId = arguments?.getString("postId") ?: -1
        viewModel.getPostDetails(postId as String)
        viewModel.postDetails.observe(viewLifecycleOwner) { postDetails ->
            // Update UI with postDetails
            // For example:
            binding.textTitle.text = postDetails.title
            binding.textBody.text = postDetails.body
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}