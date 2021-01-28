package com.nobeldhar.blooddonation.ui.comments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nobeldhar.blooddonation.R
import com.nobeldhar.blooddonation.data.local.entities.Comment
import com.nobeldhar.blooddonation.databinding.FragmentCommentsBinding
import com.nobeldhar.blooddonation.factory.AppViewModelFactory
import com.nobeldhar.blooddonation.ui.reply.ReplyViewModel
import com.nobeldhar.blooddonation.ui.updatecomment.UpdateComViewModel
import com.nobeldhar.blooddonation.utils.CustomOnClickListener
import com.nobeldhar.blooddonation.utils.Resource
import com.nobeldhar.blooddonation.utils.SharedPrefsHelper
import com.nobeldhar.blooddonation.utils.ViewUtils
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CommentsFragment : DaggerFragment(), View.OnClickListener, CustomOnClickListener,
    SwipeRefreshLayout.OnRefreshListener {
    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    @Inject
    lateinit var prefsHelper: SharedPrefsHelper
    private val viewModel: CommentsViewModel by viewModels { viewModelFactory }
    private val replyViewModel: ReplyViewModel by viewModels { viewModelFactory }
    private val updateComViewModel: UpdateComViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentCommentsBinding
    private var postId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comments, container, false)
        binding.viewModel = viewModel
        binding.commentSwipe.setOnRefreshListener(this)
        binding.btComment.setOnClickListener(this)
        postId = arguments?.let { CommentsFragmentArgs.fromBundle(it) }?.postId!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getComments()
    }

    private fun getComments() {
        postId.let { viewModel.getComments(it) }?.observe(viewLifecycleOwner, Observer {
            binding.commentSwipe.isRefreshing = false
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    progressVisibility(View.GONE)
                    val response = it.data
                    if (response?.status == true) {
                        if (response.comments.isNullOrEmpty())
                            Log.d(TAG, "getComments: empty")
                        binding.commentRecycler.adapter = prefsHelper.getUser()?.let { it1 -> CommentsAdapter(response.comments, this, it1.id) }
                    }
                    Log.d(TAG, "commentOnPost: comment failed")
                }
                Resource.Status.ERROR -> {
                    progressVisibility(View.GONE)
                    Log.d(TAG, "onActivityCreated: networkError " + it.isNetworkError)
                    it.isNetworkError?.let { it ->
                        if (it) {
                            ViewUtils.toastNoInternet(requireActivity(), requireContext())
                        }
                    }
                }

                Resource.Status.LOADING ->
                    progressVisibility(View.VISIBLE)
            }
        })
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btComment -> {
                commentOnPost()
                Log.d(TAG, "onClick: commentClicked")
            }
        }
    }

    private fun commentOnPost() {
        postId?.let {
            Log.d(TAG, "commentOnPost: postId not null")
            viewModel.commentOnPost(it) }?.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {

                    val response = it.data
                    if (response?.status == true) {
                        getComments()
                    } else
                        progressVisibility(View.GONE)
                    Log.d(TAG, "commentOnPost: comment failed")
                }
                Resource.Status.ERROR -> {
                    progressVisibility(View.GONE)
                    Log.d(TAG, "onActivityCreated: networkError " + it.isNetworkError)
                    it.isNetworkError?.let { it ->
                        if (it) {
                            ViewUtils.toastNoInternet(requireActivity(), requireContext())
                        }
                    }
                }

                Resource.Status.LOADING ->
                    progressVisibility(View.VISIBLE)
            }
        })
    }

    private fun progressVisibility(visibility: Int) {
        binding.pbComment.visibility = visibility
    }

    companion object {
        private const val TAG = "CommentsFragment"
    }

    override fun onMainCommentReply(comment: Comment) {
        findNavController().navigate(CommentsFragmentDirections.actionNavCommentsToNavReply(true, comment, postId = postId))
    }

    override fun onChildCommentReply(comment: Comment, child: Comment.Child) {
        findNavController().navigate(CommentsFragmentDirections.actionNavCommentsToNavReply(false, comment, child, postId))
    }

    override fun onMainCommentUpdate(comment: Comment) {
        findNavController().navigate(CommentsFragmentDirections.actionNavCommentsToNavUpdateCom(true, myComment = comment))
    }

    override fun onChildCommentUpdate(child: Comment.Child) {
        findNavController().navigate(CommentsFragmentDirections.actionNavCommentsToNavUpdateCom(false, myChild = child))
    }


    override fun onRefresh() {
        getComments()
    }
}