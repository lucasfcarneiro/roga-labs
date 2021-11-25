package com.lucasfagundes.roga_labs.feature.posts.presentation.model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.lucasfagundes.roga_labs.databinding.CommentDialogBinding
import com.lucasfagundes.roga_labs.feature.posts.presentation.adapter.CommentListAdapter

class CommentDialogFragment : DialogFragment() {

    private lateinit var binding: CommentDialogBinding
    var postTitle : String = ""
    var commentList: List<CommentModel> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CommentDialogBinding.inflate(inflater,container,false)
        setWindowFeatures()
        return binding.root
    }

    private fun setWindowFeatures() {
        dialog?.apply {
            window?.decorView?.setBackgroundResource(android.R.color.transparent)
            val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
            val height = (resources.displayMetrics.heightPixels * 0.85).toInt()
            window?.setLayout(
                width,height
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.postTitleDialog.text = postTitle
        handleRecyclerView()
    }

    private fun handleRecyclerView() {
        val commentAdapter = CommentListAdapter(commentList)
        binding.commentDialogRecyclerView.adapter =commentAdapter
    }

}