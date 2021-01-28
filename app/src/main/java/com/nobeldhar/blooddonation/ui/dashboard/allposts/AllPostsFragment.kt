package com.nobeldhar.blooddonation.ui.dashboard.allposts

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nobeldhar.blooddonation.R
import com.nobeldhar.blooddonation.data.local.entities.Post
import com.nobeldhar.blooddonation.databinding.FragmentAllPostsBinding
import com.nobeldhar.blooddonation.factory.AppViewModelFactory
import com.nobeldhar.blooddonation.ui.dashboard.DashboardFragmentDirections
import com.nobeldhar.blooddonation.utils.CustomOnClickListener
import com.nobeldhar.blooddonation.utils.Resource
import com.nobeldhar.blooddonation.utils.SharedPrefsHelper
import com.nobeldhar.blooddonation.utils.ViewUtils
import dagger.android.support.DaggerFragment
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class AllPostsFragment : DaggerFragment(), SwipeRefreshLayout.OnRefreshListener, CustomOnClickListener {


    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel : AllPostsViewModel by viewModels{ viewModelFactory }

    @Inject
    lateinit var sharedPrefsHelper: SharedPrefsHelper
    private lateinit var binding: FragmentAllPostsBinding
    private var userId: Int? = null
    private var media : MediaPlayer? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all_posts, container, false)
        userId = sharedPrefsHelper.getUser()?.id
        media = MediaPlayer.create(requireContext(), R.raw.like)
        binding.allPostsSwipe.setOnRefreshListener(this)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPosts()
    }

    private fun getPosts() {
        viewModel.getPosts().observe(viewLifecycleOwner, Observer {
            binding.allPostsSwipe.isRefreshing = false
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    val list = it.data
                    Log.d(TAG, "onViewCreated: adapter set")
                    bindAdapter(list)
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

    private fun bindAdapter(list: List<Post>?) {
        list?.let {
            for (post in it){
                try{
                    val parser = SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss", Locale.US)
                    val formatter = SimpleDateFormat("EEE, MMM d, 'at' hh:mm aaa", Locale.US)
                    val output =
                        formatter.format(parser.parse(post.createdAt.replace("T", " ")))
                    post.createdAt = output
                } catch (e: Exception){
                    Log.d(TAG, "bindAdapter: ${e.message}")
                }
                if (post.likes.isNotEmpty()){
                    for (like in post.likes){
                        if (like.userId == userId)
                            post.isLiked = true
                    }
                }
            }
            binding.allPostsRecycler.adapter =PostAdapter(it, this)
            progressVisibility(View.GONE)
        }
    }

    private fun progressVisibility(visibility: Int) {
        binding.pbAllPosts.visibility = visibility
    }

    companion object {
        private const val TAG = "AllPostsFragment"
    }

    override fun onRefresh() {
        getPosts()
        getPosts()
    }

    override fun onCommentsClicked(post: Post) {
        val action = DashboardFragmentDirections.actionNavDashboardToNavComments(post.id)
        findNavController().navigate(action)
    }

    override fun onInterestedClicked( post: Post) {
        media?.start()
        likePost(post)
        Log.d(TAG, "onInterestedClicked: Clicked")
    }

    private fun likePost(post: Post) {
        viewModel.likePost(post).observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (it.data?.status == true){
                        Toast.makeText(requireContext(), it.data.messages.toString(), Toast.LENGTH_SHORT).show()
                    }
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

    override fun onDestroy() {
        super.onDestroy()
        media?.stop()
        media?.release()
    }

}